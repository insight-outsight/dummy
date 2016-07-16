package javalanguage.classloader.类变量与实例变量初始化时机;


public class Launcher {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		
//		只调用.class.XXX()不会加载类
//      System.out.println(TsetBean.class.getName());
//      System.out.println(TsetBean.class.getConstructors().length);
//      System.out.println(TsetBean.class.getModifiers());
//      但Class.forName()会初始化类
//      Class.forName(TsetBean.class.getName());
//		创建对象会初始化静态变量和实例变量
//		TsetBean cbean = new TsetBean();
//		调用类静态方法只会初始化静态变量
		TsetBean.p();
	}
	
	
}
