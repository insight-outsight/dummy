package javalanguage.threads._synchronized;

public class SynchronizedObjectClass {  
  
    public static synchronized void staticMethod() throws InterruptedException {  
        for (int i = 0; i < 5; i++) {  
            Thread.sleep(500);  
            System.out.println(Thread.currentThread().getName()+"-staticMethod:" + i);  
        }  
    }  
    public static synchronized void staticMethod2() throws InterruptedException {  
        for (int i = 0; i < 5; i++) {  
            Thread.sleep(500);  
            System.out.println(Thread.currentThread().getName()+"-staticMethod2:" + i);  
        }  
    }  
  
    public synchronized void normalMethod() throws InterruptedException {  
        for (int i = 0; i < 5; i++) {  
            Thread.sleep(1000);  
            System.out.println(Thread.currentThread().getName()+"-normalMethod:" + i);  
        }  
    }  
    
    public synchronized void normalMethod2() throws InterruptedException {  
        for (int i = 0; i < 5; i++) {  
            Thread.sleep(1000);  
            System.out.println(Thread.currentThread().getName()+"-normalMethod2:" + i);  
        }  
    }  
    
    String lock = new String();
    public void synchronizedObjectMethod1(){
        try {
            synchronized (lock) {
                for (int i = 0; i < 3; i++) {  
                    Thread.sleep(3000);  
                    System.out.println(Thread.currentThread().getName()+"-synchronizedObjectMethod1:" + i);  
                }  
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void synchronizedObjectMethod2(){
        try {
            synchronized (lock) {
                for (int i = 0; i < 3; i++) {  
                    Thread.sleep(3000);  
                    System.out.println(Thread.currentThread().getName()+"-synchronizedObjectMethod2:" + i);  
                }  
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
} 