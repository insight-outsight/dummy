package javalanguage.crypto;

import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


/**
 * “HMAC是密钥相关的哈希运算消息认证码（Hash-based Message Authentication Code）,HMAC运算利
 * 用哈希算法，以一个密钥和一个消息为输入，生成一个消息摘要作为输出。一般用来作服务器端的签名验证。
 * @author zcx
 *
 */
public class HmacSha1Utils{

	/**
	 * 计算HMAC_SHA1
	 * @param message 待计算的消息
	 * @param key 运算用key,比如一台服务器的特有APP_SECRET
	 * @return
	 */
    public static byte[] hmacSha1Bytes(String message, String key) {
		try {
			
/*			KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA1");     
	      SecretKey secretKey = keyGenerator.generateKey(); 
	      System.out.println("=1="+secretKey.getAlgorithm());*/
			byte[] keyBytes = key.getBytes();//getBytes(""UTF-8")
			SecretKeySpec signingKey = new SecretKeySpec(keyBytes, "HmacSHA1");

			// Get an hmac_sha1 Mac instance and initialize with the signing key
			Mac mac = Mac.getInstance(signingKey.getAlgorithm());
			mac.init(signingKey);

			// Compute the hmac on input data bytes
			byte[] result = mac.doFinal(message.getBytes());
			
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 计算HMAC_SHA1
	 * @param message 待计算的消息
	 * @param key 运算用key,比如一台服务器的特有APP_SECRET
	 * @return
	 */
    public static String hmacSha1Base64(String message, String key) {
		try {
			byte[] bytes = hmacSha1Bytes(message, key);
			return Base64.getEncoder().encodeToString(bytes);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
    
    public static void main(String[] args) {
		System.out.println(Base64.getEncoder().encodeToString(hmacSha1Bytes("nihao", "daxuecheng")));
		System.out.println(hmacSha1Base64("nihao", "daxuecheng"));
	}
    
}
