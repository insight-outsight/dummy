package javalanguage.classloader.custom;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class NewThreadMyClassLoaderTset {

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 */
	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			InvocationTargetException {

		System.out.println("1-==="
				+ Thread.currentThread().getContextClassLoader());
		System.out.println("from main-getClass.getClassLoader===="
				+ NewThreadMyClassLoaderTset.class.getClassLoader());
		
		MyClassLoader myClassLoader = new MyClassLoader();

//		Thread.currentThread().setContextClassLoader(myClassLoader);

		new NewThread(myClassLoader).start();

		/*
		 * Thread.currentThread().setContextClassLoader(ClassLoader.
		 * getSystemClassLoader());
		 */

		System.out.println("from main-===="
				+ Thread.currentThread().getContextClassLoader());
		try {

			Class class01 = Class
					.forName("javalanguage.classloader.custom.SampleObject");
			System.out.println("from main-====loaded class:"
					+ class01.getCanonicalName());
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}

class NewThread extends Thread {
	ClassLoader cl;

	public NewThread(ClassLoader classLoader) {
		this.cl = classLoader;
	}

	@Override
	public void run() {
//		setContextClassLoader(cl);
		System.out.println("from t-getClass.getClassLoader===="
				+ getClass().getClassLoader());
		System.out.println("from t-===="
				+ Thread.currentThread().getContextClassLoader());

		try {
//			Class class01 = Class
//					.forName("javalanguage.classloader.custom.SampleObject");
			Class class01 = cl.loadClass("javalanguage.classloader.custom.SampleObject");
			
			System.out.println("from t-====loaded class:"
					+ class01.getCanonicalName());

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}
