package javalanguage.threads.racecondition;


public class TestRaceCondition {
	public static void main(String[] args) {
		RaceCondition trc = new RaceCondition();
		for(int i=0;i<100;i++){
			Thread t1 = new Thread(new RaceThread(trc));
			t1.start();
		}
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("last->"+trc.getValue());
	}
}

class RaceThread implements Runnable {
	RaceCondition rc;

	public RaceThread(RaceCondition rc) {
		this.rc = rc;
	}

	public void run() {
		for (int i = 0; i < 2000; i++) {
			rc.increase();
		}
	}
}