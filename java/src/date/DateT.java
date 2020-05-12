package date;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class DateT {
    /**
     * 入口函数
     * @param args 参数
     */
    public static void main(String[] args) {
        //日期1
        Date nowDate = new Date();
        System.out.printf("一年中的天数（即年的第几天）：%tj%n", nowDate);
        System.out.printf("当前时间：%tY-%tm-%td %tH:%tM:%tS %n", nowDate, nowDate, nowDate, nowDate, nowDate, nowDate);
        System.out.printf("年-月-日格式：%tF%n", nowDate);
        System.out.printf("HH:MM:SS格式（24时制）：%tT%n", nowDate);

        System.out.printf("3位数字的毫秒（不足3位前面补0）:%tL%n", nowDate);
        System.out.printf("9位数字的毫秒数（不足9位前面补0）:%tN%n", nowDate);

        System.out.printf("1970-1-1 00:00:00 到现在所经过的秒数：%ts%n", nowDate);
        System.out.printf("1970-1-1 00:00:00 到现在所经过的毫秒数：%tQ%n", nowDate);

        //日期2
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm::ss EE");
        System.out.println("yyyy-MM-dd HH:mm::ss EE, 系统默认时区" + df.format(nowDate));
    }
}