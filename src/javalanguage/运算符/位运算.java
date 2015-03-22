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
		System.out.println(~35);//-36
		System.out.println(~100);//-101
		System.out.println((345&~35)+"jj"+(345&35));//任意数D与一个数按位与后，再与那个数的取反按位与相加，等于D
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		int n = -1;//1111 1111 1111 1111 1111 1111 1111 1111
		System.out.println(n >>> 1);//0111 1111 1111 1111 1111 1111 1111 1111
		System.out.println(n >>> 2);//0011 1111 1111 1111 1111 1111 1111 1111
		
		System.out.println("~~~~~~~~~~~~~~~222~~~~~~~~~~~~~~~~~~~~");
		System.out.println(n >> 1);//1111 1111 1111 1111 1111 1111 1111 1111
		System.out.println(n >> 23);//1111 1111 1111 1111 1111 1111 1111 1111
		System.out.println(n >> 30);//1111 1111 1111 1111 1111 1111 1111 1111
		
		System.out.println(n << 1);//1111 1111 1111 1111 1111 1111 1111 1110
		System.out.println(n << 2);//1111 1111 1111 1111 1111 1111 1111 1100
		System.out.println(n << 3);//1111 1111 1111 1111 1111 1111 1111 1000
	
		System.out.println("~~~~~~~~~~~~~~~333~~~~~~~~~~~~~~~~~~~~");		
		int b2 = 0xbffffffd;
		System.out.println("原值:"+b2);//1011 1111 1111 1111 1111 1111 1111 1101
		System.out.println(b2>>>1);//0101 1111 1111 1111 1111 1111 1111 1110
		System.out.println(b2>>1);//1101 1111 1111 1111 1111 1111 1111 1110
		System.out.println(0x5ffffffe);//0101 1111 1111 1111 1111 1111 1111 1110
		System.out.println(0xdffffffe);//1101 1111 1111 1111 1111 1111 1111 1110
		
		System.out.println(b2>>>2);//0010 1111 1111 1111 1111 1111 1111 1111
		System.out.println(b2>>2);//1110 1111 1111 1111 1111 1111 1111 1111
		System.out.println(0x2fffffff);//0010 1111 1111 1111 1111 1111 1111 1111
		System.out.println(0xefffffff);//1110 1111 1111 1111 1111 1111 1111 1111		
		System.out.println("~~~~~~~~~~~~~~~444~~~~~~~~~~~~~~~~~~~~");
		
		int positiveMaxInt = Integer.MAX_VALUE;//0111 1111 1111 1111 1111 1111 1111 1111
		System.out.println(positiveMaxInt);
		System.out.println(positiveMaxInt << 1);//1111 1111 1111 1111 1111 1111 1111 1110
		System.out.println(0xfffffffe);//1111 1111 1111 1111 1111 1111 1111 1110
		
		int int2 = 0x4fffffff;//0100 1111 1111 1111 1111 1111 1111 1111
		System.out.println(int2);
		System.out.println(int2 << 1);//1001 1111 1111 1111 1111 1111 1111 1110
		System.out.println(0x9ffffffd);//1001 1111 1111 1111 1111 1111 1111 1110
		System.out.println(int2 << 2);//0011 1111 1111 1111 1111 1111 1111 1100
		System.out.println(0x3ffffffc);//0011 1111 1111 1111 1111 1111 1111 1100
		
		int n1 = 4;//0000 0000 0000 0000 0000 0000 0000 0100
		int n2 = -4;//1111 1111 1111 1111 1111 1111 1111 1100
		System.out.println(n1<<1);//0000 0000 0000 0000 0000 0000 0000 1000
		System.out.println(n2<<1);//1111 1111 1111 1111 1111 1111 1111 1000
		System.out.println("~~~~~~~~~~~~~~~555~~~~~~~~~~~~~~~~~~~~");		
		System.out.println(n1<<1);//0000 0000 0000 0000 0000 0000 0001 0000
		System.out.println(n1<<2);//0000 0000 0000 0000 0000 0000 0010 0000
		System.out.println(n1<<3);//0000 0000 0000 0000 0000 0000 0100 0000
		System.out.println("~~~~~~~~~~~~~~~666~~~~~~~~~~~~~~~~~~~~");	
		System.out.println(n2>>1);//1111 1111 1111 1111 1111 1111 1111 1000
		System.out.println(n2>>2);//1111 1111 1111 1111 1111 1111 1111 1000
		System.out.println(n2>>3);//1111 1111 1111 1111 1111 1111 1111 1000

		System.out.println("*********************************************");
		int n3 = 1073741828;//0100 0000 0000 0000 0000 0000 0000 0100
		System.out.println(n3<<1);//1000 0000 0000 0000 0000 0000 0000 1000
		
		int n4 = 536870916;//0010 0000 0000 0000 0000 0000 0000 0100
		System.out.println(n4<<1);//0100 0000 0000 0000 0000 0000 0000 1000

	}

}
