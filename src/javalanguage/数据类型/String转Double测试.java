package javalanguage.数据类型;

public class String转Double测试 {

	public static void main(String[] args) {
		 String s = "5.020";
		 double d = Double.parseDouble(s);
		 System.out.println(d);
		 
		 String s2 = "5.00";
		 double d2 = Double.parseDouble(s2);
		 System.out.println(d2);
		 
		 
		 String s3 = "944.38";
		 double d3 = Double.parseDouble(s3);
		 System.out.println(d3);
		 
		 
		 String s4 = "200";
		 double d4 = Double.parseDouble(s4);
		 System.out.println(d4);
	}

}
