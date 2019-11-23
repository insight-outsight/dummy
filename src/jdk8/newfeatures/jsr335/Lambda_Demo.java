package jdk8.newfeatures.jsr335;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import jdk8.newfeatures.pojo.Person;

public class Lambda_Demo {

    public static void main(String[] args) {
        System.out.println("=========================0=======================");

        List<String> alpha = Arrays.asList("a", "b", "c", "d");
//        List<String> collect = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
        List<String> collect = alpha.stream().map((String n) -> {n.toUpperCase();n+="-";return n;}).collect(Collectors.toList());
        System.out.println(collect); //[A, B, C, D]
        List<Integer> num = Arrays.asList(1,2,3,4,5);
        List<Integer> collect1 = num.stream().map(n -> n * 2).collect(Collectors.toList());
        System.out.println(collect1); //[2, 4, 6, 8, 10]
        
        List<Person> staff = Arrays.asList(
                new Person("tom", "cat"),
                new Person("chan", "jack"),
                new Person("wan", "er")
        );
        List<String> collectPersons = staff.stream().map(x -> x.getFirstName()).collect(Collectors.toList());
        System.out.println(collectPersons); 
        
        List<Person> result = staff.stream().map(x -> {
            Person obj = new Person();
            obj.setFirstName(x.getFirstName());
            if ("tom".equals(x.getFirstName())) {
                obj.setFirstName("x");
            }
            obj.setLastName(x.getLastName());
            return obj;
        }).collect(Collectors.toList());

        System.out.println(result);
        
        System.out.println("=========================1=======================");

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        // 直接打印
        list.forEach(i -> System.out.println("print-"+i));
//        list.forEach(System.out::println);
        list.forEach(i -> {
            System.out.println("print-"+i);
            System.out.println("tnirp-"+i);});

        System.out.println("=========================2=======================");

        new Thread( () -> {System.out.println("In Java8!");System.out.println("Lambda");} ).start();
        
        System.out.println("=========================3=======================");
        testPredicateFilter();
        System.out.println("=========================4=======================");
        testFilterToList();
        System.out.println("=========================5=======================");
        testMapWithOP();
        System.out.println("=========================6=======================");
        testMapToInt();
        System.out.println("=========================7=======================");
        testMap();
        System.out.println("=========================8=======================");
        testMapDistinct();
        System.out.println("=========================9=======================");
        testReduce();
        System.out.println("=========================10=======================");
        testPredicateLogicOP();
    }

    public static void testPredicateFilter() {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("-------------Filter Languages which starts with J :");
        filter(languages, (str) -> ((String) str).startsWith("J"));

        System.out.println("-------------Filter Languages which ends with a ");
        filter(languages, (str) -> ((String) str).endsWith("a"));

        System.out.println("-------------Filter Print all languages :");
        filter(languages, (str) -> true);

        System.out.println("-------------Filter Print no language : ");
        filter(languages, (str) -> false);

        System.out.println("-------------Filter Print language whose length greater than 4:");
        filter(languages, (str) -> ((String) str).length() > 4);

    }

    public static void filter(List<String> names, Predicate<String> condition) {
        for (String name : names) {
            if (condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }
    

    public static void testFilterToList() {
        List<String> strList = Arrays.asList("abc", "eqwr", "bcd", "qb" , "ehdc", "jk");
        List<String> filtered = strList.stream().filter(x -> x.length()> 2).collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);
    }
    
    public static void testMapWithOP() {
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", 
                "Italy", "U.K.","Canada");
        String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(G7Countries);
    }
    
    public static void testMapToInt() {
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x)
                                                    .summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());
    }

    public static void testMap() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        
        System.out.println("-------------1");
        list.stream().map((i) -> i * 3).forEach(System.out::println);
        
        System.out.println("-------------2");
        list.forEach(System.out::println);
        
        System.out.println("-------------3");
        list.forEach(i -> {i = i * 3;System.out.println("print-"+i);} );
        
    }
    
    public static void testMapDistinct() {
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map( i -> i*i).distinct()
                                                 .collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);
    }
    
    public static void testReduce() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Integer integer = list.stream().map((i) -> i = i * 3)
            .reduce((sum, count) -> sum += count).get();
        
        System.out.println(integer);
    }
    
    
    public static void testPredicateLogicOP() {
        Predicate<String> startWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLength = (n) -> n.length() == 4;
        
        Predicate<String> startWithP = (n) -> n.startsWith("P");

        
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Python", "Haskell", "Lisp", "Perl");
        System.out.println("-------------Predicate and test result:");
        languages.stream().filter(startWithJ.and(fourLength)).forEach(System.out::println);
        System.out.println("-------------Predicate or test result:");
        languages.stream().filter(startWithJ.or(fourLength)).forEach(System.out::println);
        System.out.println("-------------Predicate not test result:");
        languages.stream().filter(startWithP.negate()).forEach(System.out::println);
    }
    
    
}
