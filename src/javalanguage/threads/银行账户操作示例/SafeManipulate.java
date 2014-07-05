package javalanguage.threads.银行账户操作示例;

public class SafeManipulate {

	/**
	 * 对deposit()和withdraw()加入同步控制
	 */
	public static void main(String[] args) {
		SafeAccount account = new SafeAccount(1000);
		int amount = 4;
		// 创建两个线程，使用同一个Account对象
		Thread depositThread = new Thread(new DepositThread(account, amount),
				"存款");
		Thread withdrawThread = new Thread(new WithdrawThread(account, amount),
				"取款");

		depositThread.start();
		withdrawThread.start();

		try {
			depositThread.join();
			withdrawThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 输出结果
		System.out.println("余额是" + account.getBalance());
	}

	static class DepositThread implements Runnable {
		SafeAccount account;
		int amount;

		public DepositThread(SafeAccount account, int amount) {
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
		SafeAccount account;
		int amount;

		public WithdrawThread(SafeAccount account, int amount) {
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
