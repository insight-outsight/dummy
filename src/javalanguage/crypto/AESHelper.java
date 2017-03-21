package javalanguage.crypto;


/**
 * 
	Java Cryptography Extension (JCE)中使用AES算法加密时，当密钥大于128时，代码会抛出java.security.In
	validKeyException: Illegal key size or default parameters，去掉这种限制需要下
	载Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files.
	
	JCE中AES支持五中模式：CBC，CFB，ECB，OFB，PCBC；
	支持三种填充：NoPadding，PKCS5Padding，ISO10126Padding。
	不支持SSL3Padding。不支持“NONE”模式。
	 
	其中AES/ECB/NoPadding和我现在使用的AESUtil得出的结果相同(在16的整数倍情况下)。
	不带模式和填充来获取AES算法的时候，其默认使用ECB/PKCS5Padding。
	 
	算法/模式/填充                   			16字节加密后数据长度                          不满16字节加密后长度
	AES/CBC/NoPadding              16                                                                      不支持
	AES/CBC/PKCS5Padding           32                         16
	AES/CBC/ISO10126Padding        32                         16
	AES/CFB/NoPadding              16                                                                原始数据长度
	AES/CFB/PKCS5Padding           32                         16
	AES/CFB/ISO10126Padding        32                         16
	AES/ECB/NoPadding              16                                                                         不支持
	AES/ECB/PKCS5Padding           32                         16
	AES/ECB/ISO10126Padding        32                         16
	AES/OFB/NoPadding              16                                                                     原始数据长度
	AES/OFB/PKCS5Padding           32                         16
	AES/OFB/ISO10126Padding        32                         16
	AES/PCBC/NoPadding             16                                                                      不支持
	AES/PCBC/PKCS5Padding          32                         16
	AES/PCBC/ISO10126Padding       32                         16
	 
	可以看到，在原始数据长度为16的整数倍时，假如原始数据长度等于16*n，则使用NoPadding时加密后数据长度等于16*n，其它情
	况下加密数据长度等于16*(n+1)。在不足16的整数倍的情况下，假如原始数据长度等于16*n+m[其中m小于16]，除了NoPadding填充
	之外的任何方式，加密数据长度都等于16*(n+1)；NoPadding填充情况下，CBC、ECB和PCBC三种模式是不支持的，CFB、OFB两种
	模式下则加密数据长度等于原始数据长度。
		
	Reference:
	1. http://blog.itpub.net/23071790/viewspace-723489/
	2. http://blog.chinaunix.net/uid-196845-id-2788287.html

 */
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


/**
 * ClassName:AESHelper
 *
 * @author   songjianyong
 * @version  1.0
 * @since    v1.0
 * @Date	 2012-6-29 下午2:06:07 
 */
public class AESHelper {


	public static void main(String[] args) {

		
		String content = "宋建勇";
		String password = "12345678";
		byte[] encryptResult = encrypt(content, password);//加密
		byte[] decryptResult = decrypt(encryptResult,password);//解密
		System.out.println("解密后：" + new String(decryptResult));
		
		/*容易出错的地方，请看下面代码*/
//		System.out.println("***********************************************");
//		try {
//			String encryptResultStr = new String(encryptResult,"utf-8");
//			decryptResult = decrypt(encryptResultStr.getBytes("utf-8"),password);
//			System.out.println("解密后：" + new String(decryptResult));
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		/*则，系统会报出如下异常：javax.crypto.IllegalBlockSizeException: Input length must be multiple of 16 when decrypting with padded cipher
	at com.sun.crypto.provider.SunJCE_f.b(DashoA13*..)
	at com.sun.crypto.provider.SunJCE_f.b(DashoA13*..)
	at com.sun.crypto.provider.AESCipher.engineDoFinal(DashoA13*..)
	at javax.crypto.Cipher.doFinal(DashoA13*..)
	at cn.com.songjy.test.ASCHelper.decrypt(ASCHelper.java:131)
	at cn.com.songjy.test.ASCHelper.main(ASCHelper.java:58)
		 * */
		/*这主要是因为加密后的byte数组是不能强制转换成字符串的, 换言之,字符串和byte数组在这种情况下不是互逆的,
		 * 要避免这种情况，我们需要做一些修订，可以考虑将二进制数据转换成十六进制表示,
		 * 主要有两个方法:将二进制转换成16进制(见方法parseByte2HexStr)或是将16进制转换为二进制(见方法parseHexStr2Byte)*/
		
		/*然后，我们再修订以上测试代码*/
		System.out.println("***********************************************");
		String encryptResultStr = parseByte2HexStr(encryptResult);
		System.out.println("加密后：" + encryptResultStr);
		byte[] decryptFrom = parseHexStr2Byte(encryptResultStr);
		decryptResult = decrypt(decryptFrom,password);//解码
		System.out.println("解密后：" + new String(decryptResult));
	}

	public static String encryptToHexStr(String content, String password){
		byte[] result = encrypt(content, password);
		return parseByte2HexStr(result); 
	}
	
	public static String decryptFromHexStr(String content, String password){
		return new String(decrypt(parseHexStr2Byte(content),password));
	}
	
	/**
	 * 加密
	 * @method encrypt
	 * @param content	需要加密的内容
	 * @param password	加密密码
	 * @return
	 * @throws 
	 * @since v1.0
	 */
	public static byte[] encrypt(String content, String password){
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(128, new SecureRandom(password.getBytes()));
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
			byte[] byteContent = content.getBytes("utf-8");
			cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(byteContent);
			return result; // 加密
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}catch (InvalidKeyException e) {
			e.printStackTrace();
		}catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		}catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 解密
	 * @method decrypt
	 * @param content	待解密内容
	 * @param password	解密密钥
	 * @return
	 * @throws 
	 * @since v1.0
	 */
	public static byte[] decrypt(byte[] content, String password){
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(128, new SecureRandom(password.getBytes()));
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
			cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(content);
			return result; // 解密
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}catch (InvalidKeyException e) {
			e.printStackTrace();
		}catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		}catch (BadPaddingException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 将二进制转换成16进制
	 * @method parseByte2HexStr
	 * @param buf
	 * @return
	 * @throws 
	 * @since v1.0
	 */
	public static String parseByte2HexStr(byte buf[]){
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < buf.length; i++){
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}
	
	/**
	 * 将16进制转换为二进制
	 * @method parseHexStr2Byte
	 * @param hexStr
	 * @return
	 * @throws 
	 * @since v1.0
	 */
	public static byte[] parseHexStr2Byte(String hexStr){
		if(hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length()/2];
		for (int i = 0;i< hexStr.length()/2; i++) {
			int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
			int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}
	
	/**
	 * 另外一种加密方式--这种加密方式有两种限制
	 * 1、密钥必须是16位的
	 * 2、待加密内容的长度必须是16的倍数，如果不是16的倍数，就会出如下异常
	 * javax.crypto.IllegalBlockSizeException: Input length not multiple of 16 bytes
        at javax.crypto.Cipher.doFinal()
	         要解决如上异常，可以通过补全传入加密内容等方式进行避免。
	 * @method encrypt2
	 * @param content	需要加密的内容
	 * @param password	加密密码
	 * @return
	 * @throws 
	 * @since v1.0
	 */
	public static byte[] encrypt2(String content, String password){
		try {
			SecretKeySpec key = new SecretKeySpec(password.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
			byte[] byteContent = content.getBytes("utf-8");
			cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(byteContent);
			return result; // 加密
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}

