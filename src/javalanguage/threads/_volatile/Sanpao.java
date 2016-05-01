package javalanguage.threads._volatile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;

public class Sanpao {
	
/**
 * 会抛出：
 * Exception in thread "Thread-0" java.lang.AssertionError: This statement is false.
	at javalanguage.threads._volatile.Holder.assertSanity(Holder.java:24)
	at javalanguage.threads._volatile.Sanpao$1.run(Sanpao.java:23)

例子来源于《Java.Concurrency.in.Practice》 3.5.1
 * @param args
 */
	public static void main(String[] args) {
		
		Holder holder = new Holder(4);  
		
			
		    new Thread(    
		    	new Runnable() {
			        public void run(){
			        	for(;;){
//			        		不管哪个方法都会抛出异常
//			        		holder.assertSanity();
			            	holder.assertSanity2();
			            	try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
			        	}	
			        }  
		    	}
		    ).start();
			


		    new Thread(){    
		        public void run(){
		            for(;;){
		            	holder.setN(new Random().nextInt(Integer.MAX_VALUE));
		            }		            
		        }    
		    }.start();
		    
	
	}
	


}
