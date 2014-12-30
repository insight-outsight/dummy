package jdk8.newfeatures;

import jdk8.newfeatures.pojo.ClassImpl;
import jdk8.newfeatures.pojo.InterfaceExtend;

public class DefaultMethodTset {

	public static void main(String[] args) {
		new ClassImpl().defaultMethod();
		InterfaceExtend.staticMethod();
	}

}
