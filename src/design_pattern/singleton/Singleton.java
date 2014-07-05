package design_pattern.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Singleton  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2197340396438282721L;
	private static Singleton instance = new Singleton();
	
	private Singleton(){
		System.out.println("singleton开始时间"+System.currentTimeMillis());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("singlton结束时间"+System.currentTimeMillis());
	}
	
	public static Singleton getInstance(){
		return instance;
	}
	
	/**
	 * 防止可序列化的单例对象被反序列化后得到另一个对象
	 * @return
	 * @throws ObjectStreamException
	 */
	private Object readResolve() throws ObjectStreamException {
		  // instead of the object we're on, 
		  // return the class variable INSTANCE
		  return instance; 
	}
	 
}
