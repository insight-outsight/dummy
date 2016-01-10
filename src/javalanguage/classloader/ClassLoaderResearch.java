package javalanguage.classloader;

import java.net.URL;


public class ClassLoaderResearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * char[] c = "1234567890".toCharArray(); 
		 * String s = new String(0, 10, c);
		 */
		
		//jdk 1.7中不能这样写，1.6和1.8可以
		System.out.println("-------------Show bootstrapClassPath------------");
		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		for (int i = 0; i < urls.length; i++) {
			System.out.println(urls[i].toExternalForm());
		}

		System.out.println("-------------ExtClassLoader Info------------");
		System.out.println(System.getProperty("java.ext.dirs"));
		System.out.println("system classloader : "+ ClassLoader.getSystemClassLoader());
		ClassLoader extensionClassloader = ClassLoader.getSystemClassLoader().getParent();
		System.out.println("extension classloader : "+ extensionClassloader);
		System.out.println("the parent of extension classloader : "
				+ extensionClassloader.getParent());
		System.out.println("System.getProperty(\"java.class.path\")= "+System.getProperty("java.class.path"));
		
		
		//jdk 1.7中不能这样写，1.6和1.8可以
		System.out.println("the Launcher's classloader is "
				+ sun.misc.Launcher.getLauncher().getClass().getClassLoader());
		System.out.println("-------------MISC.------------");
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
