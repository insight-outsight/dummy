package javalanguage.threads.经典读写同步;

public class Reader extends Thread {
	public StringBuffer buffer;

	public Reader(StringBuffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		synchronized (buffer) {
			for (int i = 0; i < 100; i++) {
//				if (!"".equals(this.buffer.toString())) {
				while("".equals(this.buffer.toString().trim())) {
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
				//如果上面不使用while而使用if判断，则由于线程可能发生虚假唤醒（spurious wakeup），导致这里可能会抛出异常
				if ("".equals(this.buffer.toString())){
					throw new IllegalStateException(getName()+" wrong read");
				}
				System.out.println("从缓冲区读到内容is："+this.buffer.toString());
				buffer.delete(0, buffer.toString().length());
				/*
				 使用notify()可能会造成死锁，这发生在比如有1个写线程和2个读线程，当
				写线程和其中1个读线程都处于wait()状态，而另一个读线程notify()了处
				于wait()的那个读线程，此时，由于while()条件不满足，导致1读和2个写线程都处于wait()状态
				程序陷入无限等待中。
				*/
//				buffer.notify();
				buffer.notifyAll();
				try {
					Thread.sleep(200);
				} 
				catch (InterruptedException e) {
				}
				System.out.println(getName() + "读结束......"+ System.currentTimeMillis());
			}
		}
		System.out.println(getName()+"我搞定了");
	}
}