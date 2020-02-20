package javalanguage;

import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

/**
 * 
 * Reflection的getCallerClass的使用：可以得到调用者的类.这个方法是很好用的. 

0 和小于0  -   返回 Reflection类 

1  -   返回自己的类 

2  -    返回调用者的类 

3. 4. ....层层上传。 

 * 从jdk 7u40开始，Oracle已经弃用了sun.reflect.package包里不易理解的Reflection.
 * getCallerClass（int）方法。在Java 7中，通过设置Java命令行选项Djdk.reflect.allowGetCallerClass，
 * 可以继续使用该方法。但在Java 8及以后的版本中，该方法将被彻底删除，调用它会导致 UnsupportedOperationException异常。
 * 
 * 
 * 根据Java文档，Reflection类位于调用栈中的0帧位置，该方法返回调用栈中从0帧开始的第x帧中的类。总之，getCallerClass方法提供的机制可用于确定调用者，从而实现“感知调用者（Caller Sensitive）”的行为，即根据调用类或调用栈中的其它类来调整其自身的行为。
 * 
 * 
 * http://www.itzhai.com/get-invoker-by-stacktrace-and-getcallerclass.html#read-more
 * 
 * @author zcx
 *
 */
public class 取得调用本方法的类名 {

	public static void main(String[] args) {
		Test2 test = new Test2();
		test.g();
	}

}

class Test2 {
	public void g() {
		gg();
	}
	 @CallerSensitive
	public void gg() {
		System.out.println(Reflection.getCallerClass(-1));
		System.out.println(Reflection.getCallerClass(0));
		System.out.println(Reflection.getCallerClass(1));
		System.out.println(Reflection.getCallerClass(2));
		System.out.println(Reflection.getCallerClass(3));
		System.out.println(Reflection.getCallerClass(4));
		System.out.println(Reflection.getCallerClass(5));
	}

}
