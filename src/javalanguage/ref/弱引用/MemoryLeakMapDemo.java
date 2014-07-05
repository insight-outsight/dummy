package javalanguage.ref.弱引用;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MemoryLeakMapDemo {

    public ExecutorService exec = Executors.newFixedThreadPool(5);
    
    public Map<Task, TaskStatus> taskStatus //换成WeakHashMap可防内存泄露
        = Collections.synchronizedMap(new HashMap<Task, TaskStatus>());
    
    private Random random = new Random();
    
    private enum TaskStatus { NOT_STARTED, STARTED, FINISHED };
    
    private class Task implements Runnable {
    	private String name;
        private int[] numbers = new int[random.nextInt(20000)];
        public Task(String name){
        	this.name = name;
        }
        public String getName(){
        	return this.name;
        }
        public void run() {
           taskStatus.put(this, TaskStatus.STARTED);
           doSomeWork(numbers);
           taskStatus.put(this, TaskStatus.FINISHED);
        }

    }
    
    
    public void doSomeWork(int[] nums){
    	System.out.println("我干故我在---"+nums.length);

    }
    
    public Task newTask(String name) {
        Task t = new Task(name);
        taskStatus.put(t, TaskStatus.NOT_STARTED);
        exec.execute(t);
        return t;
    }
    
    public static void main(String[] args) {

    	final MemoryLeakMapDemo mlmd = new MemoryLeakMapDemo();
    	for(int i=0;i<10;i++){
    		mlmd.newTask("Trd-"+i);
    	}

    	try {
			mlmd.exec.awaitTermination(3, TimeUnit.SECONDS);
			//如果去掉这句，ExecutorService开辟的线程将不会退出。
			mlmd.exec.shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	mlmd.new CountThread().start();
    	System.out.println("Done.");
	}
    
   class CountThread extends Thread{
	    byte[] b = null;
    	@Override
    	public void run(){
			while(true){
				System.out.println("-----------count--------------"+taskStatus.size());
				for(Task t:taskStatus.keySet()){
					System.out.println(t.getName());
				}
    			try {
					Thread.sleep(4000);
				} 
    			catch (InterruptedException e) {
					e.printStackTrace();
				}
    			//分配大量内存，便于触发垃圾回收器运行，也许使用显式System.gc()来触发。
    			b=new byte[512*512*512];
    			//System.gc();
			}
    	}
    }
    
}



 

