package javalanguage.crypto;


import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;

/** *//**
 * <p>
 * RSA公钥/私钥/签名工具包
 * </p>
 * <p>
 * 罗纳德·李维斯特（Ron [R]ivest）、阿迪·萨莫尔（Adi [S]hamir）和伦纳德·阿德曼（Leonard [A]dleman）
 * </p>
 * <p>
 * 字符串格式的密钥在未在特殊说明情况下都为BASE64编码格式<br/>
 * 由于非对称加密速度极其缓慢，一般文件不使用它来加密而是使用对称加密，<br/>
 * 非对称加密算法可以用来对对称加密的密钥加密，这样保证密钥的安全也就保证了数据的安全
 * 
 * 注意：
 * RSA加密明文最大长度是有限制的，最大117字节,见{@link #genKeyPair()}，解密要求密文最大长度为128字节，所以在加密和解密的过程中需要分块进行。
 *  如果加密数据过大会抛出如下异常：
	Exception in thread "main" javax.crypto.IllegalBlockSizeException: Data must not be longer than 117 bytes  
    at com.sun.crypto.provider.RSACipher.a(DashoA13*..)  
    at com.sun.crypto.provider.RSACipher.engineDoFinal(DashoA13*..)  
    at javax.crypto.Cipher.doFinal(DashoA13*..) 
 * </p>
 * 
 * @author IceWee
 * @date 2012-4-26
 * @version 1.0
 */
public class RSAUtils {

    /** *//**
     * 加密算法RSA
     */
    public static final String KEY_ALGORITHM = "RSA";
    
    /** *//**
     * 签名算法
     */
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    /** *//**
     * 获取公钥的key
     */
    private static final String PUBLIC_KEY = "RSAPublicKey";
    
    /** *//**
     * 获取私钥的key
     */
    private static final String PRIVATE_KEY = "RSAPrivateKey";
    
    /** *//**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;
    
    /** *//**
     * RSA最大解密密文大小
     */
    private static final int MAX_DECRYPT_BLOCK = 128;

    public static void main(String[] args) {
		try {
			System.out.println("===================验证数字签名=======================");
			Map<String, Object> keyPairMap = genKeyPair();
			String privateKeyBase64 =  getPrivateKeyBase64(keyPairMap);
			String publicKeyBase64 =  getPublicKeyBase64(keyPairMap);

			System.out.println("privateKey="+privateKeyBase64);
			System.out.println("publicKey="+publicKeyBase64);
			
			byte[] src = "ewet".getBytes();
			//byte[] encryptedSrc = encryptByPrivateKey(src,privateKey);
			String signStr = signBase64(src, privateKeyBase64);
			System.out.println("signature="+signStr);
			System.out.println(verifyBase64(src, publicKeyBase64, signStr));
			
			System.out.println("===================验证数字签名2=======================");
			
			byte[] privateKey =  getPrivateKey(keyPairMap);
			byte[] publicKey =  getPublicKey(keyPairMap);
			
			byte[] src2 = "ewetrtfyrtyr777".getBytes();
			//byte[] encryptedSrc = encryptByPrivateKey(src,privateKey);
			byte[] sign2 = sign(src2, privateKey);
			System.out.println(verify(src2, publicKey, sign2));
			
			System.out.println("===================验证公钥加密，私钥解密。其中公钥私钥皆为Base64编码=======================");
			String rawdataStr = "ewetrtfyrtyr77事在人为7\ngoodbye ks.\n2014-2015";
			System.out.println("原始文字：\n"+rawdataStr);
			byte[] encryptDataByPublicKey = encryptByPublicKey(rawdataStr.getBytes(), publicKeyBase64);
			byte[] decryptDataByPrivateKey = decryptByPrivateKey(encryptDataByPublicKey,privateKeyBase64);
			System.out.println("再使用私钥解密加密过的文字：\n"+new String(decryptDataByPrivateKey));
			
			System.out.println("===================验证私钥加密，公钥解密。其中公钥私钥皆为Base64编码=======================");
			String rawdataStr2 = "today is Monday,we talk about something.\nin a part哈哈";
			System.out.println("原始文字：\n"+rawdataStr2);
			byte[] encryptDataByPirvateKey = encryptByPrivateKey(rawdataStr2.getBytes(), privateKeyBase64);
			byte[] decryptDataByPublicKey = decryptByPublicKey(encryptDataByPirvateKey, publicKeyBase64);
			System.out.println("再使用公钥解密加密过的文字：\n"+new String(decryptDataByPublicKey));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    /** *//**
     * <p>
     * 生成密钥对(公钥和私钥)
     * 从代码中可以看出密钥的初始化长度为1024位，密钥的长度越长，安全性就越好，但是加密解密所用的时间就会越多。
     * 而一次能加密的密文长度也与密钥的长度成正比。一次能加密的密文长度为：（密钥的长度/8-11）字节。所以1024bit长度的密钥一次
     * 可以加密的密文为1024/8-11=117 byte。
     * </p>
     * 
     * @return 
     * @throws Exception
     */
    public static Map<String, Object> genKeyPair() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        Map<String, Object> keyMap = new HashMap<String, Object>(2);
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;
    }
    
    /** *//**
     * <p>
     * 获取私钥
     * </p>
     * 
     * @param keyMap 密钥对
     * @return BASE64编码过的私钥
     * @throws Exception
     */
    public static String getPrivateKeyBase64(Map<String, Object> keyMap)
            throws Exception {
        return Base64.getEncoder().encodeToString(getPrivateKey(keyMap));
    }
    
    /** *//**
     * <p>
     * 获取私钥
     * </p>
     * 
     * @param keyMap 密钥对
     * @return BASE64编码过的私钥
     * @throws Exception
     */
    public static byte[] getPrivateKey(Map<String, Object> keyMap)
            throws Exception {
        Key key = (Key) keyMap.get(PRIVATE_KEY);
//        System.out.println("/+0+"+new String(key.getEncoded()));
        return key.getEncoded();
    }
    

    /** *//**
     * <p>
     * 获取公钥
     * </p>
     * 
     * @param keyMap 密钥对
     * @return BASE64编码过的公钥
     * @throws Exception
     */
    public static String getPublicKeyBase64(Map<String, Object> keyMap)
            throws Exception {
        return Base64.getEncoder().encodeToString(getPublicKey(keyMap));
    }
    
    /** *//**
     * <p>
     * 获取公钥
     * </p>
     * 
     * @param keyMap 密钥对
     * @return BASE64编码过的公钥
     * @throws Exception
     */
    public static byte[] getPublicKey(Map<String, Object> keyMap)
            throws Exception {
        Key key = (Key) keyMap.get(PUBLIC_KEY);
        return key.getEncoded();
    }
    
    /** *//**
     * <p>
     * 用私钥对信息生成数字签名
     * </p>
     * 
     * @param data 已加密数据
     * @param privateKey 私钥(BASE64编码)
     * 
     * @return 数字签名(BASE64编码)
     * @throws Exception
     */
    public static String signBase64(byte[] data, String privateKey) throws Exception {
    	  byte[] privateKeyBytes = Base64.getDecoder().decode(privateKey);
        return Base64.getEncoder().encodeToString(sign(data,privateKeyBytes));
    }
    
    /** *//**
     * <p>
     * 用私钥对信息生成数字签名
     * </p>
     * 
     * @param data 已加密数据
     * @param privateKeyBytes 私钥字节流
     * 
     * @return 数字签名(BASE64编码)
     * @throws Exception
     */
    public static String signBase64(byte[] data, byte[] privateKeyBytes) throws Exception {
        return Base64.getEncoder().encodeToString(sign(data,privateKeyBytes));
    }
    
    /** *//**
     * <p>
     * 用私钥对信息生成数字签名
     * </p>
     * 
     * @param data 已加密数据
     * @param privateKeyBytes 私钥字节流
     * 
     * @return
     * @throws Exception
     */
    public static byte[] sign(byte[] data, byte[] privateKeyBytes) throws Exception {
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(privateK);
        signature.update(data);
        return signature.sign();
    }
    

    /** *//**
     * <p>
     * 校验数字签名
     * </p>
     * 
     * @param data 已加密数据
     * @param publicKey 公钥(BASE64编码)
     * @param sign 数字签名(BASE64编码)
     * 
     * @return
     * @throws Exception
     * 
     */
    public static boolean verifyBase64(byte[] data, String publicKey, String sign)
            throws Exception {
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKey);
        return verify(data, publicKeyBytes, Base64.getDecoder().decode(sign));
    }

    /** *//**
     * <p>
     * 校验数字签名
     * </p>
     * 
     * @param data 已加密数据
     * @param publicKey 公钥字节流
     * @param sign 数字签名字节流
     * 
     * @return
     * @throws Exception
     * 
     */
    public static boolean verify(byte[] data, byte[] publicKeyBytes, byte[] sign)
            throws Exception {
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicK = keyFactory.generatePublic(keySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(publicK);
        signature.update(data);
        return signature.verify(sign);
    }
    
    /** *//**
     * <P>
     * 私钥解密
     * </p>
     * 
     * @param encryptedData 已加密数据
     * @param privateKey 私钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] encryptedData, String privateKey)
            throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateK);
        int inputLen = encryptedData.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
           // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        return decryptedData;
    }

    /** *//**
     * <p>
     * 公钥解密
     * </p>
     * 
     * @param encryptedData 已加密数据
     * @param publicKey 公钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(byte[] encryptedData, String publicKey)
            throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicK = keyFactory.generatePublic(x509KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicK);
        int inputLen = encryptedData.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        return decryptedData;
    }

    /** *//**
     * <p>
     * 公钥加密
     * </p>
     * 
     * @param data 源数据
     * @param publicKey 公钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data, String publicKey)
            throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicK = keyFactory.generatePublic(x509KeySpec);
        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicK);
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段加密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }

    /** *//**
     * <p>
     * 私钥加密
     * </p>
     * 
     * @param data 源数据
     * @param privateKey 私钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(byte[] data, String privateKey)
            throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateK);
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段加密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }



}
