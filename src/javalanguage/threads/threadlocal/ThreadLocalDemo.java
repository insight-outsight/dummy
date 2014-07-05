package javalanguage.threads.threadlocal;


/**
 * 测试包含ThreadLocal类型变量的类对象
 * @author Administrator
 *
 */
public class ThreadLocalDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("当前线程组所有线程数："+Thread.activeCount());
		new Run().start();
		new Run().start();
		new Run().start();
		System.out.println("当前线程组所有线程数："+Thread.activeCount());
		String[] ewt = new String[3];
		System.out.println(ewt instanceof Object);
		System.out.println(0x61c88647);
		System.out.println(0x61c88647+0x61c88647);
		System.out.println(0x61c88647+0x61c88647+0x61c88647);
		System.out.println(0x61c88647+0x61c88647+0x61c88647+0x61c88647);
		System.out.println(0x61c88647+0x61c88647+0x61c88647+0x61c88647+0x61c88647);
		System.out.println(0x61c88647+0x61c88647+0x61c88647+0x61c88647+0x61c88647+0x61c88647);

	}

}
class Run extends Thread {

	Run() {
	}

	public void run() {
		for(int i=0;i<5;i++)
		System.out.println(this.getName()+"--"+ObjectContainingThreadLocalVariable.getCurrentThreadId());
	}
}