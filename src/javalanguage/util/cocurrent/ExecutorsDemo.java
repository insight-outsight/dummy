package javalanguage.util.cocurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorsDemo {

	public static void main(String[] args) throws InterruptedException {
		int poolSize = 2;
//		ExecutorService pool = Executors.newFixedThreadPool(poolSize);  
		ExecutorService pool = new ThreadPoolExecutor(poolSize, poolSize, 
				0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(1));

		final AtomicInteger ai = new AtomicInteger(0);
		
        for(int i=0;i<poolSize+2;i++){
        	
            try {
				pool.execute(new Runnable(){

					@Override
					public void run() {
						int currentRunnerNum = ai.getAndIncrement();
						for(int j=0;j<Integer.MAX_VALUE;j++){
							if (!Thread.interrupted()) { 
						        System.out.println(j+"."+Thread.currentThread().getName()+"****" +currentRunnerNum+ "***正在执行。。。"); 
								try {
									TimeUnit.MILLISECONDS.sleep(2000);
//							if(j==4)return;
								} 
								catch (InterruptedException e) {
//								System.out.println("我被中断，但我不响应，继续运行。");
									e.printStackTrace();
									System.out.println("我被中断，我响应，结束运行。");
//							break; 
									Thread.currentThread().interrupt(); 
								}
							}
							else{
								break;
							}
						}
					}
					
				});
			} catch (Exception e) {
				System.out.println("提交任务出错");
				e.printStackTrace();
			}  

        }


        Runtime.getRuntime().addShutdownHook(new Thread(){
        	public void run() {  
                try {  
                    Thread.sleep(2000);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
                System.out.println("shutdown hook thread end.");  
            }
        });
        
        Thread.sleep(1000);  

        pool.shutdown();
//        pool.shutdownNow();

        pool.awaitTermination(2000, TimeUnit.MILLISECONDS);
//        System.out.println(Thread.currentThread().getName() + "主程序退出。。。");  
//        System.exit(0);
        System.out.println("fffffffffff"+Integer.MAX_VALUE+","+(Integer.MAX_VALUE+1)+","+((Integer.MAX_VALUE+1)==Integer.MIN_VALUE));
        System.out.println("一"+Integer.toBinaryString(-1));
        System.out.println("二"+Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println("三"+Integer.toBinaryString(Integer.MIN_VALUE));
        long b1=2147483648l;
        long b2=2147483659l;

        Integer a1 = Integer.MAX_VALUE+1;
        Integer a2 = Integer.MAX_VALUE+2;
        Integer a3 = (int)b2;
        Integer a4 = new Long(b1).intValue();
        System.out.println("111,"+a1);
        System.out.println("222,"+a2);
        System.out.println("333,"+a3);
        System.out.println("444,"+a4);
        System.out.println(a3-a4);

        // 关闭线程池  
//        pool.shutdown(); 
//        pool.awaitTermination(2000, TimeUnit.MILLISECONDS);

	}

}
