package javalanguage.classloader.类变量与实例变量初始化时机;


public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		只调用.class.XXX()不会加载类
//      System.out.println(TsetBean.class.getName());
//      System.out.println(TsetBean.class.getConstructors().length);
//      System.out.println(TsetBean.class.getModifiers());
//		创建对象会初始化静态变量和实例变量
//		TsetBean cbean = new TsetBean();
//		调用类静态方法只会初始化静态变量
		TsetBean.p();
		doSmt(null);
	}
	
	public static void doSmt(String[] etw){
		try {
			System.out.println("参数数组长度："+etw.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
