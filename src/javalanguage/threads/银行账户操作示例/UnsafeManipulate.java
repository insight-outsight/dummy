package javalanguage.threads.银行账户操作示例;

public class UnsafeManipulate {

	/**
	 * 由于两个线程同时对一个UnsafeAccount对象deposit()和withdraw()操作，
	 * 若并且deposit()和withdraw()没有加入同步控制，导致结果是随机的。
	 */
	public static void main(String[] args) {
		UnsafeAccount account = new UnsafeAccount(1000);
		int amount = 4;
		//创建两个线程，使用同一个UnsafeAccount对象
		Thread depositThread = new Thread(new DepositThread(account,amount),"存款");
		Thread withdrawThread = new Thread(new WithdrawThread(account,amount),"取款");
		
		depositThread.start();
		withdrawThread.start();
		
		try {
			depositThread.join();
			withdrawThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//输出结果
		System.out.println(account.getBalance());
	}

	static class DepositThread implements Runnable {
		UnsafeAccount account;
		int amount;

		public DepositThread(UnsafeAccount account, int amount) {
			this.account = account;
			this.amount = amount;
		}

		public void run() {
			for (int i = 0; i < 200000; i++) {
				account.deposit(amount);
			}
		}
	}
	
	static class WithdrawThread implements Runnable {
		UnsafeAccount account;
		int amount;

		public WithdrawThread(UnsafeAccount account, int amount) {
			this.account = account;
			this.amount = amount;
		}

		public void run() {
			for (int i = 0; i < 200000; i++) {
				account.withdraw(amount);
			}
		}
	}
}