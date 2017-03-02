package javalanguage.what_occurs_when_exception_in_static_block;

public class Launcher {

	public static void main(String[] args) {
		
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("gggg.");
            }
        }));
        
        
        
		new ThreadAaa("Thread-Aaa").start();
		new Thread(new Runnable(){
		
			@Override
			public void run() {
				while(true){
					System.out.println(Thread.currentThread().getName()+"--t1");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}).start();
//		new Thread(new Runnable(){
//			
//			@Override
//			public void run() {
//				while(true){
//					System.out.println(Thread.currentThread().getName()+"--t2");
////					System.out.println(ThrowExceptionInStatic.class);
//					ThrowExceptionInStatic.bee();
//					try {
//						Thread.sleep(2000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//			
//		}).start();
		

	}

}
