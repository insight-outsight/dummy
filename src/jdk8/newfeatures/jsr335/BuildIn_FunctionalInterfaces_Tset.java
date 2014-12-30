package jdk8.newfeatures.jsr335;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import jdk8.newfeatures.pojo.Person;

/**
 * JDK 1.8 API包含了很多内建的函数式接口(BuildIn Functional Interfaces)，在老Java中常用到的比如Comparator或者Runnable接口，这些接口都增加了@FunctionalInterface注解
 * 以便能用在lambda上。
 * Java 8 API同样还提供了很多全新的函数式接口来让工作更加方便，有一些接口是来自Google Guava库里的，即便你对这些很熟悉了，还是有必要看看这些是如
 * 何扩展到lambda上使用的。
 * 
 * @author XUZHENGCHAO
 *
 */
public class BuildIn_FunctionalInterfaces_Tset {

	public static void main(String[] args) {

/*		Predicate接口
		Predicate 接口只有一个参数，返回boolean类型。该接口包含多种默认方法来将Predicate组合成其他复杂的逻辑（比如：与，或，非）：*/

		String PredicateTestOutputNotation = "【PredicateTest】";
		
		Predicate<String> predicate = (s) -> s.length() > 0;
		System.out.println(PredicateTestOutputNotation+"-->"+predicate.test("foo"));              // true
		System.out.println(PredicateTestOutputNotation+"--->"+predicate.negate().test("foo"));     // false  
		Predicate<Boolean> nonNull = Objects::nonNull;
		Boolean b1 = null;
		System.out.println(PredicateTestOutputNotation+"------>"+nonNull.test(b1));//false
		Predicate<Boolean> isNull = Objects::isNull;
		System.out.println(PredicateTestOutputNotation+"--------->"+isNull.test(b1));//true
		
		String s1 = "jjj";
		Predicate<String> isEmpty = String::isEmpty;
		System.out.println(PredicateTestOutputNotation+"<---------"+isEmpty.test(s1));//false
		Predicate<String> isNotEmpty = isEmpty.negate();
		System.out.println(PredicateTestOutputNotation+"<------------"+isNotEmpty.test(s1));//true
		
		//a little complex example
		Predicate<Integer> greatThanFive = (s)->s>5;
		Predicate<Integer> lessThanTen= (s)->s<10;
		System.out.println(PredicateTestOutputNotation+greatThanFive.and(lessThanTen).test(7));
		System.out.println(PredicateTestOutputNotation+lessThanTen.and(greatThanFive).test(7));
		System.out.println(PredicateTestOutputNotation+lessThanTen.and(greatThanFive).test(4));
		
/*		Function 接口
		Function 接口有一个参数并且返回一个结果，并附带了一些可以和其他函数组合的默认方法（compose, andThen）：*/

		String FunctionTestOutputNotation = "【FunctionTest】";

		Function<String, Integer> toInteger = Integer::valueOf;
		Function<String, String> backToString = toInteger.andThen(String::valueOf);
		System.out.println(FunctionTestOutputNotation+backToString.apply("123"));     // "123"
		
		
/*		Supplier 接口
		Supplier 接口返回一个任意范型的值，和Function接口不同的是该接口没有任何参数*/

		String SupplierTestOutputNotation = "【SupplierTest】";
		
		Supplier<Person> personSupplier = Person::new;
		Person person1 = personSupplier.get();   // new Person
		System.out.println(SupplierTestOutputNotation+person1);
		Person person2 = personSupplier.get();   // new Person
		System.out.println(SupplierTestOutputNotation+person2);
		System.out.println(SupplierTestOutputNotation+(person1==person2));
		
/*		Consumer 接口
		Consumer 接口表示执行在单个参数上的操作。*/

		String ConsumerTestOutputNotation = "【ConsumerTest】";
		
		Consumer<Person> greeter = (p) -> System.out.println(ConsumerTestOutputNotation+"Hello, " + p.getFirstName());
		greeter.accept(new Person("Luke", "Skywalker"));

		Consumer<Person> greeter2 = (p) -> System.out.println(ConsumerTestOutputNotation+"World, " + p.getFirstName());
		greeter.andThen(greeter2).accept(new Person("Luke", "Skywalker"));
		
/*		Comparator 接口
		Comparator 是老Java中的经典接口， Java 8在此之上添加了多种默认方法：*/

		String ComparatorTestOutputNotation = "【ComparatorTest】";
		
		Comparator<Person> comparator = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());
		Person p1 = new Person("John", "Doe");
		Person p2 = new Person("Alice", "Wonderland");
		System.out.println(ComparatorTestOutputNotation+comparator.compare(p1, p2));             // > 0
		System.out.println(ComparatorTestOutputNotation+comparator.reversed().compare(p1, p2));  // < 0
		
/*		Optional 接口
		Optional 不是函数式接口，这是个用来防止NullPointerException异常的辅助类型，这是下一节中将要用到的重要概念，现在先简单的看看这个接口能干什么：
		Optional 被定义为一个简单的容器，其值可能是null或者不是null。在Java 8之前一般某个函数应该返回非空对象但是偶尔却可能返回了null，
		而在Java 8中，不推荐你返回null而是返回Optional。*/

		String OptionalTestOutputNotation = "【OptionalTest】";
		
		Optional<String> optional = Optional.of("bam");
		System.out.println(OptionalTestOutputNotation+optional.isPresent());           // true
		System.out.println(OptionalTestOutputNotation+optional.get());                 // "bam"
		System.out.println(OptionalTestOutputNotation+optional.orElse("fallback"));    // "bam"
		optional.ifPresent((s) -> System.out.println(OptionalTestOutputNotation+s.charAt(0)));     // "b"
		
	}
	

	public static void printResult(String notation,String content){
		
	}
	
}
