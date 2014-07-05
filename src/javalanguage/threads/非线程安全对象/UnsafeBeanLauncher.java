package javalanguage.threads.非线程安全对象;

/**
 * 该类用来测试一个非线程安全的JavaBean，
 * 程序有一个共享的变量usb，它被一个InitThread进行初始化，然后在循环中开1000个线程对它分别进行
 * 读和写，令人惊奇的是ReadThread中usb.assertEquality();方法执行操作为
 * 		if(i != i){
 *			throw new AssertionError("竟然会不等。");
 *		}
 * 按道理永远不可能抛出java.lang.AssertionError异常，
 * 但实际运行中，根据JAVA内存模型，由于各个线程都有工作内存，另一个线程更改过i的会后，线程很有可能不会
 * 马上看到，导致usb.assertEquality()会抛出java.lang.AssertionError异常。
 * 【根据不同的JVM环境，出现频率不同，多运行几次肯定会出现。】
 * 
 * @author xu
 * @created 2013-07-11
 */
public class UnsafeBeanLauncher {
	
	static UnsafeBean usb = null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		new InitThread().start();
		for(int i=0;i<1000;i++){
			new ReadThread().start();
			new WriteThread().start();
		}
	}
	
	private static class InitThread extends Thread{
		public void run(){
			usb = new UnsafeBean(5);
		}
	}
	
	private static class ReadThread extends Thread{
		public void run(){
			//System.out.println("ready");
			//由于线程执行顺序无法预知，需要判断是否已初始化。
			if(usb != null)
				usb.assertEquality();
		}
	}
	private static class WriteThread extends Thread{
		public void run(){
			usb.setI(7);
		}
	}

}
