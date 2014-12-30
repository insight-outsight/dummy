package jdk8.newfeatures.jsr335;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import jdk8.newfeatures.pojo.Person;
import jdk8.newfeatures.pojo.PersonFactory;

public class Lambda_Tset {

	public static void main(String[] args) {
		/**二、Lambda 表达式*/
		
		//首先看看在老版本的Java中是如何排列字符串的：

		List<String> names = Arrays.asList("peter", "anna", "mike", "tom");
		Collections.sort(names, new Comparator<String>() {
		    @Override
		    public int compare(String a, String b) {
		        return a.compareTo(b);
		    }
		});
		System.out.println("--1--"+names);

		//只需要给静态方法 Collections.sort 传入一个List对象以及一个比较器来按指定顺序排列。通常做法都是创建一个匿名的比较器对象然后将其传递给sort方法。
		//在Java 8 中你就没必要使用这种传统的匿名对象的方式了，Java 8提供了更简洁的语法，lambda表达式：

		Collections.sort(names, (String a, String b) -> {
		    return b.compareTo(a);
		});
		System.out.println("--2--"+names);
		
		//看到了吧，代码变得更段且更具有可读性，但是实际上还可以写得更短：

		Collections.sort(names, (String a, String b) -> b.compareTo(a));
		System.out.println("--3--"+names);
		
		//对于函数体只有一行代码的，你可以去掉大括号{}以及return关键字，但是你还可以写得更短点：

		Collections.sort(names, (a, b) -> b.compareTo(a));
		System.out.println("--4--"+names);

		//Java编译器可以自动推导出参数类型，所以你可以不用再写一次类型。接下来我们看看lambda表达式还能作出什么更方便的东西来：
		
		/**三、函数式接口*/

		//Lambda表达式是如何在java的类型系统中表示的呢？每一个lambda表达式都对应一个类型，通常是接口类型。而“函数式接口”是指仅仅只包含一个抽象方法的接口，
		//每一个该类型的lambda表达式都会被匹配到这个抽象方法。因为 默认方法 不算抽象方法，所以你也可以给你的函数式接口添加默认方法。我们可以将lambda表达式当
		//作任意只包含一个抽象方法的接口类型，确保你的接口一定达到这个要求，你只需要给你的接口添加 @FunctionalInterface 注解，编译器如果发现你标注了这个
		//注解的接口有多于一个抽象方法的时候会报错的。


		Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		Integer converted = converter.convert("123");
		System.out.println(converted);    // 123

		//需要注意如果@FunctionalInterface如果没有指定，上面的代码也是对的。
		//译者注 将lambda表达式映射到一个单方法的接口上，这种做法在Java 8之前就有别的语言实现，比如Rhino JavaScript解释器，如果一个函
		//数参数接收一个单方法的接口而你传递的是一个function，Rhino 解释器会自动做一个单接口的实例到function的适配器，典型的应用场景
		//有 org.w3c.dom.events.EventTarget 的addEventListener 第二个参数 EventListener。
		
		
		/**四、方法与构造函数引用*/
		//前一节中的代码还可以通过静态方法引用来表示：
		//下句等价于Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		Converter<String, Integer> converter2 = Integer::valueOf;
		Integer converted2 = converter2.convert("59123");
		System.out.println(converted2);  
		System.out.println(converted2.getClass().getPackage().getName());
		//Java 8 允许你使用 :: 关键字来传递方法或者构造函数引用，上面的代码展示了如何引用一个静态方法，我们也可以引用一个对象的方法：

		String str1 = "JavaLanguage1.8";
		Converter<String, Boolean> converterStartWith = str1::startsWith;
		boolean converted3 = converterStartWith.convert("2Java");
		System.out.println(converted3);

		//接下来看看构造函数是如何使用::关键字来引用的，首先我们定义一个包含多个构造函数的简单类Person,
		//接下来我们指定一个用来创建Person对象的对象工厂接口PersonFactory,这里我们使用构造函数引
		//用来将他们关联起来，而不是实现一个完整的工厂：
		//我们只需要使用 Person::new 来获取Person类构造函数的引用，Java编译器会自动根据PersonFactory.create方法的签名来选择合适的构造函数。
		PersonFactory<Person> personFactory = Person::new;
		Person person = personFactory.create("Peter", "Parker");
		System.out.println(person);

	}
	

}
