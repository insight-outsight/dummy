package javalanguage.threads.待整理;


public class Shanshan1 {

	public static void main(String[] args) throws Exception{
		System.out.println("主线程开始");
		Sg sg = new Sg();
		Go go = new Go(sg);
		go.setName("ggg1");
		go.start();
		
		//go.interrupt();
		Go go2 = new Go(sg);
		go2.setName("ggg2222");
		go2.start();	
		//Thread.sleep(2000);
		//System.out.println("断言000---"+go.isInterrupted());
		//go.join(1000);
		
		System.out.println("断言---"+go.isInterrupted());
		
		go.interrupt();
		Thread.sleep(6000);
		go.flag = false;
		go2.flag = false;
		System.out.println("主线程结束");
	}
	
}

class Go extends Thread {
	private Sg sg;
	public Go(Sg sg){
		System.out.println("初始化。。。。"+this.getName());
		this.sg = sg;
	}
	public boolean flag = true;
    public synchronized void run() {
        System.out.println("go start");
        try{
        	//Thread.sleep(100);
        	System.out.println("准备执行"+this.getName());
        	wait(5000);
        	System.out.println(sg.getS());
        	System.out.println("结束执行"+this.getName());
        }catch(/*Interrupted*/Exception e){
        	System.out.println("帅啊"+getName()+"抛锚");
        	e.printStackTrace();
        }
        
        while(flag){
	        System.out.println("执行---"+this.getName());
	        long time = System.currentTimeMillis();
	        while ( (System.currentTimeMillis()-time < 1000) && flag ){
	        	
	        }
        }
        System.out.println("go end");
    }
}

class Sg {

	public String octopus = "squid乌贼";

	public String getOctopus() {
		return octopus;
	}

	public void setOctopus(String octopus) {
		this.octopus = octopus;
	}
	
	public /*synchronized*/ String getS(){
		System.out.println("m l g b");
		try {
			System.out.println("开始等待"+Thread.currentThread().getName());
			//wait(10000);
			System.out.println("结束等待"+Thread.currentThread().getName());
		} catch (/*Interrupted*/Exception e) {
			System.out.println("yichang---------"+Thread.currentThread().getName());
			e.printStackTrace();
		}
		return octopus;
	}

}