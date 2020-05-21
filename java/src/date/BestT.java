package date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class BestT {
    public static void main(String[] args) {
        //old to new
        //date --> Instant --> ZonedDateTime --> LocalDateTime
        Date          dt = new Date();
        ZonedDateTime zdt = dt.toInstant().atZone(ZoneId.systemDefault());
        System.out.println(zdt);

        LocalDateTime ldt = zdt.toLocalDateTime();
        System.out.println(ldt);

        //new to old
        //ZonedDateTime --> Instant --> Date
        long ts = zdt.toInstant().toEpochMilli();
        Date dt1 = new Date(ts);
        System.out.println(dt1);

        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTimeZone(TimeZone.getTimeZone(zdt.getZone().getId()));
        calendar.setTimeInMillis(ts);
    }
}
