package jdk8.newfeatures;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class TimeAPITset {

	public static void main(String[] args) {

		System.out.println("==============jdk 1.8以前日期API=============");
		
		System.out.println("/"+System.currentTimeMillis());
		long ts1 = 1418183985217l;
		System.out.println("/"+new java.util.Date(ts1).getTime());
		System.out.println("/"+new java.util.Date().getTime());//等价于System.currentTimeMillis()
		
		DateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss.SSS" );
		Calendar cal = Calendar.getInstance();
		System.out.println("当前时间："+dateFormat.format(cal.getTime()));
	    //cal.setTime(new java.util.Date(ts1));
	    System.out.print("年："+cal.get(Calendar.YEAR));
	    System.out.print("  月："+(cal.get(Calendar.MONTH) + 1));// 月份计算是从0作为1开始的。
	    System.out.print("  日："+cal.get(Calendar.DATE));//日，比如6月显示6，而不是06
	    System.out.print("  时："+cal.get(Calendar.HOUR));
	    System.out.print("  分："+cal.get(Calendar.MINUTE));
	    System.out.print("  秒："+cal.get(Calendar.SECOND));
	    System.out.println("  毫秒："+cal.get(Calendar.MILLISECOND));

		System.out.println("DAY_OF_MONTH:"+cal.get(Calendar.DAY_OF_MONTH));
	    System.out.println("HOUR_OF_DAY:"+cal.get(Calendar.HOUR_OF_DAY));
	   
	   String oneHoursAgoTime =  "" ;
	   cal.set(Calendar.HOUR , Calendar.HOUR -1 ) ;
//	   cal.set(Calendar.DATE , Calendar.DATE +1);
	   cal.set(Calendar. MONTH , Calendar. MONTH -2); //当前月前一月
	   oneHoursAgoTime = dateFormat.format(cal.getTime());
	   System.out.println(oneHoursAgoTime);//由于时区差别出现了问题，与期望的结果不一样
	   System.out.println("年："+cal.get(Calendar.YEAR)+"  月："+(cal.get(Calendar.MONTH) + 1));//由于时区差别出现了问题，与期望的结果不一样
	   System.out.println("===========================================");
	    
/*		九、Date API

		Java 8 在包java.time下包含了一组全新的时间日期API。新的日期API和开源的Joda-Time库差不多，但又不完全一样，下面的例子展示了这组
		新API里最重要的一些部分：

		Clock 时钟
		Clock类提供了访问当前日期和时间的方法，Clock是时区敏感的，可以用来取代 System.currentTimeMillis() 来获取当前的微秒数。
		某一个特定的时间点也可以使用Instant类来表示，Instant类也可以用来创建老的java.util.Date对象。*/

		Clock clock = Clock.systemDefaultZone();
		long millis = clock.millis();
		System.out.println(millis);
		System.out.println(System.currentTimeMillis());
		Instant instant = clock.instant();
		Date legacyDate = Date.from(instant);   // legacy java.util.Date
		System.out.println(legacyDate);
/*
		Timezones 时区
		在新API中时区使用ZoneId来表示。时区可以很方便的使用静态方法of来获取到。 时区定义了到UTS时间的时间差，
		在Instant时间点对象到本地日期对象之间转换的时候是极其重要的。*/

		System.out.println(ZoneId.getAvailableZoneIds());
		// prints all available timezone ids
		ZoneId zoneSysDefault = ZoneId.systemDefault();
		ZoneId zone1 = ZoneId.of("Europe/Berlin");
		ZoneId zone2 = ZoneId.of("Brazil/East");
		ZoneId zone3 = ZoneId.of("Asia/Shanghai");
		System.out.println(zoneSysDefault.getId()+"   "+zoneSysDefault.getRules());
		System.out.println(zone1.getRules());// ZoneRules[currentStandardOffset=+01:00]
		System.out.println(zone2.getRules());// ZoneRules[currentStandardOffset=-03:00]
		System.out.println(zone3.getId()+"   "+zone3.getRules());

/*
		LocalTime 本地时间，用于标识一个特定时区（使用LocalTime.now(ZoneId zone)设置该时区）当前的时间
		LocalTime 定义了一个没有时区信息的时间，例如 晚上10点，或者 17:30:15。下面的例子使用前面代码创建的时区创建了两个本地时间。之后比较时间并以小
		时和分钟为单位计算两个时间的时间差：*/
		System.out.println(LocalTime.now().getHour());
		LocalTime now1 = LocalTime.now(zone1);
		LocalTime now2 = LocalTime.now(zone2);
		System.out.println(now1.getHour());
		System.out.println(now2.getHour());
		System.out.println(now1.isBefore(now2));  // false
		long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
		long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);
		System.out.println(hoursBetween);       // -3
		System.out.println(minutesBetween);     // -180
/*
		LocalTime 提供了多种工厂方法来简化对象的创建，包括解析时间字符串。
		复制代码 代码如下:

		LocalTime late = LocalTime.of(23, 59, 59);
		System.out.println(late);       // 23:59:59
		DateTimeFormatter germanFormatter =
		    DateTimeFormatter
		        .ofLocalizedTime(FormatStyle.SHORT)
		        .withLocale(Locale.GERMAN);
		LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
		System.out.println(leetTime);   // 13:37

		LocalDate 本地日期
		LocalDate 表示了一个确切的日期，比如 2014-03-11。该对象值是不可变的，用起来和LocalTime基本一致。下面的例子展示了如何给Date对象加减天/月/年。另外要注意的是这些对象是不可变的，操作返回的总是一个新实例。
		复制代码 代码如下:

		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
		LocalDate yesterday = tomorrow.minusDays(2);
		LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
		DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();

		System.out.println(dayOfWeek);    // FRIDAY
		从字符串解析一个LocalDate类型和解析LocalTime一样简单：
		复制代码 代码如下:

		DateTimeFormatter germanFormatter =
		    DateTimeFormatter
		        .ofLocalizedDate(FormatStyle.MEDIUM)
		        .withLocale(Locale.GERMAN);
		LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter);
		System.out.println(xmas);   // 2014-12-24


		LocalDateTime 本地日期时间
		LocalDateTime 同时表示了时间和日期，相当于前两节内容合并到一个对象上了。LocalDateTime和LocalTime还有LocalDate一样，都是不可变的。LocalDateTime提供了一些能访问具体字段的方法。
		复制代码 代码如下:

		LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);
		DayOfWeek dayOfWeek = sylvester.getDayOfWeek();
		System.out.println(dayOfWeek);      // WEDNESDAY
		Month month = sylvester.getMonth();
		System.out.println(month);          // DECEMBER
		long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
		System.out.println(minuteOfDay);    // 1439

		只要附加上时区信息，就可以将其转换为一个时间点Instant对象，Instant时间点对象可以很容易的转换为老式的java.util.Date。
		复制代码 代码如下:

		Instant instant = sylvester
		        .atZone(ZoneId.systemDefault())
		        .toInstant();
		Date legacyDate = Date.from(instant);
		System.out.println(legacyDate);     // Wed Dec 31 23:59:59 CET 2014

		格式化LocalDateTime和格式化时间和日期一样的，除了使用预定义好的格式外，我们也可以自己定义格式：
		复制代码 代码如下:

		DateTimeFormatter formatter =
		    DateTimeFormatter
		        .ofPattern("MMM dd, yyyy - HH:mm");
		LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014 - 07:13", formatter);
		String string = formatter.format(parsed);
		System.out.println(string);     // Nov 03, 2014 - 07:13

		和java.text.NumberFormat不一样的是新版的DateTimeFormatter是不可变的，所以它是线程安全的。
		关于时间日期格式的详细信息：http://download.java.net/jdk8/docs/api/java/time/format/DateTimeFormatter.html
		十、Annotation 注解

		在Java 8中支持多重注解了，先看个例子来理解一下是什么意思。
		首先定义一个包装类Hints注解用来放置一组具体的Hint注解：
		复制代码 代码如下:

		@interface Hints {
		    Hint[] value();
		}
		@Repeatable(Hints.class)
		@interface Hint {
		    String value();
		}

		Java 8允许我们把同一个类型的注解使用多次，只需要给该注解标注一下@Repeatable即可。
		例 1: 使用包装类当容器来存多个注解（老方法）
		复制代码 代码如下:

		@Hints({@Hint("hint1"), @Hint("hint2")})
		class Person {}

		例 2：使用多重注解（新方法）
		复制代码 代码如下:

		@Hint("hint1")
		@Hint("hint2")
		class Person {}

		第二个例子里java编译器会隐性的帮你定义好@Hints注解，了解这一点有助于你用反射来获取这些信息：
		复制代码 代码如下:

		Hint hint = Person.class.getAnnotation(Hint.class);
		System.out.println(hint);                   // null
		Hints hints1 = Person.class.getAnnotation(Hints.class);
		System.out.println(hints1.value().length);  // 2
		Hint[] hints2 = Person.class.getAnnotationsByType(Hint.class);
		System.out.println(hints2.length);          // 2

		即便我们没有在Person类上定义@Hints注解，我们还是可以通过 getAnnotation(Hints.class) 来获取 @Hints注解，更加方便的方法是使用 getAnnotationsByType 可以直接获取到所有的@Hint注解。
		另外Java 8的注解还增加到两种新的target上了：
		复制代码 代码如下:

		@Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
		@interface MyAnnotation {}

		关于Java 8的新特性就写到这了，肯定还有更多的特性等待发掘。JDK 1.8里还有很多很有用的东西，比如Arrays.parallelSort, StampedLock和CompletableFuture等等。*/
		
	}


	
}
