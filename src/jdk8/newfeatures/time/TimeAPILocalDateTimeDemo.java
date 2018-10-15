package jdk8.newfeatures.time;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;

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
public class TimeAPILocalDateTimeDemo {
 
  public static void main(String[] args) {
    //===============================================================================
    // 1、获取当前日期时间
    //===============================================================================
    LocalDateTime localDateTime = LocalDateTime.now();
    System.out.println(localDateTime); // 2018-07-26T14:47:44.144
 
    //===============================================================================
    // 2、构造日期时间
    //===============================================================================
    CharSequence text = "2007-12-03T10:15:30";
    // 从一个文本字符串 获得 LocalDateTime实例
    LocalDateTime dateTime1 = LocalDateTime.parse(text);
    System.out.println(dateTime1); // 2007-12-03T10:15:30
 
    //===============================================================================
    // 3、获取，年，月，日，时等等
    //===============================================================================
    int dayOfMonth = localDateTime.getDayOfMonth();
    DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
    int dayOfYear = localDateTime.getDayOfYear();
    int hour = localDateTime.getHour();
    Month month = localDateTime.getMonth();
    int year = localDateTime.getYear();
    System.out.println(year + "年" + month.toString() + "月" + dayOfMonth + "日" +
        hour + "时" + "|||" + dayOfWeek + "|||" + dayOfYear);
    // 2018年JULY月31日9时|||TUESDAY|||212
  }
}
