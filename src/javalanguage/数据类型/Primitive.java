package javalanguage.数据类型;


public class Primitive {

	public static void main(String[] args) {
		int i=5;
		long j=5;
		System.out.println(i==j);
		String a = "gld1";
		String b = "gld"+ 1;
		System.out.println(a==b); //打印true
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		String a1 = "ab";
		String bb = "b";
		String b1 = "a"+ bb; //编译器不能确定为常量
		System.out.println(a1==b1);//打印false
		
		System.out.println("·····························");
		
		Integer i1 = new Integer(5);
		Integer i2 = new Integer(5);
		
		System.out.println(i1 == i2);//false
		
		Integer i3 = 127;
		Integer i4 = 127;
		
		System.out.println(i3 == i4);//true
		
		Integer i33 = -128;
		Integer i44 = -128;
		
		System.out.println(i33 == i44);//true
		
		
		Integer i333 = -129;
		Integer i444 = -129;
		
		System.out.println(i333 == i444);//false
		
		Integer i5 = 128;
		Integer i6 = 128;
		
		System.out.println(i5 == i6);//false
		
		int i7 = 128;
		Integer i8 = 128;
		
		System.out.println(i7 == i8);//true
		
		int i9 = new Integer(129);
		Integer i0 = 129;
		
		System.out.println(i9 == i0);//true
		
		System.out.println("#########################################");
		
		//0111 1111 1111 1111 1111 1111 1111 1111
		System.out.println(0x7fffffff);
		
		//1111 1111 1111 1111 1111 1111 1111 1111
		System.out.println(0xffffffff);
		
		//1111 1111 1111 1111 1111 1111 1111 1110
		System.out.println(0xfffffffe);
		
		//0000 0000 0000 0000 0000 0000 0000 0000
		System.out.println(0x00000000);
		
		//1000 0000 0000 0000 0000 0000 0000 0000
		System.out.println(0x80000000);
		
		//1000 0000 0000 0000 0000 0000 0000 0001
		System.out.println(0x80000001);

		System.out.println("#########################################");
		
		double d = 8.9776645365376410987455435211244364365666666666666666666666666666666123450976865532424355777437676575467557645768033333333211566790886876555;
		System.out.println(d);
		
		int qh = 0x11ff;
		byte sll = (byte)qh;
		System.out.println(sll);
		//1111 1111
		//1111 1110  减1
		//1000 0001 取反
		byte sll2 = (byte)0xff;
		System.out.println("```"+sll2);
		//1111 1110
		//1111 1101  减1
		//1000 0010  取反
		byte sll3 = (byte)0xfe;
		System.out.println("```"+sll3);
		//1000 0000
		//1111 1111
		//1000 0000
		byte sll4 = (byte)0x80;
		System.out.println("```"+sll4);
		
	}
	
}
