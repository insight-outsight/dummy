package javalanguage.classloader.类变量与实例变量初始化时机;

public class TsetBean {

	static {
		System.out.println("TsetBean static block executed");
	}
	
	private static StaticNestedBean nb = new StaticNestedBean();
	
	private InstanceNestedBean dnb = new InstanceNestedBean();
	
	public static void p(){
		System.out.println("method p() executed ");
	}
	
}
