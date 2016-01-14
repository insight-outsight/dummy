package javalanguage.数据类型;

public class String_Character_Byte {

	public static void main(String[] args) {
		System.out.println("'e'.getBytes().Length-----"+"e".getBytes().length);//1
		System.out.println("'杉'.getBytes().Length-----"+"杉".getBytes().length);//3
		System.out.println("'𪚥'.getBytes().Length-----"+"𪚥".getBytes().length);//4
		
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
