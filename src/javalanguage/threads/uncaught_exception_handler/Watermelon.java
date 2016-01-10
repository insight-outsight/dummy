package javalanguage.threads.uncaught_exception_handler;

public class Watermelon {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("=======start========");
		
		Thread t = new Thread(new Runnable(){

			@Override
			public void run() {
				int i=0;
				while(true){
					try {
						if(i++<5){
							Thread.sleep(500);						
						}
						else{
							throw new RuntimeException("bye bye Alaska");
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(i + " cherish.");
				}
				
			}
			
		});
//		t.setDaemon(true);
		t.setUncaughtExceptionHandler(new WUncaughtExceptionHandler());
		t.start();
		
		System.out.println("================");
		
		int i=0;		
		while(true){	
				if(i++<10){
					try {
						Thread.sleep(500);						
					}catch (InterruptedException e) {
						e.printStackTrace();
					}
				} 	
				else{
					break;
				}
			System.out.println(i + " never back.");
		}
		
	}
	
}
