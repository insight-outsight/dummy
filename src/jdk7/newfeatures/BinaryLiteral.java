package jdk7.newfeatures;

public class BinaryLiteral {

	public static void main(String[] args) {
		/**
		 * JDK7开始，终于可以用二进制来表示整数（byte,short,int和long）。
		 * 使用二进制字面量的好处是，可以是代码更容易被理解。
		 * 语法非常简单，只要在二进制数值前面加 0b或者0B
		 */
		byte nByte = (byte) 0b0001;
		short nShort = (short) 0B0010;
		int nInt = 0b100011;
		long nLong = 0b0100L;

		System.out.println(nByte);
		System.out.println(nShort);
		System.out.println(nInt);
		System.out.println(nLong);

		//在数字常量中使用下载线，注意只能将下划线置于数字之间
		int a = 10_0000_0000;
		long b = 0xffff_ffff_ffff_ffffl;
		byte c = 0b0001_1000;

		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		System.out.println("hearting from rain and snow.");
		int q=1998;
		if(2013-q>10){
			System.out.println("good company");
		}
		System.out.println(new java.util.Date());
		
		String lint = "revoke,question mark";
		System.out.println(lint);

	}

}