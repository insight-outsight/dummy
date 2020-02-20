package jdk8.newfeatures.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class LocalDateTimeAndDateConvertTest {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        Date date = localDateTime2Date(now);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(date.toLocaleString());
        System.out.println(date.getTime());
        System.out.println("---------------------");

    }

    public static LocalDateTime date2LocalDateTime(Date date) {
        Instant instant = date.toInstant();// An instantaneous point on the time-line.(时间线上的一个瞬时点。)
        ZoneId zoneId = ZoneId.systemDefault();// A time-zone ID, such as {@code Europe/Paris}.(时区)
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        return localDateTime;
    }

    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);// Combines this date-time with a time-zone to create a
                                                         // ZonedDateTime.
        Date date = Date.from(zdt.toInstant());
        return date;
    }

}
