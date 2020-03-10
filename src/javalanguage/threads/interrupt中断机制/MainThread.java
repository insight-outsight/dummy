package javalanguage.threads.interrupt中断机制;
public class MainThread {
    public static void main(String args[]){
        Thread thread = new SubThread();
        thread.start();
        try {
        	
            Thread.sleep(2000);
            thread.interrupt();
            Thread.sleep(200);
//            Thread.currentThread().interrupt();
//            System.out.println(Thread.interrupted());
//            System.out.println(Thread.interrupted());

            System.out.println("stop 1??" + thread.isInterrupted());
            System.out.println("stop 2??" + thread.isInterrupted());
            
        } catch (InterruptedException e) {
        	System.out.println("出错，出错。");
            e.printStackTrace();
        }
    }
}