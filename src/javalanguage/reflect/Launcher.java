package javalanguage.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class Launcher {

    public static void main(String[] args) {
    	
        System.out.println("i am super!");
        
        IBelle b = new BelleAndBeast();

        IBelle bProxy = (IBelle) JDKReflectDynamicProxyFactory.newProxyInstance(b, new LogInvocationHandler(b));
        bProxy.show("strawberry and pineapple");
        
        IBeast b2 = new BelleAndBeast();
        //下面b2换成b效果一样
        IBeast bProxy2 = (IBeast)  JDKReflectDynamicProxyFactory.newProxyInstance(b2, new LogInvocationHandler(b2));
        //IBeast bProxy2 = (IBeast)  JDKReflectDynamicProxyFactory.newProxyInstance(b2, new LogInvocationHandler(b2));
        System.out.println(bProxy2.eat(234, "mf"));
        
        //b==b2为假
        System.out.println(b == b2);
        //bProxy==bProxy2为假
        System.out.println(bProxy==bProxy2);
        //c1==c2为真
        Class<?> c1 = Proxy.getProxyClass(Thread.currentThread().getContextClassLoader(), b.getClass().getInterfaces());      
        Class<?> c2 = Proxy.getProxyClass(Thread.currentThread().getContextClassLoader(), b2.getClass().getInterfaces());             
        System.out.println(c1 == c2);
        
        //ds2(3,new Integer[]{6,788,99});

/*      String s = String.valueOf(Character.toChars(0x2F81A));
        char[] csss = s.toCharArray();
        //char t = 'a';
        long etw = 9196456790000087676l;
        Character.isLetter('\uf833');
        Character.isLetter(0x1833);
        for(char c:csss){
            System.out.println("*****start*******");
            System.out.format("%x", (short)c);
            System.out.println("******end******");
        }
*/
/*        try {
            ds(4);
        } catch (Throwable ex) {
            Logger.getLogger(JavaApplication1.class.getName()).log(Level.SEVERE, null, ex);
        }
 */
        
        /*        Foo foo = new Foo("这个一个Foo对象！"); 
        Class clazz = foo.getClass(); */
        System.out.println("=================以下演示对proxy代理后的对象再通过reflect进行method.invoke()调用======================================");

    	Class<?> clazz = bProxy.getClass();

        try {
        	Method[] ms = clazz.getDeclaredMethods();
        	for(Method m:ms){
        		System.out.println("methodName:"+m.getName()+",params Count:"+m.getParameterCount());
        	}
			Method showMethod = clazz.getDeclaredMethod("show",String.class); 
			showMethod.invoke(bProxy,"hahaha");
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} 

        
    }
    
    public static void ds(int r) throws Throwable{
        if(r < 5){
            System.out.println("abe");
            throw new Throwable("hahaawoo");
        }
    }
    
    public static void ds2(int r,Object... oss){
    		for(int i=0;i<oss.length;i++){
    			if(oss[i] instanceof Integer){
    				System.out.println(Integer.valueOf(String.valueOf(oss[i]))+10000);
    			}
    		}
            

    }
}



