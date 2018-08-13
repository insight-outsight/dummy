package javalanguage;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class 取得进程名称和进程号和主机名称 {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.out.println("进程名称："+取得进程名称和进程号和主机名称.class.getSimpleName());
        int pid = getPid();
        System.out.println("进程pid: " + pid);
//        System.in.read(); // block the program so that we can do some probing on it
        String hostName = getHostname();
        System.out.println("主机名称: " + hostName);
	}
	
    private static int getPid() {
    	try {
	        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();    
	        String name = runtime.getName();
	        System.out.println("runtime.getName()="+name);// result format: "pid@hostname"
            return Integer.parseInt(name.substring(0, name.indexOf('@')));
        } catch (Exception e) {
        	e.printStackTrace();
            return -1;
        }
    }
    
    private static String getHostname() {
    	try {
	    	RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();    
	    	String name = runtime.getName();
	    	System.out.println("runtime.getName()="+name);// result format: "pid@hostname"
    		return name.substring(name.indexOf('@')+1);
    	} catch (Exception e) {
        	e.printStackTrace();
    		return null;
    	}
    }


}

