package javalanguage.threads.threadlocal;

import java.util.concurrent.atomic.AtomicInteger;

public class ObjectContainingThreadLocalVariable {

	private String myName;
	
	//一个原子整型类型的ID生成变量
	private static final AtomicInteger uniqueId = new AtomicInteger(0);
	
	/*
	 * 与每个线程绑定的一个ThreadLocal变量，每一个线程持有一个该变量
	 * 隐式引用的拷贝，直到该线程结束，当线程结束后，如果该线程持有的
	 * 所有ThreadLocal引用的拷贝实例不再被任何对象引用，它们将会被回
	 * 收。一个线程第一次访问ThreadLocal类型变量get()方法时，将调用
	 * ThreadLocal的initValue()方法初始化与该线程绑定的ThreadLocal
	 * 对象引用，后继调用get()方法将不再调用执行initValue()方法，除非
	 * 在get()方法调用后执行了remove()方法。
	 */	
	private static final ThreadLocal<Integer> uniqueNum = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return uniqueId.getAndIncrement();
		}
	};

	public static int getCurrentThreadId() {
		return uniqueNum.get().intValue();
	}

	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

}
