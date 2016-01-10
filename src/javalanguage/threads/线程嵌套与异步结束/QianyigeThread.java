package javalanguage.threads.线程嵌套与异步结束;

public class QianyigeThread extends Thread {

	public void run(){
		System.out.println("开始运行嵌一个线程");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println("嵌一个线程被打断");
			e.printStackTrace();
		}
		System.out.println("结束运行嵌一个线程");
	}
}
