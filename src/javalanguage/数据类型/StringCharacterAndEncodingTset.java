package javalanguage.数据类型;

import java.io.UnsupportedEncodingException;

public class StringCharacterAndEncodingTset {

	public static void main(String[] args) throws UnsupportedEncodingException {
    	String charsetName = "utf-8";
//    	String aabbc = "w的et344w09d天";
    	String aabbc = "发f地真𨭎e";// "𨭎", "𠬠", and "𩷶".
    	System.out.println("字串符长度为:"+aabbc.length());
    	byte[] bbb11 = aabbc.getBytes("ISO-8859-1");
    	System.out.println("0--"+bbb11.length);
    	printByteBinaryStr(bbb11);
    	byte[] bbb00 = aabbc.getBytes("GBK");
    	System.out.println("00--"+bbb00.length);
    	byte[] bbb22 = aabbc.getBytes(charsetName);
    	System.out.println("1--"+bbb22.length);
    	printByteBinaryStr(bbb22);
    	String ss33 = new String(bbb22,charsetName);
    	System.out.println("2--"+ss33.getBytes(charsetName).length);
    	System.exit(-5);

	}

	

	private static void printByteBinaryStr(byte[] bbb22) {
		for(int i=0;i<bbb22.length;i++) {
//			System.out.println(bbb22[i]);
		}
	}
	
}
