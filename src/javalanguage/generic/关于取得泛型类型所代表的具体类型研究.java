package javalanguage.generic;

import java.awt.datatransfer.StringSelection;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.ws.util.StringUtils;

import commons.pojo.Address;
import commons.pojo.Student;

/**
 * public class Base<T>{
	    Class classType=null;
	    public Base(){
	     //想在这里 得到T的类对象 赋值给 classType
		}
	    public Base(Class classType){
	        //以前用这种方法  但写代码的时候很类
	        this.classType=classType;
		}
	}

	T.getClass()或者T.class都是非法的，因为T是泛型变量。
	由于一个类的类型是什么是在编译期处理的，故不能在运行时直接在Base里得到T的实际类型。
	有一种变通的实现方式：
	import java.lang.reflect.Array;
	import java.lang.reflect.ParameterizedType;
	import java.lang.reflect.Type;
	
	public class Generic extends Base<String> {
	  Object array ;
	  public Generic() {
	   array = Array.newInstance(getGenericType(0), 100);
	  }
	  public static void main(String[] args) {
	   Generic c = new Generic();
	   System.out.println(c.array);
	  }
	 
	  
	}
	
	class Base<T> {
	  public Class getGenericType(int index) {
	    Type genType = getClass().getGenericSuperclass();
	    if (!(genType instanceof ParameterizedType)) {
	     return Object.class;
	    }
	    Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
	    if (index >= params.length || index < 0) {
	     throw new RuntimeException("Index outofbounds");
	    }
	    if (!(params[index] instanceof Class)) {
	     return Object.class;
	    }
	    return (Class) params[index];
	  }
	}
           其中Base<T>是泛型类，在父类中声明getGenericType，子类继承具体的Base<String>，
           那么在子类中就可以通过getGenericType(0)获取到String的class.

 * @author xuzhengchao
 *
 */
public class 关于取得泛型类型所代表的具体类型研究 {

	/**
	 * 遍历打印一个对象的所有属性类型、是否是泛型类型，如果是泛型，打印泛型参数的类型。
	 * @param object
	 */
	private static void showClassFieldType(Object object){
		Class<?> clazz = object.getClass();
		Field[] fs = clazz.getDeclaredFields(); 
	    for(Field f : fs){   

	        Class<?> fieldClazz = f.getType(); 
	      
	        if(fieldClazz.isPrimitive()){
	        	System.out.println(f.getName()+"属性是"+fieldClazz.getName()+"基本类型");
	        }
	        else{
	        	System.out.println(f.getName()+"属性是"+fieldClazz.getName()+"类型");
                Type fc = f.getGenericType(); 
                if(fc instanceof ParameterizedType){ // 如果是泛型参数的类型          
                	  System.out.println(f.getName()+"属性是参数化泛型类型（Parameterized Generic Type）,其泛型参数的类型是");
                      ParameterizedType pt = (ParameterizedType) fc;  
                      Type[] actualTypeArguments = pt.getActualTypeArguments();  
	       	    	   for(int i=0;i<actualTypeArguments.length;i++){
	       	    		   System.out.println("    "+i+"."+actualTypeArguments[i]);
	    	    	   }
                } 
		        if(List.class.isAssignableFrom(fieldClazz)){   

		        }   
		    }  
	    }
	}
	
	/**
	 *
	 * 取得对象泛型类型属性所代表的具体类型
	 * 如：
	 * List<Address,Person> myList;
	 * 调用 getGenericTypeInstance(object, myList)
	 * 返回
	 * [class commons.pojo.Address,
	 * class commons.pojo.Person]
	 * @param object
	 * @param propertyName
	 * @return
	 */
	private static List<Class<?>> getGenericTypeOfProperty(Object object, String propertyName) {

		try {
			Field field = object.getClass().getDeclaredField(propertyName);
			//Type type = field.getType();注意与下面两句的区别
			//Class<?> clazz = field.getType();
			Type type = field.getGenericType();
			
	    	//该属性类型如果是泛型参数的类型 
			if(type instanceof ParameterizedType){
				System.out.println(propertyName+"属性是参数化泛型类型（Parameterized Generic Type）");
				return fillResultList((ParameterizedType) type);
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * 发得对象泛型方法返回值所代表的具体类型
	 * @param readMethod
	 * @return
	 */
	private static List<Class<?>>  getGenericTypeOfMethod(Object object, String methodName, Class<?>... parameterTypes) {
		try {
			Method method = object.getClass().getDeclaredMethod(methodName, parameterTypes);
			Type type = method.getGenericReturnType();	
	    	//该属性类型如果是泛型参数的类型 
			if(type instanceof ParameterizedType){
				System.out.println(methodName+"方法返回类型是参数化泛型类型（Parameterized Generic Type）");
				return fillResultList((ParameterizedType) type);
			}
			else{
				System.out.println(type);
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static List<Class<?>> fillResultList(ParameterizedType type){
		
		List<Class<?>> result = new ArrayList<Class<?>>();
		
		Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();

		for(int i=0;i<actualTypeArguments.length;i++){
				Class<?> c = (Class<?>) actualTypeArguments[i];
				result.add(c);
	    }
		
		return result;
		
	}
	
 	public static void main(String[] args) {
		Student student = new Student();
		showClassFieldType(student);
		System.out.println("+========================================+");
		System.out.println(getGenericTypeOfProperty(student, "id"));
		System.out.println(getGenericTypeOfProperty(student, "name"));
		System.out.println(getGenericTypeOfProperty(student, "htcUntitledSeriesManager"));
		System.out.println(getGenericTypeOfProperty(student, "htcOneSeriesManager"));
		System.out.println(getGenericTypeOfProperty(student, "addresses"));
		System.out.println(getGenericTypeOfMethod(student, "gm"));//打印 T
		System.out.println("////////////////////////////////////////////");
		System.out.println(List.class.isAssignableFrom(ArrayList.class));
		System.out.println("。。"+ArrayList.class.isAssignableFrom(List.class));
		Student student2 = new Student();
		student2.setAddresses(new ArrayList<Address>());
		Class<?> student2AddressesClass = student2.getAddresses().getClass();
		printClassGenericInfo(student2AddressesClass);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		Class<?> htcUntitledSeriesManagerClass = student2.getHtcUntitledSeriesManager().getClass();
		printClassGenericInfo(htcUntitledSeriesManagerClass);
	}

 	/**
 	 * 打印类的泛型相关信息
 	 * @param student2AddressesClass
 	 */
	private static void printClassGenericInfo(Class<?> student2AddressesClass) {
		
		System.out.println(student2AddressesClass);
		System.out.println(student2AddressesClass.getGenericSuperclass());
		Type[] genericInterfaces = student2AddressesClass.getGenericInterfaces();
		for(Type genericInterface:genericInterfaces){
			System.out.println("Type***"+genericInterface);
		}
		
		TypeVariable<?>[] typeVaribale = student2AddressesClass.getTypeParameters();
		for(int i=0;i<typeVaribale.length;i++){
    		System.out.println("----"+i+".TypeParameterVariable***"+typeVaribale[i]);
		}
	}

}
