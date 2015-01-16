package javalanguage.数据类型;



public class Primitive {

	public static void main(String[] args) {
		int i=5;
		long j=5;
		System.out.println(i==j);//true
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
		System.out.println(0x7fffffff);//最大正数2147483647
		
		//1000 0000 0000 0000 0000 0000 0000 0000
		System.out.println(0x80000000);//最大正数-2147483648
		
		//1000 0000 0000 0000 0000 0000 0000 0001
		System.out.println(0x80000001);//-2147483647
		
		//1111 1111 1111 1111 1111 1111 1111 1110
		System.out.println(0xfffffffe);//-2
		
		//1111 1111 1111 1111 1111 1111 1111 1111
		System.out.println(0xffffffff);//-1
		
		//0000 0000 0000 0000 0000 0000 0000 0000
		System.out.println(0x00000000);//0
		
		System.out.println("********************************************");
		
		double d = 8.9776645365376410987455435211244364365666666666666666666666666666666123450976865532424355777437676575467557645768033333333211566790886876555;
		System.out.println(d);

		double dc = 288888888888d;
		System.out.println(dc);
		
		System.out.println("============================================");
		int qh = 0x11ff;
		byte sll = (byte)qh;
		//1111 1111  0xff
		//1111 1110  减1
		//1000 0001 取反
		System.out.println("``"+sll);

		byte sll2 = (byte)0xff;
		//1111 1111  0xff
		//1111 1111  减1
		//1000 0001  取反
		System.out.println("```"+sll2);

		byte sll3 = (byte)0xfe;
		//1111 1110  0xff
		//1111 1101  减1
		//1000 0010  取反
		System.out.println("````"+sll3);
		
		//1000 0000
		//1111 1111
		//1000 0000
		byte sll4 = (byte)0x80;
		System.out.println("````"+sll4);
		
/*		wrong
 		int c33 = 1887;
		char b44 = c33;*/
		
		char b2 = 'A';
		int wb2 = b2;
		System.out.println(wb2); //65
		
		char b3 = '雪';
		int wb3 = b3;
		System.out.println(wb3); //38634
		
		byte[] bs = "er2杉S𪚥已".getBytes();
		System.out.println("bytesLengh-----"+bs.length);
		try {
			System.out.println("cp3-----"+Integer.toHexString("er2杉S𪚥已".codePointAt(3)));
			System.out.println("cp4-----"+Integer.toHexString("er2杉S𪚥已".codePointAt(4)));
			System.out.println("cp5-----"+Integer.toHexString("er2杉S𪚥已".codePointAt(5)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String bss = new String(bs);
		System.out.println(bss);
		System.out.println("stringLengh-----"+bss.length());
		 
		bs[2]="地".getBytes()[0];
		System.out.println("bytesLengh--"+bs.length);
		System.out.println(bss);
		System.out.println("stringLengh--"+bss.length());
		 
		String bss2 = new String(bs);
		System.out.println(bss2);
		System.out.println("stringLengh--"+bss2.length());

	}
	
}
