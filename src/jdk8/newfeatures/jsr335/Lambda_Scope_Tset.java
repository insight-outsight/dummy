package jdk8.newfeatures.jsr335;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/** 五、Lambda 作用域
 *  在lambda表达式中访问外层作用域和老版本的匿名对象中的方式很相似。你可以直接访问标记了final的外层局部变量，或者实例的字段以及静态变量。
 * @author XUZHENGCHAO
 *
 */
public class Lambda_Scope_Tset {

	public static void main(String[] args) {
	
		
/*		六、访问局部变量
		我们可以直接在lambda表达式中访问外层的局部变量：*/

		final int num = 1;
		Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + num);
		System.out.println("--111--"+stringConverter.convert(2));     // 3


		/*但是和匿名对象不同的是，这里的变量num可以不用声明为final，该代码同样正确：*/

		int num2 = 1;
		Converter<Integer, String> stringConverter2 = (from2) -> String.valueOf(from2 + num2);
		System.out.println("--222--"+stringConverter2.convert(2));     // 3

		/*不过这里的num必须不可被后面的代码修改（即隐性的具有final的语义），例如下面的就无法编译：
		 * 
		int num3 = 1;
		Converter<Integer, String> stringConverter3 =
		        (from) -> String.valueOf(from + num3);
		num3 = 3;

		在lambda表达式中试图修改num同样是不允许的。*/

		/*七、访问对象字段与静态变量
		和本地变量不同的是，lambda内部对于实例的字段以及静态变量是即可读又可写。该行为和匿名对象是一致的：
		
		class Lambda4 {
    		static int outerStaticNum;
		    int outerNum;
		    void testScopes() {
		        Converter<Integer, String> stringConverter1 = (from) -> {
		            outerNum = 23;
		            return String.valueOf(from);
		        };
		        Converter<Integer, String> stringConverter2 = (from) -> {
		            outerStaticNum = 72;
		            return String.valueOf(from);
		        };
		    }
		}
		
		*/


		/*八、访问接口的默认方法

			还记得第一节中的formula例子么，
			interface Formula {
			    double calculate(int a);
			    default double sqrt(int a) {
			        return Math.sqrt(a);
			    }
			}
			接口Formula定义了一个默认方法sqrt可以直接被formula的实例包括匿名对象访问到，但是在lambda表达式中这个是不行的。
				Lambda表达式中是无法访问到默认方法的，以下代码将无法编译：
				Formula formula = (a) -> sqrt( a * 100);
		*/


				
				
				
				   
		

	}




}


