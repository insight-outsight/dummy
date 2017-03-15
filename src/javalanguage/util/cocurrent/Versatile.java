package javalanguage.util.cocurrent;

import java.util.concurrent.CountDownLatch;

public class Versatile {

	public static void main(String[] args) throws InterruptedException {
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				int i=5;
				while(i-->0){				
					System.out.println("i am detached");
					
	
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
						
			}
			
		}).start();
		
		System.out.println("goend");

	}

}
