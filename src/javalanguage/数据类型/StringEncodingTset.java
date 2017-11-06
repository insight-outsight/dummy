package javalanguage.数据类型;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class StringEncodingTset {

	public static void main(String[] args) throws Exception {
		String s = "jt";
		String s1 = "阻力";
		System.out.println("1."+new String(s.getBytes("ISO-8859-1"),"ISO-8859-1"));
		System.out.println("2."+new String(s.getBytes("ISO-8859-1"),"UTF-8"));
		System.out.println("3."+new String(s.getBytes("UTF-8"),"UTF-8"));
		System.out.println("4."+new String(s.getBytes("UTF-8"),"ISO-8859-1"));
		System.out.println("-----------------------------------------------------------"+URLEncoder.encode("a", "UTF-8"));
		System.out.println("-----------------------------------------------------------"+URLEncoder.encode("到", "UTF-8"));
		System.out.println("-----------------------------------------------------------"+URLEncoder.encode("aa拿的", "UTF-8"));
		System.out.println("1."+new String(s1.getBytes("ISO-8859-1"),"ISO-8859-1"));
		System.out.println("2."+new String(s1.getBytes("ISO-8859-1"),"UTF-8"));
		System.out.println("3."+new String(s1.getBytes("UTF-8"),"UTF-8"));
		System.out.println("4."+new String(s1.getBytes("UTF-8"),"ISO-8859-1"));
		byte[] b = "到".getBytes("UTF-8");
		for(int i=0;i<b.length;i++){
			System.out.println(Integer.toBinaryString(b[i]));
		}
	}

}
