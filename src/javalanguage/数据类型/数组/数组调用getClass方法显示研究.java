package javalanguage.数据类型.数组;

public class 数组调用getClass方法显示研究 {

	public static void main(String[] args) {
		Object[] i = {5,7};	
		Object[] i2 = {"tt","e55"};	
		System.out.println(i.getClass());
		System.out.println(i2.getClass());
		System.out.println("------------分隔1111------------");
		int[] a = {5,7};	
		String[] a2 = {"tt","e55"};	
		System.out.println(a.getClass());
		System.out.println(a2.getClass());
		System.out.println("------------分隔222------------");
		System.out.println(byte[].class);
		System.out.println(Byte[].class);
		System.out.println(int[].class);
		System.out.println(Integer[].class);
		System.out.println(boolean[].class);
		System.out.println(Boolean[].class);
		System.out.println(Long[].class);
		System.out.println(long[].class);
		System.out.println("------------分隔333------------");
		System.out.println(byte[].class.getName());
		System.out.println(Byte[].class.getName());
		System.out.println(int[].class.getName());
		System.out.println(Integer[].class.getName());
		System.out.println(boolean[].class.getName());
		System.out.println(Boolean[].class.getName());
		System.out.println(Long[].class.getName());
		System.out.println(long[].class.getName());
	}

}
