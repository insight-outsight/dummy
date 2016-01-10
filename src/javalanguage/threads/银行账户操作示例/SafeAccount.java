package javalanguage.threads.银行账户操作示例;

public class SafeAccount extends UnsafeAccount{
//	private int balance;
//	private Object mutex = new Object();
	
	public SafeAccount(int balance) {
		super(balance);
		//this.balance = balance;
	}

/*	public int getBalance() {
		return balance;
	}*/
	
	@Override
	public synchronized void deposit(int num){
		//synchronized(mutex){
			balance+=num;
		//}
	}
	
	@Override
	public synchronized void withdraw(int num){
		//synchronized(mutex){
			balance-=num;
		//}
	}
}
