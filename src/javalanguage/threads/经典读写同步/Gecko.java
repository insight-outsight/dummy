package javalanguage.threads.经典读写同步;

public class Gecko {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuffer buffer = new StringBuffer("");
		

		Reader read = new Reader(buffer);
		read.setName("---我是read线程111111---");
		Reader read2 = new Reader(buffer);
		read2.setName("---我是read线程222222---");
		
		read.start();
		read2.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

		
		Writer write = new Writer(buffer);
		write.setName("---我是write线程---");
		write.start();
		
	}

}