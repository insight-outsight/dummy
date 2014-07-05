package javalanguage.threads.线程嵌套与异步结束;

public class YibuThread extends Thread {

	public void run(){
		System.out.println("开始运行异步线程");
		new QianyigeThread().start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("异步线程被打断");
			e.printStackTrace();
		}
		System.out.println("结束运行异步线程");
	}
}
