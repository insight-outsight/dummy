package javalanguage.ref.弱引用;

import java.lang.ref.WeakReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

import javalanguage.ref.MyObject;

/**
 * 
 * @author xu
 * 
 * 参考葛一鸣等所著<<Java程序性能优化——让你的Java程序更快、更稳定>>一书
 */
public class TestWeakRef {

	ReferenceQueue<MyObject> weakQueue=null;
	
	public class CheckRefQueue extends Thread{
		
		@SuppressWarnings("unchecked")
		@Override
		public void run(){
			while(true){
				if(weakQueue!=null){
						Reference<MyObject> obj = null;
						try {
							obj = (Reference<MyObject>) weakQueue.remove();
							System.out.println("Object for WeakReference is "+obj.get());
						} 
						catch (InterruptedException e) {
							e.printStackTrace();
						}
				}
				try {
					Thread.sleep(1000);
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	

	public void test() throws InterruptedException {
		MyObject obj=new MyObject();
		weakQueue = new ReferenceQueue<MyObject>();  
		WeakReference<MyObject> weakRef=new WeakReference<MyObject>(obj,weakQueue);
		
		MyObject obj2=new MyObject();
		WeakReference<MyObject> weakRef2=new WeakReference<MyObject>(obj2,weakQueue);
		
		new CheckRefQueue().start();
		
		//删除强引用
		obj=null;
		obj2=null;
		System.out.println("Before GC:Weak Get= " + weakRef.get());
		System.out.println("Before GC:Weak2 Get= " + weakRef2.get());
		System.gc();
		System.out.println("After GC:Weak Get= " + weakRef.get());
		System.out.println("After GC:Weak2 Get= " + weakRef2.get());
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		new TestWeakRef().test();
	}

}
