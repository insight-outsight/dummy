package javalanguage.threads._synchronized;

public class SynchronizedObjectClassTest {  
  
    public static void main(String[] args) {  
        final SynchronizedObjectClass synchronizedObjectClass = new SynchronizedObjectClass();  
        Thread thread1 = new Thread(new Runnable() {  
            public void run() {  
                try {  
                    synchronizedObjectClass.normalMethod();  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
            }  
        }, "a");  
  
        Thread thread2 = new Thread(new Runnable() {  
            public void run() {  
                try {  
                    SynchronizedObjectClass.staticMethod();  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
            }  
        }, "b");
        
        Thread thread3 = new Thread(new Runnable() {  
            public void run() {  
                try {  
                    SynchronizedObjectClass.staticMethod2();  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
            }  
        }, "c");
  
        Thread thread4 = new Thread(new Runnable() {  
            public void run() {  
                try { 
                    synchronizedObjectClass.normalMethod2();  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
            }  
        }, "d");
        
        thread1.start();  
        thread2.start();  
        thread3.start();
        thread4.start();
        
        Thread thread5 = new Thread(new Runnable() {  
            public void run() {  
                try {  
                    synchronizedObjectClass.synchronizedObjectMethod1();  
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
        }, "bicycle");
  
        Thread thread6 = new Thread(new Runnable() {  
            public void run() {  
                try { 
                    synchronizedObjectClass.synchronizedObjectMethod2();  
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
        }, "scooter");
        
        thread5.start();  
        thread6.start(); 
        
    }
    
} 