package javalanguage.数据类型;

import java.io.UnsupportedEncodingException;



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
		
		String s = "3.0350";
		System.out.println(Float.parseFloat(s));
		
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
		
		System.out.println("'e' Length-----"+"e".getBytes().length);//1
		System.out.println("'杉' Length-----"+"杉".getBytes().length);//3
		System.out.println("'𪚥' Length-----"+"𪚥".getBytes().length);//4
		
		System.out.println("'e' Length()-----"+"e".length());//1
		System.out.println("'杉' Length()-----"+"杉".length());//1
		System.out.println("'𪚥' Length()-----"+"𪚥".length());//2
		
		String testString = "ier2杉S𪚥已";
		byte[] bytes = testString.getBytes();
		System.out.println("bytes Length-----"+bytes.length);//15
		System.out.println("testString Length-----"+testString.length());//9
		String testString2 = "ier2杉S已";
		byte[] bytes2 = testString2.getBytes();
		System.out.println("bytes2 Length-----"+bytes2.length);//11
		System.out.println("testString2 Length-----"+testString2.length());//7
		String testString3 = "iqer2杉S𪚥已";
		byte[] bytes3 = testString3.getBytes();
		System.out.println("bytes3 Length-----"+bytes3.length);//16
		System.out.println("testString3 Length-----"+testString3.length());//10
		/*try {
			System.out.println("cp3-----"+Integer.toHexString("er2杉S𪚥已".codePointAt(3)));
			System.out.println("cp4-----"+Integer.toHexString("er2杉S𪚥已".codePointAt(4)));
			System.out.println("cp5-----"+Integer.toHexString("er2杉S𪚥已".codePointAt(5)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String stringFromBytes = new String(bytes);
		System.out.println(stringFromBytes);
		System.out.println("stringFromBytes Length-----"+stringFromBytes.length());
		 
		bytes[2]="地".getBytes()[0];
		System.out.println("bytes Length改变后--"+bytes.length);
		System.out.println(stringFromBytes);
		System.out.println("stringFromBytes Length改变后--"+stringFromBytes.length());
		 
		String stringFromBytes2 = new String(bytes);
		System.out.println(stringFromBytes2);
		System.out.println("stringFromBytes2 Length--"+stringFromBytes2.length());
		
		System.out.println("e而wtr月".getBytes().length);
		try {
			System.out.println("e而wtr月".getBytes("UTF-8").length);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
*/
	}
	
}
