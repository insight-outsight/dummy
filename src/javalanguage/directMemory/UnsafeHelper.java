package javalanguage.directMemory;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class UnsafeHelper {
	
	private final static Unsafe INSTANCE  = createUnsafeInstance();
	
	private static Unsafe createUnsafeInstance(){
		try {
			Field f = Unsafe.class.getDeclaredField("theUnsafe");
			f.setAccessible(true);
			Unsafe us = (Unsafe) f.get(null);
			return us;
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Unsafe getUnsafeInstance() {
		return INSTANCE;
	}
	

}
