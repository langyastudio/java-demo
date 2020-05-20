package date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateT {
    public static void main(String[] args) {
        //Date不能转换时区、运算
        Date date = new Date();

        System.out.println(date.getYear()+1900);// 必须加上1900
        System.out.println(date.getMonth()+1);// 0~11，必须加上1
        System.out.println(date.getDate());

        System.out.println(date.toString());
        System.out.println(date.toLocaleString());
        System.out.println(date.toGMTString());

        //Calendar - 可以做简单的日期和时间运算
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH) + 1);
        System.out.println(calendar.get(Calendar.DATE));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));//`1`~`7`分别表示周日，周一，……，周六
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));

        // 清除所有:
        calendar.clear();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        calendar.set(Calendar.MONTH, 6);
        calendar.set(2020, Calendar.MAY, 21, 6, 21, 18);

        System.out.println(calendar.getTime().toLocaleString());

        //format
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(calendar.getTime()));

        //TimeZone
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        System.out.println(sdf.format(calendar.getTime()));
    }
}
