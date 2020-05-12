package cls;

import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.StringJoiner;

public class StringT {
    public static void main(String[] args) {
        //--------------------------------------------------------------------------------------------------------------
        // 字符
        //--------------------------------------------------------------------------------------------------------------
        //char
        char c1 = 'A';
        char c2 = '中';
        System.out.println(c1);
        //Unicode编码
        System.out.println((int)c1);

        //--------------------------------------------------------------------------------------------------------------
        // 字符串
        //--------------------------------------------------------------------------------------------------------------
        //string 的内部是通过char[]表示
        String str = new String(new char[]{'a', 'b', 'c'});

        //String
        String str1 = "123456789";
        String str2 = "asdfghjkl";

        System.out.println("abc\"\\bcd\u4e2d");
        System.out.println(str1 + " concat " + str2 + ":");
        System.out.println(str1 + str2); //can replace by concat

        //字符串比较时，不可使用“==”，其用于比较两个字符串的地址。
        System.out.println(str1 + " compare " + str2 + ":");
        System.out.println(str1.equalsIgnoreCase(str2));

        //format
        System.out.println(String.format("hi, %s", "天霸"));
        System.out.printf(" %% 字母a的大写是：%c %n", 'A'); //%n表示换行符
        System.out.printf("8x6 的结果是：%d %n", 8 * 6);

        System.out.printf("8x6 的4位结果是：%04d %n", 8 * 6);
        System.out.printf("49.8是：%2.2f %n", 49.8);

        //split join
        String [] strSplit = "a,b,c,d".split(",");
        System.out.println(Arrays.toString(strSplit));
        System.out.println(String.join(":", strSplit));

        //valueof parse
        System.out.println( String.valueOf(true) );
        System.out.println( Integer.parseInt("123") );
        System.out.println( Boolean.parseBoolean("FALSE"));
        System.out.println( Integer.getInteger("java.version"));

        //code
        byte[] bArr =  "unicode".getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(bArr));
        System.out.println(new String(bArr));

        //--------------------------------------------------------------------------------------------------------------
        // StringBuilder
        //--------------------------------------------------------------------------------------------------------------
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append(",")
              .append(i);
        }
        System.out.println(sb.toString());

        //--------------------------------------------------------------------------------------------------------------
        // StringJoiner
        //--------------------------------------------------------------------------------------------------------------
        String[] names = {"Bob", "Alice", "Grace"};
        StringJoiner sj = new StringJoiner(",", "Start ", " end");
        for (String name : names) {
            sj.add(name);
        }
        System.out.println(sj.toString());
    }
}
