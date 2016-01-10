package javalanguage.threads.经典读写同步;

public class Reader extends Thread {
	public StringBuffer buffer;

	public Reader(StringBuffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		synchronized (buffer) {
			for (int i = 0; i < 5; i++) {
				if ("".equals(this.buffer.toString().trim())) {
					try {
						System.out.println(i+getName() + "读等待开始········"
								+ System.currentTimeMillis());
						buffer.wait();
						System.out.println(i+getName() + "读等待结束········"
								+ System.currentTimeMillis());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(getName() + "读开始......"+ System.currentTimeMillis());
				System.out.println("从缓冲区读到内容is："+this.buffer.toString());
				buffer.delete(0, buffer.toString().length());
				//buffer.notifyAll();
				buffer.notify();
				try {
					Thread.sleep(2000);
				} 
				catch (InterruptedException e) {
				}
				System.out.println(getName() + "读结束......"+ System.currentTimeMillis());
			}
		}
		System.out.println(getName()+"我搞定了");
	}
}