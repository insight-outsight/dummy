package design_pattern.singleton;

public class Launch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TestThread().start();
		new TestThread().start();
		new TestThread().start();		
		new TestThread().start();
		new TestThread().start();
	}
	
	private static class TestThread extends Thread{
		public void run(){
			System.out.println(getName()+"开始时间"+System.currentTimeMillis());
			Singleton sg = Singleton.getInstance();

			System.out.println(getName()+"结束时间"+System.currentTimeMillis());
		}
		
	}

}
