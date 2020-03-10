package jdk8.newfeatures.time;
 

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Locale;
import java.util.TimeZone;


public class ZoneAndTimestampTest {
	
    public static void main(String[] args) {
    	
        long dateS = System.currentTimeMillis();
        System.out.println(dateS);
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Default:"+outputFormat.format(dateS));
        
        TimeZone timeZoneNY = TimeZone.getTimeZone("America/New_York");
        SimpleDateFormat outputFormatUS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        outputFormatUS.setTimeZone(timeZoneNY);
        System.out.println("NY:"+outputFormatUS.format(dateS));

        TimeZone timeZoneSH = TimeZone.getTimeZone("Asia/Shanghai");
        SimpleDateFormat outputFormatCHINA = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        outputFormatCHINA.setTimeZone(timeZoneSH);
        System.out.println("SH:"+outputFormatCHINA.format(dateS));
        
    
        //获取时区gmt+8 在程序运行时间（例如2020-03-10 11:57:38）的UTC秒数
        Long second8 = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        //获取时区 gmt+8 在程序运行时间（例如2020-03-10 11:57:38）的UTC毫秒数
        Long milliSecond8 = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        
        //获取时区 gmt+0 在程序运行时间（例如2020-03-10 11:57:38）的UTC秒数
        Long second0 = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+0"));
        //获取时区 gmt+0 在程序运行时间（例如2020-03-10 11:57:38）的UTC毫秒数
        Long milliSecond0 = LocalDateTime.now().toInstant(ZoneOffset.of("+0")).toEpochMilli();
        
        System.out.println("+8 second:      " + second8);
        System.out.println("+8 milliSecond: " + milliSecond8);
        
        System.out.println("+0 seconds:     " + second0);
        System.out.println("+0 milliSeconds:" + milliSecond0);

    }
    
}
