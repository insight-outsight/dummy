package javalanguage.classloader.classes;

public class ClassTset {

	public static void main(String[] args) {
		Class<String> sc = String.class;
		System.out.println("1."+sc.asSubclass(Object.class));
		System.out.println("2."+sc.asSubclass(String.class));
//		System.out.println("3."+sc.asSubclass(Long.class));//ClassCastException
		
		//注意输出仍是class java.lang.Integer，这是只是作转换，
		System.out.println("4."+Integer.class.asSubclass(Number.class));
//		System.out.println("5."+Number.class.asSubclass(Integer.class));//ClassCastException


		int[] ae = new int[0];
		Class<?> aeClass = ae.getClass();
		System.out.println(aeClass.isArray());//判断类是否是数据，打印true
		System.out.println(aeClass.getComponentType());//获取代表数组的类中数组元素的类型，打印int
		System.out.println("--------y--------");
		Integer[] ae2 = new Integer[1];
		Class<?> ae2Class = ae2.getClass();
		System.out.println(ae2Class.isArray());//打印true
		System.out.println(ae2Class.getComponentType());//打印class java.lang.Integer
		System.out.println("--------xx--------");
		String s = new String("wytw");
		Class<?> sClass = s.getClass();
		System.out.println(sClass.isArray());//打印false
		System.out.println(sClass.getComponentType());//打印null
		
	}

}
