package javalanguage.classloader.类变量与实例变量初始化时机;



/**
 * 
 * 当一个类被第一次使用时，它需要被类加载器加载，当类加载到内存之后，依据该类的使用情况分为:而加载过程涉及：
 * 1，如果仅使用类的元数据信息，如Xxx.class.getName(),那么直接从方法区获取即可，
 * 不会对类进行任何初始化（包换静态域、实例域、构造器）
 * 
 * 2，如果是通过调用类的静态变量或者静态方法，那么会执行以下初始化
 * （1）在加载一个类时，如果它的父类还未被加载，那么其父类必须先被加载，对父类执行（2）步骤中所述的初始化
 * （2）对本类，按照在代码中的出现顺序执行它的静态数据域和静态块。
 * 
 * 3，如果是通过创建该类的实例，那么会执行以下初始化
 * （1）执行2中的所有步骤
 * （2）如是有父类，对父类，按照在代码中出现顺序初始化实例数据域和实例块
 * （3）调用父类的构造函数
 * （4）对本类，执行按照在代码中出现顺序初始化实例数据域和实例块
 * （5）调用本类的构造函数
 
 * @author u0007
 *
 */

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
