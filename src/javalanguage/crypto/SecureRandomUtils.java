package javalanguage.crypto;

import java.security.SecureRandom;

/**
 * 
 * 特别是在生成验证码的情况下，不要使用Random，因为它是线性可预测的。记得有个新闻说的是一个赌博网站，为了说明其公平，公开的它的源代码，结果因为随机数可预测漏洞被攻击了。所以在安全性要求比较高的场合，应当使用SecureRandom。
         参考：http://www.inbreak.net/archives/349

       产生高强度的随机数，有两个重要的因素：种子和算法。当然算法是可以有很多的，但是如何选择种子是非常关键的因素。
       如Random，它的种子是System.currentTimeMillis()，所以它的随机数都是可预测的。那么如何得到一个近
       似随机的种子？这里有一个很别致的思路：收集计算机的各种信息，如键盘输入时间，CPU时钟，内存使用状态，硬盘空闲空间，
       IO延时，进程数量，线程数量等信息，来得到一个近似随机的种子。这样的话，除了理论上有破解的可能，实际上
       基本没有被破解的可能。而事实上，现在的高强度的随机数生成器都是这样实现的。

      最快的安全性要求不高的生成UUID的方法：

  new UUID(ThreadLocalRandom.current().nextLong(), ThreadLocalRandom.current().nextLong());

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
