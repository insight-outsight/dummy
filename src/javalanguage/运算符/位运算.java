package javalanguage.运算符;

public class 位运算 {

	public static void main(String[] args) {
		
		//0101
		//1011
		System.out.println("5^11="+(5^11));
		System.out.println("5|11="+(5|11));
		System.out.println("5&11="+(5&11));
		System.out.println("-----------------------------------");
		//101111
		//000011
		//101100  =44
		System.out.println(47^3);
		System.out.println("===================================");
		//0000 0000 0010 0011 （35）
		//1111 1111 1101 1100  取反码,得到负数，认为是补码，所以计算原码
		//1111 1111 1101 1011  先减1
		//1000 0000 0010 0100  除符号位外再取反码得到原码 （-36）
		System.out.println(~35);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		int n = -1;//1111 1111 1111 1111 1111 1111 1111 1111
		System.out.println(n >>> 1);//0111 1111 1111 1111 1111 1111 1111 1111
		System.out.println(n >> 1);//1111 1111 1111 1111 1111 1111 1111 1111
		
		int n1 = 4;//0000 0000 0000 0000 0000 0000 0000 0100
		int n2 = -4;//1111 1111 1111 1111 1111 1111 1111 1100
		System.out.println(n1<<1);
		System.out.println(n2<<1);
		
		int n3 = 1073741828;//0100 0000 0000 0000 0000 0000 0000 0100
		System.out.println(n3<<1);
		
		int n4 = 536870916;//0010 0000 0000 0000 0000 0000 0000 0100
		System.out.println(n4<<1);
		
	}

}
