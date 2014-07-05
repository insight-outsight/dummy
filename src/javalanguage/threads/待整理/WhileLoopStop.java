package javalanguage.threads.待整理;


public class WhileLoopStop {
	
	static int i = 2;
	static boolean isS = true;
	
	public static void main(String[] args) throws InterruptedException{
		System.out.println(System.getProperty("java.vm.name")+System.getProperty("java.version"));
		Aa aa = new Aa("ni hao");
		Kk kk = new Kk();
		int[] cts = new int[]{17,-2,33,950000};

		Thread t1111 = new S1Thread(aa,kk,cts);
		t1111.setName("T1111");
		t1111.start();
/*		Thread t2222 = new S1Thread(aa,kk,cts);
		t2222.setName("T2222");
		t2222.start();*/

		Thread ts = new S2Thread(aa,cts);
		ts.setName("Ts");
		ts.start();
		while(aa.getName().equals("ni hao")){
			Thread.sleep(5000);
			System.out.println("改了"+aa.getName());	
		}	
		aa.setName("fucker");//will be not executed
		
		//Thread.sleep(2000);
		//System.out.println("修改后值为："+aa.getName());
		System.out.println("最终aa值为："+aa.getName());
	}
	
	
}


class S1Thread extends Thread{
	Aa aa = null;
	Kk kk = null;
	int[] cts;
	public S1Thread(){
		
	}
	public S1Thread(Aa aa,Kk kk,int[] cts){
		this.aa = aa;
		this.kk = kk;
		this.cts = cts;
	}
	public void run(){
		synchronized(cts){
			//aa.setName(this.getName()+"--modified");
			for(int i=0;i<5;i++){
				try {
					System.out.println("cts[2]="+cts[2]);
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("("+this.getName()+")"+"aa值现在是：" + aa.getName()+"^^^"+System.currentTimeMillis());				
			}
			//System.out.println(this.getName()+"执行完同步块");
		}
		//System.out.println("xcccc-----"+Fucker.getCurrentThreadId());			
	}
}


class S2Thread extends Thread{
	Aa aa = null;
	int[] cts;
	public S2Thread(){
		
	}
	public S2Thread(Aa aa,int[] cts){
		this.aa = aa;
		this.cts = cts;
	}
	public void run(){
		//synchronized(cts){
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cts[2] = 7777777;
			aa.setName("s2thread modified");
			try {
				sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("((((("+this.getName()+")))))"+"aa值现在是：" + aa.getName()+"^^^"+System.currentTimeMillis());
		//}
	}
}

class Aa{
	private String name = "";
	public Aa(){

	}
	public Aa(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
}

class Kk{
	public int et = 3;
}