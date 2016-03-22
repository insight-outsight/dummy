package javalanguage.crypto;

import java.security.SecureRandom;

/**
 * Random类的next(n)方法依靠确定的seed种子来计算nextseed的值（seed位48位的bit），尽管使用了各种运算，但结果仍然是线性可预测的。
 * 从程序可以看到，只要seed确定，那么nextseed也就确定，那整个序列都可以被重建出来。故如果对于随机的情景，如果攻击者获取了最初的种子seed，那么他将可以轻易模拟出随机数，并得到下一个seed。或者他通过穷举seed来获取计算的随机数来匹配程序的随机数。
 * 所以对安全性有要求的随机数应用情景，可以用java.security.SecureRandom。代替伪随机的Random类。该类继承自Random类，并覆盖了next（n）函数，所以可以利用其提供的强随机的种子算法（SHA1PRNG）来生成随机数。
 * 效率上肯定有损失，大概相差1个数量级。
 * 
 * 
 * Ref  http://www.51testing.com/html/63/n-818863-2.html
 * 
 * @author xuzhengchao
 *
 */
public class SecureRandomUtils {

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
		System.out.println("uu"+(-1>>>1));

		for (int i = 0; i < 100; i++){
			System.out.println(getSecureRandomInt(false));
		}

	}

	public static int getSecureRandomInt(boolean onlyReturnPositive) {
		SecureRandom secureRandom = new SecureRandom();
		secureRandom.setSeed(System.currentTimeMillis() + 1234567);
		int result = secureRandom.nextInt();
		if(result<0 && onlyReturnPositive){
			result>>>=1;
		}
		return result;
	}

}
