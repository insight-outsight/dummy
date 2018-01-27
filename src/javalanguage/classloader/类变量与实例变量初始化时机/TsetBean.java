package javalanguage.classloader.类变量与实例变量初始化时机;

public class TsetBean {

	static {
		System.out.println("TsetBean static block executed");
	}
	
	
	TsetBean(){
		System.out.println("construct ok...");
	}
	
	private static StaticNestedBean nb = new StaticNestedBean();
	
	private InstanceNestedBean dnb = new InstanceNestedBean();
	private CopyOfInstanceNestedBean cdnb = new CopyOfInstanceNestedBean();
	
	public static void p(){
		System.out.println("method p() executed ");
	}
	
	//放下面new TsetBean();之前，Laucher.main方法中调用TsetBean.p()会得到s="imString"
//	private static String s = "imString";

	private static TsetBean INSTANCE = new TsetBean();
	
	public static TsetBean getInstance(){
		return INSTANCE;
	}
	
	//放上面new TsetBean();之后，在Laucher.main方法中调用TsetBean.p()会得到s="imString"
	private static String s = "imString";

	
	private NeedAStaticVariable nasv = new NeedAStaticVariable(s);
	
}
