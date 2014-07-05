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
		obj=null;
		System.gc();
		Thread.sleep(1000);
		if(obj==null){
			System.out.println("obj 是 null");
		}
		else{
			System.out.println("obj 可用");
		}
		System.out.println("第二次gc");
		//由于obj对象finalize()中错误对赋值操作导致对象复活，
		//要想使对象被回收，强制对obj=null
		//obj=null;
		System.gc();
		Thread.sleep(1000);
		if(obj==null){
			System.out.println("obj 是 null");
		}
		else{
			System.out.println("obj 可用");
		}
	}
}
