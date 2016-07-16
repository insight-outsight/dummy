package com.selffun.clover.algorithm;


/**
 * 
 * 	一：递归实现
	使用公式f[n]=f[n-1]+f[n-2]，依次递归计算，递归结束条件是f[1]=1，f[2]=1。
	时间复杂度0(n的n次方)，效率非常低下，使用在一台4核500M堆空间的JVM计算第99项值，需要N小时，甚至N天。
   	二：数组实现
	空间复杂度和时间复杂度都是0(n)，效率一般，比递归来得快。
   	三：queue实现
	当然队列比数组更适合实现斐波那契数列，时间复杂度0(n)和空间复杂度0(2)，但队列太适合这里了，
	f(n)=f(n-1)+f(n-2)，f(n)只和f(n-1)和f(n-2)有关，f(n)入队列后，f(n-2)就可以出队列了。
	四：迭代实现
	迭代实现是最高效的，时间复杂度是0(n)，空间复杂度是0(1)。
	五：公式实现
	发现原来斐波那契数列有公式的，所以可以使用公式来计算的。
	空间复杂度和时间复杂度都是0(1)。
	由于double类型的精度还不够，所以程序算出来的结果会有误差，如果把公式展开计算，得出的结果就是正确的。

 * @author root
 *
 */
public class Fibonacci {

	public static void main(String[] args) {
	
		System.out.println("--------------------------------------");
		System.out.println(recursive(3));
		System.out.println(recursive(4));
		System.out.println(recursive(9));
		System.out.println("--------------------------------------");		
		System.out.println(iterate(3));
		System.out.println(iterate(4));
		System.out.println(iterate(5));
		System.out.println(iterate(19));
		System.out.println("--------------------------------------");
		System.out.println(formular(3));
		System.out.println(formular(4));
		System.out.println(formular(5));
		System.out.println(formular(19));
		
	}
	
	public static int recursive(int n){
		if(n<1){
			throw new IllegalArgumentException("n<0 in Fibonacci item");
		}else if(n<3){
			return 1;
		}else{
			return recursive(n-1)+recursive(n-2);
		}
	}

	public static int iterate(int n){
		if(n<1){
			throw new IllegalArgumentException("n<0 in Fibonacci item");
		}else if(n<3){
			return 1;
		}else{
			int a1=1,a2=1,an = 0;
			for(int i=3;i<=n;i++){
				an=a1+a2;
				a1=a2;
				a2=an;
			}
			return an;
		}
	}
	
	public static double formular(int n){
		double gh5=Math.sqrt((double)5);
		return (Math.pow((1+gh5),n)-Math.pow((1-gh5),n))/(Math.pow((double)2,n)*gh5);
	}
	
}