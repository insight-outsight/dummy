package javalanguage;



public class RuntimeTset {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("CPU核心数："+Runtime.getRuntime().availableProcessors());
		System.out.println("最大内存："+Runtime.getRuntime().maxMemory());
		System.out.println("空闲内存："+Runtime.getRuntime().freeMemory());
		
	}

}
