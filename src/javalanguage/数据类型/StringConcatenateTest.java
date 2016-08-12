package javalanguage.数据类型;
import java.io.*;
import java.util.Date;

public class StringConcatenateTest {

	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();

		int i = 0;
		long prev_time = System.currentTimeMillis();
		long time;
		long memory = runtime.freeMemory();
		    
		for (i = 0; i < 100000; i++) {
			String s = "Blah" + i + "Blah";
		}
		time = System.currentTimeMillis() - prev_time;
	    memory = memory-runtime.freeMemory();
	    
		System.out.println("Time after for '+' " + time + ",memory used:"+memory);

		memory = runtime.freeMemory();
		prev_time = System.currentTimeMillis();
		for (i = 0; i < 100000; i++) {
			String s = String.format("Foo2 %d Foo2", i);
		}
		
		time = System.currentTimeMillis() - prev_time;
	    memory = memory-runtime.freeMemory();
		System.out.println("Time after for 'format' " + time + ",memory used:"+memory);
		
		memory = runtime.freeMemory();
		prev_time = System.currentTimeMillis();
		for (i = 0; i < 100000; i++) {
			String s = new StringBuilder("Bar3 ").append(i).append(" Bar3").toString();
		}
		
		time = System.currentTimeMillis() - prev_time;
	    memory = memory-runtime.freeMemory();
		System.out.println("Time after for 'StringBuilder' " + time + ",memory used:"+memory);
		
		memory = runtime.freeMemory();
		prev_time = System.currentTimeMillis();
		for (i = 0; i < 100000; i++) {
			String s = new StringBuffer("Sue3 ").append(i).append(" Sue3").toString();
		}
		
		time = System.currentTimeMillis() - prev_time;
	    memory = memory-runtime.freeMemory();
		System.out.println("Time after for 'StringBuffer' " + time + ",memory used:"+memory);

	}
	
}