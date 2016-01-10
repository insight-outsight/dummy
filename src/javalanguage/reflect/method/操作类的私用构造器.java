package javalanguage.reflect.method;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


import design_pattern.singleton.Singleton;

public class 操作类的私用构造器 {

	public static void main(String[] args) {

		Constructor<?>[] c = Singleton.class.getDeclaredConstructors();
		Singleton singleton1 = null;
		Singleton singleton2 = null;
		try {
			c[0].setAccessible(true);
			System.out.println("className="+c[0].getName());
			singleton1 = (Singleton)c[0].newInstance();
			singleton2 = (Singleton)c[0].newInstance();
		} catch (InstantiationException e) {
			System.out.println("1");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.out.println("2");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println("3");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			System.out.println("4");
			e.printStackTrace();
		}
		System.out.println(singleton1==singleton2);
		
	}
	
}
