package javalanguage.threads.线程嵌套与异步结束;

import javalanguage.threads.线程嵌套与异步结束.YibuThread;


/**
 * 本类用来研究线程之间嵌套调用的关系与异步结束。
 * 1.当在main线程中启动一个YibuThread线程，而YibuThread线程中又启动了一个QianyigeThread线程，
 * YibuThread线程和QianyigeThread线程将作为子线程异步执行，当主线程执行完后，子线程仍会继续运行直到它们结束。
 * 2.使用exit会终止程序，会直接结束当前线程及所有正在运行的子线程。
 * @author zcx
 *
 */
public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		System.out.println("=========测试开始=========");
		YibuThread ybt = new YibuThread();
		ybt.start();
		System.out.println("-------------一次------------------");
		System.out.println("-------------二次------------------");
		try {
			ybt.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("YibuThread线程已经结束。。。");
		System.out.println("-------------三次------------------");
		System.out.println("-------------四次------------------");
		System.out.println("主线程结束！");	
		//使用exit会终止程序，会直接结束当前线程及所有正在运行的子线程。
		//System.exit(0);

	}

}
