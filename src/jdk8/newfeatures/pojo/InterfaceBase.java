package jdk8.newfeatures.pojo;

public interface InterfaceBase {

	default void defaultMethod(){
		System.out.println("Interface0默认方法被调用了");
	}
	
}
