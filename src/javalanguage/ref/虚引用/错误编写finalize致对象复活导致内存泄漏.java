package javalanguage.ref.虚引用;

/**
 * 
 * @author xu
 * 
 * 参考葛一鸣等所著<<Java程序性能优化——让你的Java程序更快、更稳定>>一书
 */
public class 错误编写finalize致对象复活导致内存泄漏 {
	
	public static 错误编写finalize致对象复活导致内存泄漏 obj;
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("错误编写finalize致对象复活导致内存泄漏 finalize called");
		obj=this;
	}
	
	@Override
	public String toString(){
		return "I am 错误编写finalize致对象复活导致内存泄漏";
	}
	
	public static void main(String[] args) throws InterruptedException{
		obj=new 错误编写finalize致对象复活导致内存泄漏();
//		加上这句会使第33行中判断obj==null为true,从而导致39行中抛空指针异常
//		错误编写finalize致对象复活导致内存泄漏 objCopy = obj;

		obj=null;
		System.gc();
		Thread.sleep(1000);
		if(obj==null){
			System.out.println("obj 是 null");
		}
		else{
			System.out.println("obj 可用");
		}
		System.out.println("obj值为【"+obj.toString()+"】");

		System.out.println("第二次gc");
		//由于obj对象finalize()中错误对赋值操作导致对象复活，要想使对象被回收，可强制对obj=null。
//		原因是，当再次对obj赋值为null之后调用gc(),垃圾回收器发现obj对象不再被任何对象引用，将会直接回
//		收它。因为obj已经被执行过一次finalize(),这次被检测为垃圾后，不会再次执行finalize()了。
//		以下是JAVA DOC中的对finalize()的部分解释：
//		After the finalize method has been invoked for an object, no further action is taken until the Java virtual
//		machine has again determined that there is no longer any means by which this object can be accessed by any
//		thread that has not yet died, including possible actions by other objects or classes which are ready to be 
//		finalized, at which point the object may be discarded.
//
//		The finalize method is never invoked more than once by a Java virtual machine for any given object.
		//obj=null;
		System.gc();
		Thread.sleep(1000);
		if(obj==null){
			System.out.println("obj 是 null");
		}
		else{
			System.out.println("obj 可用");
			System.out.println("obj值为【"+obj.toString()+"】");
		}
	}
	
}
