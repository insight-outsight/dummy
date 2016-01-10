package javalanguage.ref.软引用;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

import javalanguage.ref.MyObject;

/**
 * 
 * @author xu
 * 
 * 参考葛一鸣等所著<<Java程序性能优化——让你的Java程序更快、更稳定>>一书
 */
public class TestSoftRef {

	ReferenceQueue<MyObject> softQueue=null;
	
	public class CheckRefQueue extends Thread{
		
		@SuppressWarnings("unchecked")
		@Override
		public void run(){
			while(true){
				if(softQueue!=null){
						Reference<MyObject> obj=null;
							try {
								obj = (Reference<MyObject>) softQueue.remove();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							if(obj!=null){
								System.out.println("Object for SoftReference is "+obj.get());
							}
							else{
								System.out.println("imn");
							}

				}
			}
		}
		
	}
//	public class MemConsumer extends Thread{
//		HashMap map=new HashMap();
//		@Override
//		public void run(){
//			for(int i=0;i<10000;i++){
//				map.put(i, new StringBuffer().append(i));
//			}
//		}
//	}
	

	public void test() throws InterruptedException {
		MyObject obj=new MyObject();
		softQueue = new ReferenceQueue<MyObject>();  
		SoftReference<MyObject> softRef=new SoftReference<MyObject>(obj,softQueue);
		
		new CheckRefQueue().start();
		
		//删除强引用
		obj=null;
		System.gc();
		System.out.println("After GC:Soft Get= " + softRef.get());
		try{
			System.out.println("分配大块内存");
			//分配大块内存,
			//若不进行这个耗内存操作，就不会促使GC运行，也就不会触发MyObject的finalize()方法，
			//从而MyObject对象关联的SoftReference对象不会被加入到softQueue中，这将导致
			//CheckRefQueue线程中，softQueue.remove()被阻塞			
			@SuppressWarnings("unused")
			byte[] b=new byte[4*1024*925*256];
		}catch(OutOfMemoryError ofe){
			ofe.printStackTrace();
		}
		System.out.println("After new byte[]:Soft Get= " + softRef.get());
	}


	public void testSimple() throws InterruptedException {
		MyObject obj=new MyObject();
		SoftReference<MyObject> softRef=new SoftReference<MyObject>(obj);
		//删除强引用
		obj=null;
		System.out.println("Soft Get: " + softRef.get());
		System.gc();
		System.out.println("Soft Get: " + softRef.get());
		try{
			System.out.println("分配大块内存");
			//分配大块内存
			@SuppressWarnings("unused")
			byte[] b=new byte[4*1024*925*256];
		}catch(OutOfMemoryError ofe){
			ofe.printStackTrace();
		}
		System.out.println("Soft Get: " + softRef.get());
	}
	
	
	public static void main(String[] args) throws InterruptedException {
//		new TestSoftRef().testSimple();
		new TestSoftRef().test();
	}
	
}
