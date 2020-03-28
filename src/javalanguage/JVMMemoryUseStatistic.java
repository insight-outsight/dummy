package javalanguage;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;

public class JVMMemoryUseStatistic {

	public static void main(String[] args) throws Exception {
		//-Xms100m -Xmx100m -Xmn40m 
		//-XX:+UseConcMarkSweepGC -XX:PretenureSizeThreshold=30000000
		//default size for PretenureSizeThreshold is 0 which says that any size 
		//can(not must当年轻代无法容纳对象分配所需空间时仍会直接进行old区) be allocate in the young generation firstly
		byte[] array = new byte[30 *1024 * 1024];//734003216

		for (MemoryPoolMXBean memoryPoolMXBean : ManagementFactory.getMemoryPoolMXBeans()) {

			System.out.println(memoryPoolMXBean.getName() + "  总量:"
					+ memoryPoolMXBean.getUsage().getCommitted() + "   使用的内存:"
					+ memoryPoolMXBean.getUsage().getUsed());
		}

	}

}