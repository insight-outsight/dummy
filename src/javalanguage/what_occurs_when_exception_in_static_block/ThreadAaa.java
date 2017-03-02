package javalanguage.what_occurs_when_exception_in_static_block;



public class ThreadAaa extends Thread {
//	private final static String nm = ThrowExceptionInStatic.getWtte();
    protected ThreadAaa(String threadName) {
        super(threadName);
    }

    
    @Override
    public void run() {
        while(true){
        	try{
        		System.out.println(this.getClass().getSimpleName()+" processed."+ThrowExceptionInStatic.getWtte());
        	} catch (Throwable e) {
        		System.out.println("oh,Error Occurs In ["+Thread.currentThread().getName()+"]");
				e.printStackTrace();
			}
            try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
    }

    


}
