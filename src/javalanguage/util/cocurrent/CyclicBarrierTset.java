package javalanguage.util.cocurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTset {

	public static void main(String[] args) {
		new Solver(new float[][]{{2.1f,3.2f,4.0f},{3f,2f,5f,77f},{3.1415926f}});
		System.out.println("Program exit.");
	}

	
	 static class Solver {
		   final int N;
		   final float[][] data;
		   final CyclicBarrier barrier;
		   volatile boolean isFound = false;
		   
		   class Worker implements Runnable {
		     int myRow;
		     Worker(int row) { myRow = row; }
		     public void run() {
		       while (!done()) {
		         try {
		        	 processRow(myRow);
		             barrier.await();
		         } 
		         catch (InterruptedException ex) {
		           return;
		         } 
		         catch (BrokenBarrierException ex) {
		           return;
		         }
		       }
		     }
		   }
		   
		   boolean done(){
			   return isFound;
		   }
		   
		   void processRow(int i) throws InterruptedException{
			   System.out.println("processing"+i);
			   TimeUnit.SECONDS.sleep(5);
			   if(i == 2){
				   isFound = true;
				   System.out.println("Found!");
			   }
		   }
		   
		   public Solver(float[][] matrix) {
		     data = matrix;
		     N = matrix.length;
		     Runnable barrierAction = new Runnable() { 
		    	 public void run() { mergeRows(); 
		    	 }
		     };
		     barrier = new CyclicBarrier(N, barrierAction);

		     List<Thread> threads = new ArrayList<Thread>(N);
		     for (int i = 0; i < N; i++) {
		       Thread thread = new Thread(new Worker(i));
		       threads.add(thread);
		       thread.start();
		     }

		     // wait until done
/*		     for (Thread thread : threads){
				try {
					thread.join();
				} 
		     	catch (InterruptedException e) {
					System.err.println("joined error");
					e.printStackTrace();
				}
		     }*/
		   }
		 
		   void mergeRows(){
			   System.out.println("Task completion !");
		   }
	 }
		
}
