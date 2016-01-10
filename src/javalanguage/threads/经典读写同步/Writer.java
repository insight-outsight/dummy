package javalanguage.threads.经典读写同步;

public class Writer extends Thread {
	public StringBuffer buffer;

	public Writer(StringBuffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		synchronized (this.buffer) {
			for (int i = 0; i < 5; i++) {
				if (!"".equals(this.buffer.toString())) {
					try {
						System.out.println(i+getName() + "写等待开始········"
								+ System.currentTimeMillis());
						buffer.wait();
						System.out.println(i+getName() + "写等待结束········"
								+ System.currentTimeMillis());
					} 
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("写开始......" + System.currentTimeMillis());
				this.buffer.append("1234567");
				//this.buffer.notifyAll();
				this.buffer.notify();
				try {
					Thread.sleep(3000);
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("写结束......" + System.currentTimeMillis());
			}
		}
		System.out.println(getName()+"我搞定了");
	}
}