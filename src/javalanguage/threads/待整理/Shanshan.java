package javalanguage.threads.待整理;


public class Shanshan /*extends Thread*/ {

	public boolean stop = false;

	public static void main(String[] args) throws InterruptedException {
		ThreadJoin2 t2 = new ThreadJoin2();
        t2.start();
		
        ThreadJoin t = new ThreadJoin();
        t.start();
        
        Thread.sleep(2000);
        
        System.out.println("main join start");
        System.out.println(System.currentTimeMillis());
        t2.join(2000);  
        System.out.println(System.currentTimeMillis());
        System.out.println("main join end");
		
	}

/*	public void run() {
		while (!this.stop) {
			try {
				Thread.yield();
				interrupt();
				} 
			catch (InterruptedException e) {
					System.out.println("t1 is Interrupting只......");
			}
		}
		System.out.println("t1 is end");
	}*/

}

class ThreadJoin extends Thread {
    public void run() {
            System.out.println("ThreadJoin实例开始run");
       
            try {
                
                for (int i = 0; i < 5; i++) {
                	Thread.sleep(1000);
                    System.out.println("在 ThreadJoin实例中运行循环" + i);
                }
            } 
            catch (InterruptedException e) {
            	System.out.println(this.getName()+"exception ^_^");
            }

            System.out.println("ThreadJoin实例结束run");
    }
}

class ThreadJoin2 extends Thread {
    public void run() {
        //synchronized (this) {
            System.out.println("ThreadJoin2实例开始run");
            try {
                
                for (int i = 0; i < 5; i++) {
                	Thread.sleep(1000);
                    System.out.println("在 ThreadJoin2实例中运行循环" + i);
                }
            } 
            catch (InterruptedException e) {
            	System.out.println(this.getName()+"exception ^_^");
            }
            System.out.println("ThreadJoin2实例结束run");
        //}
    }
}

class PrimeThread extends Thread {
	long number;

	PrimeThread(long number) {
		this.number = number;
	}

	public void run() {
		System.out.println(toString());
		if (number > 3) {
			for (int i = 2; i <= number / 2; i++) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (number % i == 0) {
					System.out.println(number + " not prime");
					return;
				}
			}
		}
		System.out.println(number + " is prime");
	}
}

class SThread extends Thread {
	Integer[] cc;

	SThread(Integer[] cc) {
		this.cc = cc;
	}

	public void run() {
		System.out.println(toString());
		while (true) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("===" + System.currentTimeMillis());
			cc[0]++;
		}

	}
}
