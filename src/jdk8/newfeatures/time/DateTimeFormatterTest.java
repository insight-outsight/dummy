package jdk8.newfeatures.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterTest {
    
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String nowStr = now.format(formatter);
        System.out.println(nowStr);
        System.out.println("=========");
        System.out.println(formatter.format(now));
        
        String dateStr= "2019-08-01 14:28:58";
        LocalDateTime date= LocalDateTime.parse(dateStr, formatter);
        System.out.println("parsed time str "+date.format(formatter));

    }

}

