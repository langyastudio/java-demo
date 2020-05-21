package date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * New Date API
 */
public class DateTimeT {
    public static void main(String[] args) {
        //--------------------------------------------------------------------------------------------------------------
        // LocalDateTime - 本地日期和时间
        //--------------------------------------------------------------------------------------------------------------
        //now
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate     localDate     = localDateTime.toLocalDate();
        LocalTime     localTime     = localDateTime.toLocalTime();
        System.out.println(localDateTime);

        //set
        LocalDate     ld  = LocalDate.of(2019, 11, 30);
        LocalTime     lt  = LocalTime.of(9, 11, 59);
        LocalDateTime ldt = LocalDateTime.of(ld, lt);
        //or
        LocalDateTime ldt1 = LocalDateTime.parse("2019-11-19T15:16:17");
        System.out.println(ldt1);

        //运算 - plusxx minusxx
        ldt1 = ldt1.plusDays(10).minusHours(3);
        System.out.println(ldt1);

        //before after
        System.out.println(ldt1.isBefore(LocalDateTime.now()));

        //modify
        System.out.println(ldt1.withYear(2018));

        //本月第一天0:00时刻:
        LocalDateTime ldt2 = LocalDate.now().withDayOfMonth(1).atStartOfDay();
        System.out.println(ldt2);

        //本月最后一天
        LocalDateTime ldt3 = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()).atStartOfDay();
        System.out.println(ldt3);

        //下月第1天:
        LocalDateTime ldt4 = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth()).atStartOfDay();
        System.out.println(ldt4);

        //本月第1个周一:
        LocalDateTime ldt5 = LocalDate.now().with(TemporalAdjusters.dayOfWeekInMonth(1, DayOfWeek.MONDAY)).atStartOfDay();
        System.out.println(ldt5);

        //Duration
        //`P...T`之间表示日期间隔，`T`后面表示时间间隔。如果是`PT...`的格式表示仅有时间间隔
        Duration duration = Duration.between(ldt3, ldt4);
        System.out.println(duration);
        System.out.println(duration.getSeconds()); ;

        //Period
        Period p = LocalDate.of(2019, 11, 19).until(LocalDate.of(2020, 1, 9));
        System.out.println(p);


        //--------------------------------------------------------------------------------------------------------------
        // ZonedDateTime - 带时区的日期和时间
        //--------------------------------------------------------------------------------------------------------------
        //set
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("GMT+00:00"));
        System.out.println(zonedDateTime);

        LocalDateTime ldt6 = LocalDateTime.of(2020, 5, 21, 7, 11, 0);
        ZonedDateTime zdt = ldt6.atZone(ZoneId.systemDefault());
        ZonedDateTime zdt1  = ldt6.atZone(ZoneId.of("GMT+00:00"));
        System.out.println(zdt);
        System.out.println(zdt1);

        //zone convet
        ZonedDateTime zdt2 = zdt.withZoneSameInstant(ZoneId.of("GMT+00:00"));
        System.out.println(zdt2);


        //--------------------------------------------------------------------------------------------------------------
        // DateTimeFormatter - 格式化定制输出
        //--------------------------------------------------------------------------------------------------------------
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss ZZZZ").format(zdt2));
        System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(zdt2));

        //用自定义格式解析
        LocalDateTime dt2 = LocalDateTime.parse("2019/11/30 15:16:17", DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        System.out.println(dt2);


        //--------------------------------------------------------------------------------------------------------------
        // Instant - 高精度时间戳
        //--------------------------------------------------------------------------------------------------------------
        ZonedDateTime zonedDateTime1 = Instant.ofEpochSecond(1568568760).atZone(ZoneId.of("GMT+00:00"));
        System.out.println(zonedDateTime1);
    }
}
