package javalanguage.threads._volatile;


public class Erpao {

	private static volatile boolean flag;

	public static void main(String[] args) {

		System.out.println(System.getProperty("java.vm.name")+System.getProperty("java.version"));	
		VolatileTest vt = new VolatileTest();
		Youyu yy1 = new Youyu(vt);
		Youyu yy2 = new Youyu(vt);
		yy2.setName("独立");
		Youyu yy3 = new Youyu(vt);
		yy1.start();
		yy2.start();
		yy3.start();
		try {
			yy1.join();
			yy2.join();
			yy3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		System.out.println(vt.obtainA());
/*		Thread t = new Thread(new Runnable() {
			public void run() {
				int i = 0;
				while (!flag){
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(i++);
				}
				System.out.println("ended curr:"+System.currentTimeMillis());
			}
		});
		t.start();	
		System.out.println("start curr:"+System.currentTimeMillis());
		try {
			System.out.println("hahahaha");
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		flag = true;*/
	}

}

class VolatileTest {
    private volatile int a;
    public void addA(int count){
        a = a + count;
    }
    public int obtainA(){
    	return a;
    }
}

class Youyu extends Thread{
	VolatileTest 大炮;
	public Youyu(VolatileTest vt ){
		this.大炮 = vt;
	}
	public void run() {
			new Pangxie().start();
			for(int i=0;i<5;i++){			
				try {
					大炮.addA(3);
					System.out.println("<___"+Thread.currentThread().getName()+"____>===:"+System.currentTimeMillis());
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
	}	
}

class Pangxie extends Thread{
	public void run() {
		for(int i=0;i<5;i++){			
			try {
				System.out.println(i+"++++++"+Thread.currentThread().getName()+"++++>===:"+System.currentTimeMillis());
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
}	
}
