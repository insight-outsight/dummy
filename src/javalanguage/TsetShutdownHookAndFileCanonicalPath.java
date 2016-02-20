package javalanguage;

import java.io.File;
import java.io.IOException;

public class TsetShutdownHookAndFileCanonicalPath {

	public static void main(String[] args) throws IOException, InterruptedException {
		//无论命令行参数个数为0，还是不为0，args都不会为null
		System.out.println("参数长度"+args.length);
		if(args.length>0){
			System.out.println("参数1="+args[0]);
		}
		//程序运行结束前执行,包括：
		//1.程序最后一个非守护线程结束
		//2.某个线程调用System.exit(0);
		//3.使用kill 命令（不带-9）
		//4.程序前台运行时，Ctrl+C退出
		//5.操作系统用户注销或者关闭
		Runtime.getRuntime().addShutdownHook( new Thread() {
			   public void run() {
				    System.out.println("shutdownThread...ed.");
			   }
			}
		);
			  
		File f = new File("../e");//Linux和Windows都可以使用..
		//File f = new File("..\\e");Windows都可以使用..\\反斜杠
		System.out.println("curr="+System.getProperty("user.dir"));//E:\ews-luna-v4.4.2\projectHomeDir
		System.out.println("aa="+f.getAbsolutePath());//E:\ews-luna-v4.4.2\projectHomeDir\..\e
		System.out.println("c="+f.getCanonicalPath());//E:\ews-luna-v4.4.2\e
		System.out.println(f.exists());
		System.out.println("probe");
		
//		Thread.currentThread().join();//让线程等待以便可以测试Ctrl+C退出
//		Thread t2 = new Thread() {
//			   public void run() {
//				   for(int i=0;i<4;i++){
//					try {
//						System.out.println("Daemon lost of beennnn..."+System.currentTimeMillis());
//						sleep(2000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				   }
//				   System.exit(0);
//			   }
//		};
//		t2.start();
		
		//或者
		Thread t = new Thread() {
			   public void run() {
				   for(int i=0;i<Integer.MAX_VALUE;i++){
						try {
							System.out.println("Daemon lost of bee..."+System.currentTimeMillis());
							sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				   }
			   }
		};
//		t.setDaemon(true);这句是关键，设置后程序会自动结束
		t.start();
		
	}

}
