package jdk8.newfeatures.pojo;

public interface InterfaceExtend extends InterfaceBase{
	
	default void defaultMethod(){
		System.out.println("Interface1默认方法被调用了");
	}
	
	public static void staticMethod(){
		System.out.println("静态方法被调用了");
	}
	
}
