package javalanguage.运算符;

public class 逻辑运算 {
	

	public static void main(String[] args) {
		//1001
		//1011
		System.out.println("9^11="+(9^11));
		System.out.println("9|11="+(9|11));
		System.out.println("9&11="+(9&11));
		
		//101111
		//000011
		//101100  =44
		System.out.println(47^3);
		
		//0000 0000 0010 0011 （35）
		//1111 1111 1101 1100   取反码
		//1111 1111 1101 1011  减1
		//1000 0000 0010 0100  除符号位外取反码 （-36）
		System.out.println(~35);
	}
	
}
