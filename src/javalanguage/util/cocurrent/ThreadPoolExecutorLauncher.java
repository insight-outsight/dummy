package javalanguage.util.cocurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class ThreadPoolExecutorLauncher {

	public static ExecutorService executors = new ThreadPoolExecutor(10, 20, 1000, TimeUnit.MILLISECONDS,
            new SynchronousQueue<Runnable>(),
            new ThreadPoolExecutor.DiscardPolicy());
	
	public static void main(String[] args) {
		int taskNum = 10;
		
		
		List<Callable<Integer>> tasks = new ArrayList<Callable<Integer>>();
		for(int i=0;i<taskNum;i++){
			Callable<Integer> task = new Callable<Integer>(){

				@Override
				public Integer call() throws Exception {
					final int num = new Random().nextInt(100);	
	
					if(num%5 == 0){
						throw new Exception("id"+num+" is illegal");
					}
					
	
					return new Integer(num);
				}
				
			};
			tasks.add(task);		
		}
		
		List<Future<Integer>> futureResults = null;

		try {
			futureResults = executors.invokeAll(tasks,2000,TimeUnit.MILLISECONDS);
		} catch (InterruptedException e1) {
			System.out.println("线程执行被打断。");
			e1.printStackTrace();
		}
		
		int succeedNum = 0;
		if(futureResults != null && futureResults.size()>0){
			for(Future<Integer> f:futureResults){			
				if(f.isDone()){	
					succeedNum++;
					try {
						int randNum = new Random().nextInt(10000000);
						System.out.println(randNum+" start "+System.currentTimeMillis());
						Integer resultValue = f.get();
						System.out.println("取得值："+resultValue );
						System.out.println(randNum+" end   "+System.currentTimeMillis() );
					} catch (InterruptedException e) {
						System.out.println("==================ie===============");
						e.printStackTrace();
					} catch (ExecutionException e) {
						System.out.println("==================ee===============");
						e.printStackTrace();
					} catch (CancellationException e) {
						System.out.println("==================ce===============");
						e.printStackTrace();
					}				
					
				}
				else if(f.isCancelled()){
					System.out.println("w a a a a o ");
				}
				else{
					System.out.println("a o");
				}
			}
		}

		System.out.println("done 数量："+succeedNum);
		
	}
	
}
