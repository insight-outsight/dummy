package javalanguage.threads.uncaught_exception_handler;


public class WUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
	
	public WUncaughtExceptionHandler() {
		super();
	}

	@Override
	public void uncaughtException(Thread t, Throwable e) {	
		System.err.println("线程抛错，信息如下：" );	
		System.err.println("线程名称：" + t.getName());	
		System.err.println("错误信息：" + e.getLocalizedMessage());	
	}
	

}
