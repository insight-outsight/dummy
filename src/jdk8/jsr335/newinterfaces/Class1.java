package jdk8.jsr335.newinterfaces;

public class Class1 implements Interface1,Interface0 {

	public void defaultMethod(){
		Interface1.super.defaultMethod();
		System.out.println("Class1默认方法被调用了");
	}
	
}
