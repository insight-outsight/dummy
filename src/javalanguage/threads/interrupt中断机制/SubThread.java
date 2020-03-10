package javalanguage.threads.interrupt中断机制;
public class SubThread extends Thread {
    public void run(){
        super.run();
        for(int i=0; i<3000000; i++){
        	i++;
//            System.out.println("i="+(i+1)+","+Thread.interrupted());
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                System.out.println("i="+(i+1)+","+Thread.interrupted());
//
//            	System.out.println("出错，出错。");
//                e.printStackTrace();
//            }
        }
    }
}