package javalanguage.threads._volatile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;
import java.util.List;

public class Yipao {
	
	//加上volatile修饰的是时候，程序会很快退出，因为volatile 保证各个线程
	//工作内存的变量值和主存一致。所以boolValue == !boolValue就成为了可能。 
	/*volatile */boolean  boolValue; 

	public static void main(String[] args) {
			
		System.out.println(System.getProperty("java.vm.name"));
		try {
		    final Yipao volObj = new Yipao();    
		    Thread t1=new Thread(){    
		        public void run(){
		            System.out.println("t1 start"); 
		            //int r = 0;
		            for(;;/*int i=0;i<100;i++*/){    
		                    volObj.waitToExit(); 
		                    //r=i;
		                    try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
		            } 
		            //System.out.println("www-"+r);
		        }    
		    };    
		    t1.start();
		    
		    Thread t2=new Thread(){    
		        public void run(){ 
		            System.out.println("t2 start"); 
		            for(;;/*int i=0;i<20;i++*/){    
		                volObj.swap();
	                    try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
		            }
		        }    
		    };    
		    t2.start(); 
		    System.out.println("start curr:"+System.currentTimeMillis());
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void waitToExit() {
		//非原子操作，理论上应该很快会被打断。实际不是，因为此时的boolValue
		//在线程自己内部的工作内存的拷贝，因为它不会强制和主存区域同步，
		//线程2修改了boolValue很少有机会传递到线程一的工作内存中。
		//所以造成了假的“原子现象”。
/*		if(boolValue)
			c_t++;
		else
			c_f++;
    	System.out.println(boolValue);*/
	    if(boolValue == !boolValue){
	    	System.out.println("花香");
	    	System.out.println("end   curr:"+System.currentTimeMillis());
	    	System.exit(0);
	    }
	}    
	    
	public void swap() {
		//不断反复修改boolValue，以期打断线程t1.    
	    boolValue = !boolValue;    
	}  
	

}
