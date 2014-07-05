package javalanguage.ref.虚引用;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

import javalanguage.ref.MyObject;


/**
 * 
 * @author xu
 * 
 * 参考葛一鸣等所著<<Java程序性能优化——让你的Java程序更快、更稳定>>一书
 */
public class TestPhantomRef {

	ReferenceQueue<MyObject> phantomQueue=null;
	
	public class CheckRefQueue extends Thread{
		
		@SuppressWarnings("unchecked")
		@Override
		public void run(){
			while(true){
				if(phantomQueue!=null){
						Reference<MyObject> obj;
						try {
							obj = (Reference<MyObject>) phantomQueue.remove();
							System.out.println("Object for PhantomReference is "+obj.get());
							System.exit(0);
						} 
						catch (InterruptedException e) {
							e.printStackTrace();
						}
				}
				try {
					Thread.sleep(1000);
				} 
				catch (InterruptedException e) {
				}
			}
		}
		
	}
	
	
	public void test() throws InterruptedException {
		
		MyObject obj=new MyObject();
		phantomQueue = new ReferenceQueue<MyObject>();  
		PhantomReference<MyObject> phantomRef=new PhantomReference<MyObject>(obj,phantomQueue);
		
		
		new CheckRefQueue().start();
		//删除强引用
		obj=null;
		Thread.sleep(1000);
		int i=1;
		//第一次执行GC，已执行obj的finalize()，加入回收队列，但没有回收，
		//第二次运行GC时才回收，并把其虚引用加入引用队列
		while(true){
			System.out.println("第"+i+++"次gc");
			System.gc();
			Thread.sleep(1000);
			System.out.println("Phantom Get: " + phantomRef.get());
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		new TestPhantomRef().test();
	}

}
