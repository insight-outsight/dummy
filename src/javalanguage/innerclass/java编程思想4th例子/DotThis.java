package javalanguage.innerclass.java编程思想4th例子;

//: innerclasses/DotThis.java
// Qualifying access to the outer-class object.

public class DotThis {
  void f() { System.out.println("DotThis.f()"); }
  public class Inner {
    public DotThis outer() {
      return DotThis.this;
      // A plain "this" would be Inner's "this"
    }
  }
  public Inner inner() { return new Inner(); }
  public static void main(String[] args) {
    DotThis dt = new DotThis();
    DotThis.Inner dti = dt.inner();
    dti.outer().f();
    //或者采用下面方式
    Inner dti2 = dt.new Inner();
    dti2.outer().f();
  }
} /* Output:
DotThis.f()
*///:~
