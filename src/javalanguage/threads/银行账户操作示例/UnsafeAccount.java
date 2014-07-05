package javalanguage.threads.银行账户操作示例;

public class UnsafeAccount {
	protected int balance;

	public UnsafeAccount(int balance) {
		super();
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}
	
	public void deposit(int num){
		balance+=num;
	}
	
	public void withdraw(int num){
		balance-=num;
	}
}
