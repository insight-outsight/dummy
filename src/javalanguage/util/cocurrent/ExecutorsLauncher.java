package javalanguage.util.cocurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorsLauncher {

	public static void main(String[] args) throws InterruptedException  {

//		testSubmitRunnable();
//		testSubmitCallable();
//		testSubmitRunnableWithoutResult();
		testInvokeAll();
	}

	static void testSubmitRunnableWithoutResult() throws InterruptedException{
		
		final List<String> l = new ArrayList<String>();
		ExecutorService es = Executors.newSingleThreadExecutor();
		Future<?> r = es.submit(new Runnable(){

			@Override
			public void run() {
				for(int i=0;i<5;i++){
					l.add(i+"小清新");	
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.err.println("出错");
						e.printStackTrace();
					}
				}
			}});
		
		es.shutdown();
		
		do{	
			es.awaitTermination(2, TimeUnit.SECONDS);
			System.out.println("等待中...");
		}
		while(!r.isDone());
		
		
		for(String s:l){
			System.out.println(s);
		}

	}

	static void testSubmitRunnable() throws InterruptedException{
		
		final List<String> l = new ArrayList<String>();
		ExecutorService es = Executors.newSingleThreadExecutor();
		Future<List<String>> r = es.submit(new Runnable(){

			@Override
			public void run() {
				for(int i=0;i<5;i++){
					l.add(i+"天良丧尽");	
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.err.println("出错");
						e.printStackTrace();
					}
				}
			}}, l);
		
		
		Thread.sleep(2000);
		
		if(r.isDone()){
			System.out.println("完成。");
			try {
				final List<String> l2 = r.get();
				for(String s:l2){
					System.out.println(s);
				}
			} catch (ExecutionException e) {
				System.err.println("出错");
				e.printStackTrace();
			}
		}
		else{
			System.out.println("未完成。");
		}

		es.shutdown();
		es.awaitTermination(10, TimeUnit.SECONDS);
		System.out.println("222222222");
		try {
			
			final List<String> l2 = r.get();
			System.out.println(l2 == l);
			for(String s:l2){
				System.out.println(s);
			}
		} catch (ExecutionException e) {
			System.err.println("出错");
			e.printStackTrace();
		}
		
	}
	
	
	
	static void testSubmitCallable() throws InterruptedException{
		
		ExecutorService es = Executors.newSingleThreadExecutor();
		Future<List<String>> r = es.submit(new Callable<List<String>>(){

			@Override
			public List<String> call() throws Exception {
				final List<String> l = new ArrayList<String>();
				for(int i=0;i<5;i++){
					l.add(i+"惨绝人寰");	
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.err.println("出错");
						e.printStackTrace();
					}
				}
				return l;
			}
		});
	
		es.shutdown();
	
		do{	
			es.awaitTermination(2, TimeUnit.SECONDS);
			System.out.println("waiting...");
		}while(!r.isDone());
		
		try {
			
			final List<String> l2 = r.get();
			for(String s:l2){
				System.out.println(s);
			}
		} catch (ExecutionException e) {
			System.err.println("出错");
			e.printStackTrace();
		}
		
	}
	
	static void testInvokeAll() throws InterruptedException{
		
		ExecutorService es = Executors.newFixedThreadPool(3);
		Collection<Callable<String>> tasks = new ArrayList<Callable<String>>(5);
		
		for(int i=0;i<5;i++){
			tasks.add(new Callable<String>(){

				@Override
				public String call() throws Exception {
					int id = new Random().nextInt(10);
					Thread.sleep(id*1000);
					return "睡了" + id + "秒";
				}
				
			});
		}
		
		System.out.println("&&&&&&&"+System.currentTimeMillis());
		List<Future<String>> result = es.invokeAll(tasks);
		System.out.println("*******"+System.currentTimeMillis());
		for(Future<String> r:result){
			try {
				System.out.println(r.get());
			} catch (ExecutionException e) {
				System.err.println("出错^_^");
				e.printStackTrace();
			}
		}
		System.out.println("------"+System.currentTimeMillis());
	}
	
}
