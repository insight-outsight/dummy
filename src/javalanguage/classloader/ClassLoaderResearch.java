package javalanguage.classloader;


public class ClassLoaderResearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * char[] c = "1234567890".toCharArray(); 
		 * String s = new String(0, 10, c);
		 */
		
		//jdk 1.7中不能这样写，1.6可以
/*		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		for (int i = 0; i < urls.length; i++) {
			System.out.println(urls[i].toExternalForm());
		}*/

		System.out.println(System.getProperty("java.ext.dirs"));
		ClassLoader extensionClassloader = ClassLoader.getSystemClassLoader().getParent();
		System.out.println("the parent of extension classloader : "
				+ extensionClassloader.getParent());
		System.out.println(System.getProperty("java.class.path"));
		
		//jdk 1.7中不能这样写，1.6可以
/*		System.out.println("the Launcher's classloader is "
				+ sun.misc.Launcher.getLauncher().getClass().getClassLoader());*/
		
		System.out.println(System.class.getClassLoader());
		System.out.println(Thread.currentThread().getContextClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader().getClass().getName());
		System.out.println(Thread.currentThread().getContextClassLoader()==ClassLoader.getSystemClassLoader());	

	       ClassLoader loader = ClassLoaderResearch.class.getClassLoader();
	        while(loader!=null){
	            System.out.println(loader);
	            loader = loader.getParent();
	        }
	}

}
