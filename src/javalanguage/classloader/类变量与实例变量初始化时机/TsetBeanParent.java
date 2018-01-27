package javalanguage.classloader.类变量与实例变量初始化时机;

public class TsetBeanParent {

	static {
		System.out.println("TsetBeanParent static block executed");
	}
	
	private TsetBeanParentInstanceNestedBean dnb = new TsetBeanParentInstanceNestedBean();

	public TsetBeanParent(){
		System.out.println("TsetBeanParent construct ok...");
	}
	
}
