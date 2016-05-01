package javalanguage.threads._volatile;

public class RaceCondition {
	
	private static boolean done;

	public static void main(final String[] args) throws InterruptedException {
		Holder2 holder2 = new Holder2(5);
		new Thread(new Runnable() {
			public void run() {
				int i = 0;
				while (holder2.getDone()==5) {
					i++;
//					如果加下面这句过一会就会正常退出，不加就不会，很神奇！
//					System.out.println(holder2.getDone());

				}
				System.out.println("Done!");
			}
		}).start();
		
		System.out.println("OS: " + System.getProperty("os.name"));
		System.out.println("VM name: " + System.getProperty("java.vm.name"));
//		Thread.sleep(2000);
//		holder2.setDone(true);
		new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				holder2.setDone(444);
				System.out.println("flag done set to true");
			}
		}).start();
//		System.out.println("flag done set to true");
	}
	
}