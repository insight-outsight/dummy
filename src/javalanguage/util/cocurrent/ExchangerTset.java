package javalanguage.util.cocurrent;

import java.util.concurrent.Exchanger;

public class ExchangerTset {

	static Exchanger<StringBuilder> exchanger = new Exchanger<StringBuilder>();
	static StringBuilder initialEmptyBuffer = new StringBuilder("eb");
	static StringBuilder initialFullBuffer = new StringBuilder("fb");

	public static void main(String[] args) {
//		new Thread(new FillingLoop()).start();
//		new Thread(new EmptyingLoop()).start();
		String s = "t38\r\nerwer\r\neee";
		String[] sa = s.split("\r\n");
		for(String sas:sa){
			System.out.println(sas);
		}
	}
	
	static class FillingLoop implements Runnable {
		public void run() {
			StringBuilder currentBuffer = initialEmptyBuffer;
	        try {
	          while (currentBuffer != null) {
	            currentBuffer.append('a');
	            if (currentBuffer.length()>5)
	              currentBuffer = exchanger.exchange(currentBuffer);
	          }
	        } catch (InterruptedException ex) {ex.printStackTrace(); }
	      }
	}

	static class EmptyingLoop implements Runnable {
		public void run() {
			StringBuilder currentBuffer = initialFullBuffer;
	        try {
	          while (currentBuffer != null) {
	            System.out.println(currentBuffer.deleteCharAt(0));
	            if (currentBuffer.length()<1)
	              currentBuffer = exchanger.exchange(currentBuffer);
	          }
	        } catch (InterruptedException ex) {ex.printStackTrace();}
	      }
	}

}

