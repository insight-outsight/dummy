package javalanguage.threads.racecondition;

public class RaceCondition {
	
	private volatile int i = 0;

	public /*synchronized*/ void increase() {
		i++;//非原子操作，存在多线程不安全问题
	}

	public int getValue() {
		return i;
	}
	
}