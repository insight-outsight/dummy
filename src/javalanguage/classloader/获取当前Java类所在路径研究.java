package javalanguage.classloader;


public class 获取当前Java类所在路径研究 {

	public static void main(String[] args) {

		System.out.println(获取当前Java类所在路径研究.class.getResource(""));
		System.out.println(获取当前Java类所在路径研究.class.getResource("/"));	
		System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
		System.out.println(Thread.currentThread().getContextClassLoader().getResource("javalanguage/classloader/获取当前Java类所在路径研究.class"));
		System.out.println(获取当前Java类所在路径研究.class.getClassLoader().getResource(""));
		System.out.println(ClassLoader.getSystemResource(""));

	}

}
