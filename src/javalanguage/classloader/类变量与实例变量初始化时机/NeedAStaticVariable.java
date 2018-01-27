package javalanguage.classloader.类变量与实例变量初始化时机;

public class NeedAStaticVariable {
	
	private String s;

	public NeedAStaticVariable(String s) {
		super();
		this.s = s;
		System.out.println("["+this.getClass().getSimpleName()+"] property 's' is "+s);
	}
	
	

}
