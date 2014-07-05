package javalanguage;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class 取得Java进程名称和进程号 {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.out.println("进程名称："+取得Java进程名称和进程号.class.getSimpleName());
        int pid = getPid();
        System.out.println("进程pid: " + pid);
        System.in.read(); // block the program so that we can do some probing on it

	}
	
    private static int getPid() {
        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();    
        String name = runtime.getName(); // format: "pid@hostname"
        try {
            return Integer.parseInt(name.substring(0, name.indexOf('@')));
        } catch (Exception e) {
            return -1;
        }
    }

}

