package javalanguage.数据类型;


/**
 * 　strictfp 关键字可应用于类、接口或方法。使用 strictfp 关键字声明一个方法时，该方法中所有的float和double表达式都严格遵守FP-strict的限制,符合IEEE-754规范。
 * 当对一个类或接口使用 strictfp 关键字时，该类中的所有代码，包括嵌套类型中的初始设定值和代码，都将严格地进行计算。严格约束意味着所有表达式的结果都必须是 IEEE 754 算法对操作数预期的结果，以单精度和双精度格式表示。
　　如果你想让你的浮点运算更加精确，而且不会因为不同的硬件平台所执行的结果不一致的话，可以用关键字strictfp. 

 * @author u0007
 *
 */
public strictfp class StrictfpClassTset {
	public static void main(String[] args) {
		float aFloat = 0.6710339f;
		double aDouble = 0.04150553411984792d;
		double sum = aFloat + aDouble;
		float quotient = (float) (aFloat / aDouble);
		System.out.println("float: " + aFloat);
		System.out.println("double: " + aDouble);
		System.out.println("sum: " + sum);
		System.out.println("quotient: " + quotient);
	}
}