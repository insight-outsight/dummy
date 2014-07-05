package javalanguage.util.cocurrent;

public class Versatile {

	public static void main(String[] args) {
		new Thread(new Runnable(){

			@Override
			public void run() {
				int i=30;
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
