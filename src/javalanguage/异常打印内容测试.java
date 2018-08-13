package javalanguage;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class 异常打印内容测试 {

	public static void main(String[] args) {
		try {
			decrypt("sdtwt12345678900".getBytes());
		} catch (Exception e) {
			System.out.println("aaa");
			//output stack trace
			e.printStackTrace();
			System.out.println("ooo");
			//output []javax.crypto.BadPaddingException: Given final block not properly padded
			System.out.println("[]"+e);
		}
	}

	public static byte[] decrypt(byte[] encrypted) throws Exception {

		
		for (int k = 0; k < encrypted.length; k++)
			System.out.print(encrypted[k] + " ");

		System.out.print("\n");
		
		System.out.print("1\n");

		byte[] raw = { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08,
				0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f };
		Cipher cipher = Cipher.getInstance("AES");
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");

		System.out.print("2\n");

		cipher.init(Cipher.DECRYPT_MODE, skeySpec);
		System.out.print("3\n");

		byte[] decrypted = cipher.doFinal(encrypted);
		System.out.print("4\n");

		String originalString = new String(decrypted);
		System.out.println("Original string: " + originalString + " "
				+ new String(decrypted));

		System.out.print("\n5");
		return decrypted;
	}

}
