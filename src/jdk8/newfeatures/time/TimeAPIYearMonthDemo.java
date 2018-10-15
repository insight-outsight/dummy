package jdk8.newfeatures.time;

import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

/**
 * 
--------------------- 
作者：码农农码一生 
来源：CSDN 
原文：https://blog.csdn.net/chenhao_c_h/article/details/81110605?utm_source=copy 
版权声明：本文为博主原创文章，转载请附上博文链接！
 * @author admin
 *
 */
public class TimeAPIYearMonthDemo {
 
  public static void main(String[] args) {
    //===============================================================================
    // 1、获取当前年月
    //===============================================================================
    YearMonth yearMonth = YearMonth.now();
    System.out.println(yearMonth); // 2018-07
 
    //===============================================================================
    // 2、构造年月
    //===============================================================================
    CharSequence text = "2018-01";
    YearMonth yearMonth1 = YearMonth.parse(text);
    System.out.println(yearMonth1); // 2018-01
    CharSequence text2 = "2018年02月";
    YearMonth yearMonth2 = YearMonth.parse(text2, DateTimeFormatter.ofPattern("yyyy年MM月"));
    System.out.println(yearMonth2); // 2018-02
 
    //===============================================================================
    // 3、获取，年，月
    //===============================================================================
    int year = yearMonth.getYear();
    Month month = yearMonth.getMonth();
    int monthValue = yearMonth.getMonthValue();
    System.out.println(year + "年" + monthValue + "月" + "mouth对象-》" + month);
    // 2018年7月mouth对象-》JULY
 
    //===============================================================================
    // 4、判断大于小于，排序，判断是否闰年
    //===============================================================================
    System.out.println(yearMonth.isAfter(yearMonth1));  // true
    System.out.println(yearMonth.isBefore(yearMonth1)); // false
    System.out.println(yearMonth.isLeapYear()); // 是否闰年 false
    System.out.println(yearMonth.compareTo(yearMonth1)); // 6 （这里为什么是6 上面有详解）
 
    //===============================================================================
    // 5、年月的加减，设置年月
    //===============================================================================
    YearMonth yearMonth3 = yearMonth.plusMonths(1);
    System.out.println(yearMonth3); // 2018-08
    YearMonth yearMonth4 = yearMonth.plusYears(-1);
    System.out.println(yearMonth4); // 2017-07
    YearMonth yearMonth5 = yearMonth.withMonth(5);
    System.out.println(yearMonth5); // 2018-05
    YearMonth yearMonth6 = yearMonth.withYear(2000);
    System.out.println(yearMonth6); // 2000-07
  }
 
}
