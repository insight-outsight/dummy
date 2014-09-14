package jdk8.jsr335;

import jdk8.jsr335.newinterfaces.Class1;
import jdk8.jsr335.newinterfaces.Interface1;

public class Tset {

	public static void main(String[] args) {
		new Class1().defaultMethod();
		Interface1.staticMethod();
	}

}
