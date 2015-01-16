package javalanguage.ref;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class RefAndRefQueueTset {

	
/*GC、 Reference 与 ReferenceQueue 的交互
A、  GC无法删除存在强引用的对象的内存。
B、  GC发现一个只有软引用的对象内存，那么：
①  SoftReference对象的 referent  域被设置为 null ，从而使该对象不再引用 heap 对象。
②  SoftReference引用过的 heap 对象被声明为 finalizable 。
③  当 heap  对象的  finalize()  方法被运行而且该对象占用的内存被释放， SoftReference  对象就被添加到它的  ReferenceQueue （如果后者存在的话）。
C、  GC发现一个只有弱引用的对象内存，那么：
①  WeakReference对象的 referent 域被设置为 null , 从而使该对象不再引用heap 对象。
②  WeakReference引用过的 heap 对象被声明为 finalizable 。
③  当heap 对象的 finalize() 方法被运行而且该对象占用的内存被释放时， WeakReference 对象就被添加到它的 ReferenceQueue （如果后者存在的话）。
D、  GC发现一个只有虚引用的对象内存，那么：
①  PhantomReference引用过的 heap 对象被声明为 finalizable 。
②  PhantomReference在堆对象被释放之前就被添加到它的 ReferenceQueue 。
 
值得注意的地方有以下几点：
1、 GC 在一般情况下不会发现软引用的内存对象，只有在内存明显不足的时候才会发现并释放软引用对象的内存。
2、 GC 对弱引用的发现和释放也不是立即的，有时需要重复几次 GC ，才会发现并释放弱引用的内存对象。
3、软引用和弱引用在添加到 ReferenceQueue 的时候，其指向真实内存的引用已经被置为空了，相关的内存也已经被释放掉了。而虚引用在添加到 ReferenceQueue 的时候，内存还没有释放，仍然可以对其进行访问。
代码示例
通过以上的介绍，相信您对Java 的引用机制以及几种引用方式的异同已经有了一定了解。光是概念，可能过于抽象，
下面我们通过一个例子来演示如何在代码中使用 Reference 机制。*/

	public static void main(String[] args) {
		String str  =   new  String( " hello " );  // ①   
		ReferenceQueue < String >  rq  =   new  ReferenceQueue < String > ();  // ②   
		WeakReference < String >  wf  =   new  WeakReference < String > (str, rq);  // ③   
		str = null ;  // ④取消"hello"对象的强引用   
		
		System.gc(); //调用该句导致str1为空，ref1不为空。不调用则结果刚好相反。
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String str1 = wf.get();  // ⑤假如"hello"对象没有被回收，str1引用"hello"对象  
		System.out.println(str1);
		// 假如"hello"对象没有被回收，rq.poll()返回null   ,
		Reference <?   extends  String >  ref1 = rq.poll();  // ⑥ 
		System.out.println(ref1 == null);
	}

}
