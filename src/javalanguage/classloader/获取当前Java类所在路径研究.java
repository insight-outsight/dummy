package javalanguage.classloader;


public class 获取当前Java类所在路径研究 {

	public static void main(String[] args) {
		System.out.println("-----------------------0-----------------------");
		System.out.println(System.getProperty("java.class.path"));
		System.out.println("-----------------------1-----------------------");
		System.out.println(获取当前Java类所在路径研究.class.getResource(""));
		System.out.println(获取当前Java类所在路径研究.class.getResource("/"));	
		System.out.println(获取当前Java类所在路径研究.class.getResource("/").getFile());	
		System.out.println(获取当前Java类所在路径研究.class.getResource("/").getPath());	
		System.out.println(获取当前Java类所在路径研究.class.getPackage().getName());
		System.out.println("-----------------------2-----------------------");
		System.out.println(获取当前Java类所在路径研究.class.getResource("/javalanguage/classloader/获取当前Java类所在路径研究.class"));	
		System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
		System.out.println(Thread.currentThread().getContextClassLoader().getResource("javalanguage/classloader/获取当前Java类所在路径研究.class"));
		System.out.println(获取当前Java类所在路径研究.class.getClassLoader().getResource(""));
		System.out.println(获取当前Java类所在路径研究.class.getClassLoader().getResource("javalanguage/classloader/获取当前Java类所在路径研究.class"));
		System.out.println(ClassLoader.getSystemResource(""));
		System.out.println("-----------------------3-----------------------");
		//Java如何获取当前class所在jar包的路径?
		//因为程序已经被打包成jar包，所以getPath()和getFile()在这里的返回值是一样的。都是/xxx/xxx.jar这种形式。
		//如果路径包含Unicode字符，还需要将路径转码 path = java.net.URLDecoder.decode(path, "UTF-8");
		String path = 获取当前Java类所在路径研究.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		System.out.println("path="+path);
		String file = 获取当前Java类所在路径研究.class.getProtectionDomain().getCodeSource().getLocation().getFile();
		System.out.println("file="+file);
		

	}

}
