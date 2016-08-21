package javalanguage;

import java.util.Map;
import java.util.Properties;


public class SystemVariables {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
/*		Properties prop=new Properties(System.getProperties());        
		//在标准输出中输出系统属性的内容        
		prop.list(System.out);*/
		System.out.println(System.getProperty("file.separator"));
		System.out.println(System.getProperty("user.dir"));
		System.out.println(System.getProperty("user.home"));
		System.out.println(System.getProperty("java.version"));
		
		System.out.println(System.getProperty("java.home"));
		//ExtensionClassLoader加载类所搜索的目录
		System.out.println(System.getProperty("java.ext.dirs"));
		//Windows、Linux中环境变量Path中的内容
		System.out.println(System.getProperty("java.library.path"));
		/* 
		 * java.class.path变量显示内容为SystemClassLoader加载类所搜索的目录：
		 * 
		 * 1.Windows、Linux中命令行使用java javalanguage.SystemVariable显示内容,优先级如下：
		 *  (1)显示缺省值(.),即调用javac或javaw的当前路径(.),是开发的class所存在的当前目录,比如C:\abc\javac MyClass，此时就在C:\abc路径下搜索。
		 *  (2)显示CLASSPATH环境变量设置的路径.如果设置了CLASSPATH,则CLASSPATH的值会覆盖缺省值，记得设置时要包含当前路径(.)。
		 *  (3)显示执行Java的命令行-classpath或-cp的值,如果指定了这两个命令行参数之一,它的值会覆盖环境变量CLASSPATH的值。
		 *
		 *例如：
		 * （1）.在Eclipse的普通JAVA工程中运行javalanguage.SystemVariable则显示类javalanguage.SystemVariable所在Eclipse工作空间目录，
		 *   如:F:\ews\LearningJDK\bin 
		 *   
		 * （2）.在Eclipse的maven工程的src/main/java中运行，得到/Users/eclipseworkspace/a-service/a-service-impl/target/classes:
		 * /Users/eclipseworkspace/a-service/a-service-api/target/classes:/Users/Downloads/Eclipse.app/Contents/
		 * MacOS/~/.m2/repository/commons-configuration/commons-configuration/1.10/commons-configuration-1.10.jar:
		 * /Users/Downloads/Eclipse.app/Contents/MacOS/~/.m2/repository/redis/clients/jedis/2.1.0/jedis-2.1.0.jar
		 * 其中，a-service-impl依赖了a-service-api，而在maven build时选择了Resolve Workspace artifacts， 工程的 Maven Dependencies下出现a-service-api工程，而不是jar，所以会去当前eclipse workspace工程空间寻找类路径/Users/eclipseworkspace/a-service/a-service-api/target/classes
		 * 
		 * （3）在maven工程的src/test/java中运行，得到/Users/eclipseworkspace/a-service/a-service-impl/target/test-classes:
		 * /Users/eclipseworkspace/a-service/a-service-impl/target/classes:/Users/eclipseworkspace/a-service/a-service
		 * -api/target/classes:/Users/Downloads/Eclipse.app/Contents/MacOS/~/.m2/repository/redis/clients/jedis/2.1.0/
		 * jedis-2.1.0.jar
		 * 注意比在src/main/java运行结果多了/Users/eclipseworkspace/a-service/a-service-impl/target/test-classes。
		 */
		System.out.println(System.getProperty("java.class.path"));
		System.out.println(System.getProperty("file.encoding"));
    	System.out.println(System.getProperty("java.io.tmpdir"));
    	
    	System.out.println(System.getProperty("java.vm.name"));
    	System.out.println(System.class.getClassLoader());
    	System.out.println(SystemVariables.class.getClassLoader());
    	System.out.println(Thread.currentThread().getContextClassLoader().getResource("/nio/asyn/"));
    	//System.out.println(SystemVariables.class.getResource("/javalanguage/"));


		//显示系统环境变量
		Map<String,String> envs = System.getenv();
		for(String s :envs.keySet()){
			System.out.println(s+"="+envs.get(s));
		}
		
		System.out.println("------------");
		//显示系统环境变量PATH的值
		System.out.println(System.getenv("PATH"));
		//显示系统环境变量TMP的值
		System.out.println(System.getenv("TMP"));

	}

}
