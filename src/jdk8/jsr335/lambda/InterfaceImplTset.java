package jdk8.jsr335.lambda;

/** 
 * 测试lambda表达式 
 * 
 * @author benhail 
 * 
 * http://my.oschina.net/benhaile/blog/175012
 * 
 * 函数式接口
函数式接口（functional interface 也叫功能性接口，其实是同一个东西）。简单来说，函数式接口是只包含一个方法的接口。比如Java标准库中的java.lang.Runnable和java.util.Comparator都是典型的函数式接口。java 8提供 @FunctionalInterface作为注解,这个注解是非必须的，只要接口符合函数式接口的标准（即只包含一个方法的接口），虚拟机会自动判断，但 最好在接口上使用注解@FunctionalInterface进行声明，以免团队的其他人员错误地往接口中添加新的方法。 
Java中的lambda无法单独出现，它需要一个函数式接口来盛放，lambda表达式方法体其实就是函数接口的实现，下面讲到语法会讲到 

java 8引入lambda迫切需求是因为lambda 表达式能简化集合上数据的多线程或者多核的处理，提供更快的集合处理速度 

Lambda语法
包含三个部分

一个括号内用逗号分隔的形式参数，参数是函数式接口里面方法的参数

一个箭头符号：->

方法体，可以是表达式和代码块，方法体函数式接口里面方法的实现，如果是代码块，则必须用{}来包裹起来，且需要一个return 返回值，但有个例外，若函数式接口里面方法返回值是void，则无需{}

总体看起来像这样
(parameters) -> expression 或者 (parameters) -> { statements; }
 */
public class InterfaceImplTset {

	
	    public static void runThreadUseLambda() { 
	        //Runnable是一个函数接口，只包含了有个无参数的，返回void的run方法； 
	        //所以lambda表达式左边没有参数，右边也没有return，只是单纯的打印一句话 
	        new Thread(() -> System.out.println("lambda实现的线程")).start();  
	    } 
	 
	    public static void runThreadUseInnerClass() { 
	        //这种方式就不多讲了，以前旧版本比较常见的做法 
	        new Thread(new Runnable() { 
	            @Override 
	            public void run() { 
	                System.out.println("内部类实现的线程"); 
	            } 
	        }).start(); 
	    } 
	 
	    public static void main(String[] args) { 
	    	InterfaceImplTset.runThreadUseLambda(); 
	    	InterfaceImplTset.runThreadUseInnerClass(); 
	    } 
 
	
}
