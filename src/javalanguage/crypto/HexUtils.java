package javalanguage.crypto;

import java.util.UUID;

public class HexUtils {

    private final static int UUID_UNIT_LEN = 32; 
	
	/**
	 * 
	 * @param uuidNums 需要的UUID字符串数据，每个UUID为32位16进制
	 * @return 返回UUID串组成StringBuilder
	 */
	public static StringBuilder randomHexString(long uuidNums) {

		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < uuidNums; i++) {
			sb.append(UUID.randomUUID().toString().replace("-", ""));
		}
		return sb;
		
	}

	/**
	 * 
	 * @param len 需要生成16进制字符串长度
	 * @return 长度为len的16进制字符串长度
	 */
	public static String getRandomHexString(int len) {
		
		int needTimes = len%UUID_UNIT_LEN==0?len/UUID_UNIT_LEN:(len/UUID_UNIT_LEN+1);
		System.out.println(needTimes);
		StringBuilder sb = randomHexString(needTimes);
		System.out.println(sb.toString().length());
		return sb.substring(0, len);
		
	}
	
	/**
	 * 
	 * @param len 需要生成的16进制字符串长度
	 * @param num 需要生成的16进制字符串数量
	 * @return 16进制字符串数组
	 */
	public static String[] getRandomHexStringArray(int len,int num) {
		
		int totalLen = len*num;
		int needTimes = totalLen%UUID_UNIT_LEN==0?totalLen/UUID_UNIT_LEN:(totalLen/UUID_UNIT_LEN+1);
		StringBuilder sb = randomHexString(needTimes);
		String[] result = new String[num];
		for (int i = 0; i < num; i++) {
			result[i]=sb.substring(0, len);
			sb.delete(0, len);
			System.out.println(result[i]);
		}
		return result;
	
	}
	
	
	
	public static void main(String[] args) {
		

//		System.out.println(getRandomHexString(30).length());
		getRandomHexStringArray(15,2);
	}
	
	
}