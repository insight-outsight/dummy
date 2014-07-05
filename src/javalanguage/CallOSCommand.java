package javalanguage;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CallOSCommand {

	class ExeCommand extends Thread {

		InputStream is;

		ExeCommand(InputStream is) {
			this.is = is;
		}

		public void run() {

			try {
				System.out.println("New thread start, sleep 500ms...");
				sleep(500);
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String line = null;
				while ((line = br.readLine()) != null) {
					System.err.println(line);
				}
			} catch (Exception ioe) {
				ioe.printStackTrace();
			}
		}
		
	}

	public void oper() {
		try {
			Process process = Runtime.getRuntime().exec("ls");
			new ExeCommand(process.getInputStream()).start();
			process.waitFor();
			System.out.println("Main thread wait for");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		CallOSCommand cosc = new CallOSCommand();
		cosc.oper();
	}

}
