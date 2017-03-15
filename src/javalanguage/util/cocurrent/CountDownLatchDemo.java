package javalanguage.util.cocurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

	public static void main(String[] args) throws InterruptedException {

		int taskNum = 5;
	    CountDownLatch startSignal = new CountDownLatch(1);
	    CountDownLatch doneSignal = new CountDownLatch(taskNum);

	    for (int i = 0; i < 5; ++i) {// create and start threads
	       new Thread(new Worker(startSignal, doneSignal)).start();
	    }
        doSomethingElse();            // don't let run yet
        startSignal.countDown();      // let all threads proceed
        doSomethingElse();
        doneSignal.await();           // wait for all to finish


	}
	
	private static void doSomethingElse() {
		 System.out.println("doSomethingElse-"+System.currentTimeMillis());
	}

	private static class Worker implements Runnable {
		   private final CountDownLatch startSignal;
		   private final CountDownLatch doneSignal;
		   Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
		     this.startSignal = startSignal;
		     this.doneSignal = doneSignal;
		   }
		   public void run() {
		     try {
		       startSignal.await();
		       doWork();
		       doneSignal.countDown();
		     } catch (InterruptedException ex) {
		    	 
		     } // return;
		   }
		   void doWork() { System.out.println("working,worked,done"); }
	}

}
