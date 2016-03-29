package design_pattern.singleton;

import java.util.concurrent.CountDownLatch;

public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountDownLatch countDownLatch = new CountDownLatch(1);
		for(int i=0;i<5;i++){
			new TestSingletonThread(countDownLatch).start();
		}
		System.out.println("main sleep start");

//		饿汉模式下，通过提前调用单例类的其它方法，使得单例类提前创建单例对象，避免后续多个线程阻塞。
		SingletonHungry.warmUp();
//		饿汉模式下，通过提前调用SingletonHungry.class.getName()并不会提前创建单例对象
//		System.out.println(SingletonHungry.class.getName());

		
//		懒汉模式下，提前调用单例类的其它方法，不会创建单例对象。
//		SingletonLazy.warmUp();
//		懒汉模式(使用Holder)下，提前调用单例类的其它方法，也不会创建单例对象。
//		SingletonLazyWithInnerHolder.warmUp();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main sleep end");
		countDownLatch.countDown();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i=0;i<5;i++){
			new TestSingletonThread(countDownLatch).start();
		}
	}
	
	private static class TestSingletonThread extends Thread{
		
		private CountDownLatch countDownLatch = null;
		
		public TestSingletonThread(CountDownLatch countDownLatch){
			this.countDownLatch = countDownLatch;
		}
		
		public void run(){
			try {
				countDownLatch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long startTime = System.currentTimeMillis();
//			SingletonLazyWithInnerHolder sg = SingletonLazyWithInnerHolder.getInstance();
//			SingletonLazy sg = SingletonLazy.getInstance();
			SingletonHungry sg = SingletonHungry.getInstance();
			System.out.println(getName()+"耗时："+(System.currentTimeMillis()-startTime)+"ms");
		}
		
	}

}
