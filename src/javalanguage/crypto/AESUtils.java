package javalanguage.crypto;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESUtils {

		
		public static void main(String[] args) throws Exception {
			String eS = new String(encrypt("bbb4ccc4ddd4eee4".getBytes(), "GUgemWNhGTrh6kSM"));
			System.out.println("a--"+eS);
			System.out.println("b--"+new String(eS.getBytes(), "GUgemWNhGTrh6kSM"));
		}
		
	    public static byte[] encrypt(byte[] src, String key) throws Exception {           
	        return encrypt(src, key.getBytes());
	    }   

	    public static byte[] encrypt(byte[] src, byte[] key) throws Exception {   
	        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");   
	        SecretKeySpec securekey = new SecretKeySpec(key, "AES");   
	        cipher.init(Cipher.ENCRYPT_MODE, securekey);
	        return cipher.doFinal(src);   
	    }  
	    
	    public static byte[] decrypt(byte[] src, String key) throws Exception {   
	        return decrypt(src, key.getBytes());
	    }

	    public static byte[] decrypt(byte[] src, byte[] key) throws Exception {   
	        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");   
	        SecretKeySpec securekey = new SecretKeySpec(key, "AES");
	        cipher.init(Cipher.DECRYPT_MODE, securekey);
	        return cipher.doFinal(src);
	    }    
	    
	    public static void encrypt(byte[] data, int off, int len, byte[] key) throws Exception {
	        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");   
	        SecretKeySpec securekey = new SecretKeySpec(key, "AES");   
	        cipher.init(Cipher.ENCRYPT_MODE, securekey);
	        cipher.doFinal(data, off, len, data, off);       	
	    }

	    public static void decrypt(byte[] data, int off, int len, byte[] key) throws Exception {
	        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");   
	        SecretKeySpec securekey = new SecretKeySpec(key, "AES");   
	        cipher.init(Cipher.DECRYPT_MODE, securekey);
	        cipher.doFinal(data, off, len, data, off);     	
	    }
	        

}
