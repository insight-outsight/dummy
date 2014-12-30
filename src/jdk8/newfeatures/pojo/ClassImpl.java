package jdk8.newfeatures.pojo;

public class ClassImpl implements InterfaceExtend,InterfaceBase {

	public void defaultMethod(){
		InterfaceExtend.super.defaultMethod();
		System.out.println("Class1默认方法被调用了");
	}
	
}
