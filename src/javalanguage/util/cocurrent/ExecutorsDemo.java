package javalanguage.util.cocurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorsDemo {

	public static void main(String[] args) throws InterruptedException {
		int poolSize = 5;
		ExecutorService pool = Executors.newFixedThreadPool(3);  

		final AtomicInteger ai = new AtomicInteger(0);
		
        for(int i=0;i<poolSize;i++){
        	
            pool.execute(new Runnable(){

				@Override
				public void run() {
					int currentRunnerNum = ai.getAndIncrement();
					for(int j=0;j<2;j++){
				        System.out.println(j+"."+Thread.currentThread().getName()+"****" +currentRunnerNum+ "***正在执行。。。"); 
						try {
							TimeUnit.MILLISECONDS.sleep(2000);
						} 
						catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
            	
            });  

        }
        Runtime.getRuntime().addShutdownHook(new Thread(){
        	public void run() {  
                try {  
                    Thread.sleep(2000);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
                System.out.println("thread two doing something.");  
            }
        });
        System.out.println(Thread.currentThread().getName() + "主程序退出。。。");  
        System.exit(0);
        System.out.println("fffffffffff");  

        // 关闭线程池  
//        pool.shutdown(); 
//        pool.awaitTermination(2000, TimeUnit.MILLISECONDS);

	}

}
