package javalanguage.threads.interrupt中断机制;

public class TestCostCPUCalc {

	public static void main(String[] args) {
		
		new Thread(() -> {
			System.out.println("lambda实现的线程");
			int j = 0;
			for (int i = 0; i < 1000000000L; i++) {
				j++;
				System.out.println("k" + j);
			}
			}).start(); 
		int j = 0;
		for (int i = 0; i < 2000000000L; i++) {
			j++;
			System.out.println("k" + j);
		}
	}

}
