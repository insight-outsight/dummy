package javalanguage.数据类型;

import java.io.UnsupportedEncodingException;



public class 测试整形值溢出等 {

	public static void main(String[] args) {
		
		System.out.println("ffffffffffffffffffffffffffffffffffffffffffff");
        System.out.println(Integer.MAX_VALUE+","+Integer.MIN_VALUE+","+(Integer.MAX_VALUE+1));
        System.out.println(((Integer.MAX_VALUE+1)==Integer.MIN_VALUE));
        System.out.println("一"+Integer.toBinaryString(-1));
        System.out.println("二"+Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println("三"+Integer.toBinaryString(Integer.MIN_VALUE));
        
        
        Integer aa1 = Integer.MAX_VALUE+1;
        Integer aa2 = Integer.MAX_VALUE+2;
        System.out.println("111,"+aa1);
        System.out.println("222,"+aa2);
        
        long bb1=2147483648l;
        System.out.println("四"+Long.toBinaryString(bb1));
        long bb2=2147483659l;
        System.out.println("五"+Long.toBinaryString(bb2));
        System.out.println("六"+Integer.toBinaryString(-2147483637));
        Integer aa3 = new Long(bb1).intValue();
        Integer aa4 = (int)bb2;
        System.out.println("333,"+aa3);
        System.out.println("444,"+aa4);
        System.out.println(aa3-aa4);

	}
	
}
