package jdk8.newfeatures.jsr335;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class StreamTset {
	
	
	public static void main(String[] args) {
		 
		 
	/*	 Stream 接口
		 java.util.Stream 表示能应用在一组元素上一次执行的操作序列。Stream 操作分为中间操作或者最终操作两种，最终操作返回一特定类型
		 的计算结果，而中间操作返回Stream本身，这样你就可以将多个操作依次串起来。Stream 的创建需要指定一个数据源，
		 比如 java.util.Collection的子类，List或者Set， Map不支持。
		 Stream的操作可以串行执行或者并行执行。首先看看Stream是怎么用，首先创建实例代码的用到的数据List：*/


		 List<String> stringCollection = new ArrayList<>(3);
		 stringCollection.add("ddd2");
		 stringCollection.add("aaa2");
		 stringCollection.add("bbb1");
		 stringCollection.add("aaa1");
		 stringCollection.add("bbb3");
		 stringCollection.add("ccc");
		 stringCollection.add("bbb2");
		 stringCollection.add("ddd1");

	/*	 Java 8扩展了集合类，可以通过 Collection.stream() 或者 Collection.parallelStream() 来创建一个Stream。
		 下面几节将详细解释常用的Stream操作：*/
		 
	/*	 Filter 过滤
		 过滤通过一个predicate接口来过滤并只保留符合条件的元素，该操作属于中间操作，所以我们可以在过滤后的结果来应用其他Stream操作（比如forEach）。
		 forEach需要一个函数来对过滤后的元素依次执行。forEach是一个最终操作，所以我们不能在forEach之后来执行其他Stream操作。*/


		 stringCollection
		     .stream()
		     .filter((s) -> s.startsWith("a"))
		     .forEach(System.out::println);
		 // "aaa2", "aaa1"


	/*	 Sort 排序
		 排序是一个中间操作，返回的是排序好后的Stream。如果你不指定一个自定义的Comparator则会使用默认排序。*/

		 stringCollection
		     .stream()
		     .sorted()
		     .filter((s) -> s.startsWith("a"))
		     .forEach(System.out::println);
		 // "aaa1", "aaa2"

	/*	 需要注意的是，排序只创建了一个排列好后的Stream，而不会影响原有的数据源，排序之后原数据stringCollection是不会被修改的：*/
		 System.out.println(stringCollection); // ddd2, aaa2, bbb1, aaa1, bbb3, ccc, bbb2, ddd1


	/*	 Map 映射

		 中间操作map会将元素根据指定的Function接口来依次将元素转成另外的对象，下面的示例展示了将字符串转换为大写字符串。
		 你也可以通过map来讲对象转换成其他类型，map返回的Stream类型是根据你map传递进去的函数的返回值决定的。*/


		 stringCollection
		     .stream()
		     .map(String::toUpperCase)
		     .sorted((a, b) -> b.compareTo(a))
		     .forEach(System.out::println);
		 // "DDD2", "DDD1", "CCC", "BBB3", "BBB2", "AAA2", "AAA1"


	/*	 Match 匹配
		 Stream提供了多种匹配操作，允许检测指定的Predicate是否匹配整个Stream。所有的匹配操作都是最终操作，并返回一个boolean类型的值。*/


		 boolean anyStartsWithA = 
		     stringCollection
		         .stream()
		         .anyMatch((s) -> s.startsWith("a"));
		 System.out.println(anyStartsWithA);      // true
		 boolean allStartsWithA = 
		     stringCollection
		         .stream()
		         .allMatch((s) -> s.startsWith("a"));
		 System.out.println(allStartsWithA);      // false
		 boolean noneStartsWithZ = 
		     stringCollection
		         .stream()
		         .noneMatch((s) -> s.startsWith("z"));
		 System.out.println(noneStartsWithZ);      // true
		 
	/*	 Count 计数
		 计数是一个最终操作，返回Stream中元素的个数，返回值类型是long。*/


		 long startsWithB = 
		     stringCollection
		         .stream()
		         .filter((s) -> s.startsWith("b"))
		         .count();
		 System.out.println(startsWithB);    // 3


	/*	 Reduce 规约
		 这是一个最终操作，允许通过指定的函数来讲stream中的多个元素规约为一个元素，规越后的结果是通过Optional接口表示的：*/


		 Optional<String> reduced =
		     stringCollection
		         .stream()
		         .sorted()
		         .reduce((s1, s2) -> s1 + "#" + s2);
		 reduced.ifPresent(System.out::println);
		 // "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"


	/*	 并行Streams
		 前面提到过Stream有串行和并行两种，串行Stream上的操作是在一个线程中依次完成，而并行Stream则是在多个线程上同时执行。
		 下面的例子展示了是如何通过并行Stream来提升性能：
		 首先我们创建一个没有重复元素的大表：*/

		 int max = 1000000;
		 List<String> values = new ArrayList<>(max);
		 for (int i = 0; i < max; i++) {
		     UUID uuid = UUID.randomUUID();
		     values.add(uuid.toString());
		 }

	/*	 然后我们计算一下排序这个Stream要耗时多久，*/

		 long t0 = System.nanoTime();
		 long count = values.stream().sorted().count();
		 System.out.println(count);
		 long t1 = System.nanoTime();
		 long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		 System.out.println(String.format("sequential sort took: %d ms", millis));
		 // 串行耗时: 899 ms
		 
		 //并行排序：

		 long t10 = System.nanoTime();
		 long count10 = values.parallelStream().sorted().count();
		 System.out.println(count);
		 long t11 = System.nanoTime();
		 long millis1 = TimeUnit.NANOSECONDS.toMillis(t11 - t10);
		 System.out.println(String.format("parallel sort took: %d ms", millis1));
		 // 并行排序耗时: 472 ms
		 
		 //上面两个代码几乎是一样的，但是并行版的快了50%之多，唯一需要做的改动就是将stream()改为parallelStream()。

	/*	 Map
		 前面提到过，Map类型不支持stream，不过Map提供了一些新的有用的方法来处理一些日常任务。*/

		 Map<Integer, String> map = new HashMap<>();
		 for (int i = 0; i < 10; i++) {
		     map.putIfAbsent(i, "val" + i);
		 }
		 map.forEach((id, val) -> System.out.println(val));
		 
	/*	 以上代码很容易理解， putIfAbsent 不需要我们做额外的存在性检查，而forEach则接收一个Consumer接口来对map里的每一个键值对进行操作。
		 下面的例子展示了map上的其他有用的函数：*/

		 map.computeIfPresent(3, (num, val) -> val + num);
		 map.get(3);             // val33
		 map.computeIfPresent(9, (num, val) -> null);
		 map.containsKey(9);     // false
		 map.computeIfAbsent(23, num -> "val" + num);
		 map.containsKey(23);    // true
		 map.computeIfAbsent(3, num -> "bam");
		 map.get(3);             // val33

	/*	 接下来展示如何在Map里删除一个键值全都匹配的项：*/

		 map.remove(3, "val3");
		 map.get(3);             // val33
		 map.remove(3, "val33");
		 map.get(3);             // null

	/*	 另外一个有用的方法：*/

		 map.getOrDefault(42, "not found");  // not found

	/*	 对Map的元素做合并也变得很容易了：*/

		 map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
		 map.get(9);             // val9
		 map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
		 map.get(9);             // val9concat

		 //Merge做的事情是如果键名不存在则插入，否则则对原键对应的值做合并操作并重新插入到map中。
	}


}
