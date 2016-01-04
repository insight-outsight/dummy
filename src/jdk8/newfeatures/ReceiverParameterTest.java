package jdk8.newfeatures;

public class ReceiverParameterTest {
		int i = 5;
		ReceiverParameterTest(/* ?? ?? */int i) {this.i = i;}
		// No receiver parameter is permitted in the constructor of
		// a top level class, as there is no conceivable type or name.

		void m(ReceiverParameterTest this) {System.out.println(i+"---"+this.getClass().getName());}
		// OK: receiver parameter in an instance method

		public static void main(String[] args) {
			new ReceiverParameterTest(3).m();
		}
		
		class A {
		A(ReceiverParameterTest ReceiverParameterTest.this) {}
		// OK: the receiver parameter represents the instance
		// of ReceiverParameterTest which immediately encloses the instance
		// of A being constructed.
		void m(A this) {}
		// OK: the receiver parameter represents the instance
		// of A for which A.m() is invoked.
		class B {
		B(ReceiverParameterTest.A A.this) {}
		// OK: the receiver parameter represents the instance
		// of A which immediately encloses the instance of B
		// being constructed.
		void m(ReceiverParameterTest.A.B this) {}
		// OK: the receiver parameter represents the instance
		// of B for which B.m() is invoked.
		}
		}
	
}
