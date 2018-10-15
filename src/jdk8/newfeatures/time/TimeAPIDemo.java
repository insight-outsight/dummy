package jdk8.newfeatures.time;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * 
 * 总结
1、构造对应时间对象，使用 .now()  .parse() ;
2、获取相关时间单位，使用 .get()  .lengthOf..() ;
3、判断、比较，使用 .is...()    .compareTo() ;
4、日期加减，使用 .plus() ; 
5、其他计算，使用 .with()    .with(TemporalAdjusters.......()) ；

 * --------------------- 
作者：码农农码一生 
来源：CSDN 
原文：https://blog.csdn.net/chenhao_c_h/article/details/81110605?utm_source=copy 
版权声明：本文为博主原创文章，转载请附上博文链接！
 * @author admin
 *
 */
public class TimeAPIDemo {
 
  public static void main(String args[]) {
    // 输入 20180101
    CharSequence str = "20040201";
    // BASIC_ISO_DATE -》ISO日期格式化，格式或解析无偏移的日期，如“20111203”。
    LocalDate localDate = LocalDate.parse(str, DateTimeFormatter.BASIC_ISO_DATE);
    System.out.println("当前日期是："+localDate);
    LocalDate localDate2 = LocalDate.parse("20040130", DateTimeFormatter.BASIC_ISO_DATE);
    System.out.println("日期差是："+localDate.isBefore(localDate2));
    System.out.println("日期差是："+localDate.isAfter(localDate2));
    System.out.println("是否是后一天："+localDate.plusDays(-1).equals(localDate2));

    
    //===============================================================================
    // 1、 这个月月末
    //===============================================================================
    System.out.println("本月月末是：" + localDate.with(TemporalAdjusters.lastDayOfMonth()));
    // 本月月末是：2004-02-29
 
    System.out.println("当前日期是："+localDate);
    
    //===============================================================================
    // 2、 下个月月初
    //===============================================================================
    System.out.println("下月月初是：" + localDate.with(TemporalAdjusters.firstDayOfNextMonth()));
    //下月月初是：2004-03-01
 
    //===============================================================================
    // 3、 下个月月末
    //===============================================================================
    System.out.println("下月月末是：" + localDate.with(TemporalAdjusters.firstDayOfNextMonth())
        .with(TemporalAdjusters.lastDayOfMonth()));
    // 下月月末是：2004-03-31
 
    //===============================================================================
    // 4、 给年月，计算当月天数
    //===============================================================================
    CharSequence str2 = "200102";
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMM");
    YearMonth ym = YearMonth.parse(str2, dateTimeFormatter);
    System.out.println(ym.lengthOfMonth()); // 28
 
    //===============================================================================
    // 5、 日期加减天数
    //===============================================================================
    System.out.println(localDate.plusDays(-1)); // 2004-01-31
 
    //===============================================================================
    // 6、 日期加减月份
    //===============================================================================
    System.out.println(localDate.plusMonths(-1)); // 2004-01-01
    System.out.println(localDate.plusMonths(1)); // 2004-03-01
 
    //===============================================================================
    //  7、 传参月份，日子，输出修改后的
    //===============================================================================
    try {
      System.out.println(localDate.withMonth(2).withDayOfMonth(2));
      // 2004-02-02
    } catch (DateTimeException exception) {
      System.out.println("输入日期异常！");
    }
    System.out.println(localDate.withDayOfMonth(1));
    // 2004-02-01
 
    //===============================================================================
    //  8、 小于15日，输出该月15日，否则输出下月1日
    //===============================================================================
    System.out.println("--------------------");
    if (localDate.getDayOfMonth() < 15) {
      System.out.println(localDate.withDayOfMonth(15));
    } else {
      System.out.println(localDate.with(TemporalAdjusters.firstDayOfNextMonth()));
    }
    // 2004-02-15
 
  }
 
}

