package javalanguage.threads.待整理;

import commons.pojo.Cer;


/**
 * 结论，如果一个类T2含有,String类型spd属性和Cer类型cer属性，若有方法
 * m4t1对this加锁，方法m4t2对cer加锁，则两个线程（线程1，线程2）同时
 * 在T2实例上执行，方法m4t2和m4t1并不会同步执行。
 * @author Administrator
 *
 */
public class T2 {
	private byte[] lc = new byte[0];
	private String spd = "spaliding";
	int feed = 71;
	private Cer cer = new Cer()/*{
		private int code = 10;
		public int getCode2(int code) {
			System.out.println("现在值"+code);
			return code;
		}
	}*/;
	
	public void m4t1() {
		synchronized (this) {
			int i = 5;
			while (i-- > 0) {
				System.out
						.println(Thread.currentThread().getName() + " : " + i);
				cer.setCode(i+11111);
				cer.setExplain("o m g"+(5-i)*123);
				spd += i;
				feed+=i;
				try {
					Thread.sleep(500);
				} catch (InterruptedException ie) {
				}
			}
		}
	}

	public /*synchronized*/ void m4t2() {
		synchronized(cer){
			int i = 5;
			while (i-- > 0) {
				System.out.println(Thread.currentThread().getName() + " : " + i);
				System.out.println(Thread.currentThread().getName() + "~~~" 
						+ cer.getCode() + "---->" + spd+ "---->"+ cer.getExplain()
						+ "---->" + feed);
				try {
					Thread.sleep(500);
				} catch (InterruptedException ie) {
				}
			}
		}
	}
	
	public int getCodeOfCer(){
		return cer.getCode();
	}

	public String getExplainOfCer(){
		return cer.getExplain();
	}
	
	public String getSpd(){
		return spd;
	}
	
	public static void main(String[] args) {
		System.out.println(System.getProperty("java.vm.name"));
		final T2 inst = new T2();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				inst.m4t1();
			}
		}, "昆仑山");
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				inst.m4t2();
			}
		}, "通天河");
		t1.start();
		t2.start();
		try {
			t1.join(6000);
			t2.join(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("last    code:"+inst.getCodeOfCer());
		System.out.println("last explain:"+inst.getExplainOfCer());
		System.out.println("last     spd:"+inst.getSpd());
	}
}