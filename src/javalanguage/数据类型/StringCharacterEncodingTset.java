package javalanguage.数据类型;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import commons.constant.CharsetEncodingConstants;

public class StringCharacterEncodingTset {

	private final static String UTF_8 = CharsetEncodingConstants.UTF_8;
	private final static String GBK = CharsetEncodingConstants.GBK;
	private final static String ISO_8859_1 = CharsetEncodingConstants.ISO_8859_1;
	
	public static void main(String[] args) throws Exception {
		
//		encodeAndDecodingTest();
		charBytePlaceHolderTest();
    	System.exit(-5);

	}

	private static void charBytePlaceHolderTest() throws UnsupportedEncodingException {
//    	String aabbc = "w的et344w09d天";
    	String aabbc = "发f地真𨭎e";// "𨭎", "𠬠", and "𩷶"这些字符占2个char，即4个byte
    	System.out.println("1.字符串长度为："+aabbc.length()+"，bytes长度："+aabbc.getBytes().length);
    	String aabc = "发f地真e";
    	System.out.println("2.字符串长度为："+aabc.length()+"，bytes长度："+aabc.getBytes().length);
    	String abc = "发fe";
    	System.out.println("3.字符串长度为："+abc.length()+"，bytes长度："+abc.getBytes().length);
    	String ac = "发f";
    	System.out.println("4.字符串长度为："+ac.length()+"，bytes长度："+ac.getBytes().length);
    	String c = "发";
    	System.out.println("5.字符串长度为："+c.length()+"，bytes长度："+c.getBytes().length);
    	String a = "f";
    	System.out.println("6.字符串长度为："+a.length()+"，bytes长度："+a.getBytes().length);
    	String b = "𨭎";
    	System.out.println("7.字符串长度为："+b.length()+"，bytes长度："+b.getBytes().length);

    	String printStrTemplate = "编码[%s]，所占字节长度为[%d]";
    	
    	byte[] bbb00 = aabbc.getBytes(ISO_8859_1);
    	System.out.println("0--"+String.format(printStrTemplate,ISO_8859_1,bbb00.length));
    	printByteBinaryStr(bbb00);
    	
    	byte[] bbb11 = aabbc.getBytes(GBK);
    	System.out.println("1--"+String.format(printStrTemplate,GBK,bbb11.length));
    	
    	byte[] bbb22 = aabbc.getBytes(UTF_8);
    	System.out.println("2--"+String.format(printStrTemplate,UTF_8,bbb22.length));
    	printByteBinaryStr(bbb22);
    	
    	String ss33 = new String(bbb22,UTF_8);
    	System.out.println("3--"+String.format(printStrTemplate,UTF_8,ss33.getBytes(UTF_8).length));
	}

	public static void encodeAndDecodingTest() throws Exception{
		String s英文 = "jt";
		String s汉字 = "阻力";
		System.out.println("1."+new String(s英文.getBytes(ISO_8859_1),ISO_8859_1));
		System.out.println("2."+new String(s英文.getBytes(ISO_8859_1),UTF_8));
		System.out.println("3."+new String(s英文.getBytes(UTF_8),UTF_8));
		System.out.println("4."+new String(s英文.getBytes(UTF_8),ISO_8859_1));
		System.out.println("-----------------------------------------------------------"+URLEncoder.encode("a", UTF_8));
		System.out.println("-----------------------------------------------------------"+URLEncoder.encode("到", UTF_8));
		System.out.println("-----------------------------------------------------------"+URLEncoder.encode("aa拿的", UTF_8));
		System.out.println("1."+new String(s汉字.getBytes(ISO_8859_1),ISO_8859_1));
		System.out.println("2."+new String(s汉字.getBytes(ISO_8859_1),UTF_8));
		System.out.println("3."+new String(s汉字.getBytes(UTF_8),UTF_8));
		System.out.println("4."+new String(s汉字.getBytes(UTF_8),ISO_8859_1));
		byte[] b = "到".getBytes(UTF_8);
		for(int i=0;i<b.length;i++){
			System.out.println(Integer.toBinaryString(b[i]));
		}
	}

	private static void printByteBinaryStr(byte[] bbb22) {
		for(int i=0;i<bbb22.length;i++) {
//			System.out.println(bbb22[i]);
		}
	}
	
}
