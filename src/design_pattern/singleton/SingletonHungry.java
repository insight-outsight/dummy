package design_pattern.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class SingletonHungry implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2197340396438282721L;
	
	private static SingletonHungry instance = new SingletonHungry();

	private SingletonHungry(){
		System.out.println(this.getClass().getSimpleName()+"创建开始时间"+System.currentTimeMillis());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.getClass().getSimpleName()+"创建结束时间"+System.currentTimeMillis());
	}
	
	public static SingletonHungry getInstance(){
		return instance;
	}
	
	public static void warmUp(){
		System.out.println(SingletonHungry.class.getSimpleName()+" preheating");
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
