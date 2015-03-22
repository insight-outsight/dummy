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


	}

}
