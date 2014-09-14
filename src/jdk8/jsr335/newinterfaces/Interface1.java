package jdk8.jsr335.newinterfaces;

public interface Interface1 extends Interface0{
	
	default void defaultMethod(){
		System.out.println("Interface1默认方法被调用了");
	}
	
	public static void staticMethod(){
		System.out.println("静态方法被调用了");
	}
	
}
