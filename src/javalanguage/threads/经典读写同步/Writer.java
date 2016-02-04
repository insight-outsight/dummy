package javalanguage.threads.经典读写同步;

public class Writer extends Thread {
	public StringBuffer buffer;

	public Writer(StringBuffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		synchronized (this.buffer) {
			for (int i = 0; i < 200; i++) {
//				if (!"".equals(this.buffer.toString())) {
				while (!"".equals(this.buffer.toString())) {
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
				//如果上面不使用while而使用if判断，则由于线程可能发生虚假唤醒（spurious wakeup），导致这里可能会抛出异常
				if (!"".equals(this.buffer.toString())){
					throw new IllegalStateException(getName()+" wrong write");
				}
				this.buffer.append("1234567");
				/*
				 使用notify()可能会造成死锁，这发生在比如有1个写线程和2个读线程，当
				写线程和其中1个读线程都处于wait()状态，而另一个读线程notify()了处
				于wait()的那个读线程，此时，由于while()条件不满足，导致1读和2个写线程都处于wait()状态
				程序陷入无限等待中。
				*/
//				buffer.notify();
				this.buffer.notifyAll();
				try {
					Thread.sleep(300);
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