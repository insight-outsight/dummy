package jdk7.newfeatures;

import java.util.List;


/**
 * 
 * @author xu
 * @Ref http://janeky.iteye.com/blog/1047799
 * 
 *  有些参数类型，例如ArrayList<Number> 和 List<String>,是非具体化的（non-reifiable）.
 *  在编译阶段，编译器会擦除该类型信息。
 *  Heap pollution 指一个变量被指向另外一个不是相同类型的变量。例如
 *  
 *  List l = new ArrayList<Number>();  
    List<String> ls = l;       // unchecked warning  
    l.add(0, new Integer(42)); // another unchecked warning  
    String s = ls.get(0);      // ClassCastException is thrown  
      
            回到我们的主题，在jdk7中，当你定义下面的函数时

    public static <T> void addToList (List<T> listArg, T... elements) {  
      for (T x : elements) {  
       listArg.add(x);  
      }  
    }
     
            你会得到一个warning
    warning: [varargs] Possible heap pollution from parameterized vararg type 
 
            在jdk7之前，当你调用一个含有非具体化参数的可变参数方法，你必须自行保证不会发生“heap pollution”。
            这有一个问题，如果调用者对方法不熟悉，他根本无法判断。JDK7对此做了改进，在该方法被定义时久发出警告
 
           要消除警告，可以有三种方式
	1.加 annotation @SafeVarargs
	2.加 annotation @SuppressWarnings({"unchecked", "varargs"})
	3.使用编译器参数 –Xlint:varargs;
 */
public class NonReifiableFormalParameters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
    @SafeVarargs
	public static <T> void addToList (List<T> listArg, T... elements) {  
        for (T x : elements) {  
         listArg.add(x);  
        }  
      }
    
}
