import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/*
 * this 表示调用子类中相应的属性和方法
 * super 表示调用父类中相应的属性和方法
 */
public class program {
    enum PeopleEnum{
        //男士
        MAIL,
        //女士
        WOMEN
    };

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

        //【2】Array
        int a[][] = new int[][]{{1, 2, 3}, {2, 3, 4}, {4, 3, 5, 6}}; //二维数组，每一维可以不一样

        /*
         * Arrays工具类的中的几个常用方法
         * 1.copyof
         * 2.toString
         * 3.equals
         * 4.sort
         * 5.fill
         * 6.binarySearch
         */
        Arrays.sort(a[2]);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.println(a[i][j]);
            }
        }

        String strArr[]  = {"北京", "上海", "重庆", "深圳"};
        String strArr1[] = Arrays.copyOf(strArr, 3);
        System.out.println(Arrays.toString(strArr));
        System.out.println(Arrays.toString(strArr1));

        //【3】包装类 —— 基本数据类型却是不面向对象的
        Integer in  = 123; //自动拆装箱
        int     ini = in;
        System.out.println("包装类自动拆装箱: " + Integer.parseInt("123456"));

        //【3】集合 List、Set、Map
        //ArrayList or LinkedList
        //Set --> HashSet TreeSet
        List<String> strList = new ArrayList<>();
        strList.add("list a");
        strList.add("list b");
        strList.set(1, "list bb");
        strList.add("list c");
        Iterator<String> itList = strList.iterator();
        int listSize = strList.size();
        while (itList.hasNext())
        {
            System.out.println("List : " + itList.next());
        }

        //Map --> HashMap TreeMap
        Map<String, String> strMap = new HashMap<>();
        strMap.put("H", "本田");
        strMap.put("日", "丰田");
        for (String key : strMap.keySet()) {
            System.out.println("Map : " + strMap.get(key));
        }

        //【4】大数字运算 - BigInteger | BigDecimal
        //BigInteger和BigDecimal都是不可变 - 不适合于大量的数学计算
        //设计BigInteger和BigDecimal的目的是用来精确地表示大整数和小数，使用于在商业计算中使用
        double     d1 = 12.59;
        double     d2 = 56.59;
        BigDecimal b1 = new BigDecimal(Double.toString(d1)); //用String构造BigDecimal，避免用double构造无法精确表示
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        System.out.println("BigDecimal 12.59 multiply 56.59: " + (b1.multiply(b2)).doubleValue());

        //默认除法运算精度,即保留小数点多少位
        final int DEFAULT_DIV_SCALE = 10;
        System.out.println("BigDecimal 12.59 divide 56.59: " + (b1.divide(b2, DEFAULT_DIV_SCALE, BigDecimal.ROUND_HALF_UP)).doubleValue());

        BigDecimal b3 = new BigDecimal(0.1);
        BigDecimal b4 = new BigDecimal("0.1");
        System.out.println("b3 double 0.1: " + b3);
        System.out.println("b4 string 0.1: " + b4);
        System.out.println("b3 equals b4:  " + (b3.equals(b4)));
        System.out.println("b3 compareTo b4:  " + (b3.compareTo(b4)));

        //【4】内部类
        try{
            program  outer = new program();
            InterCls inter = outer.new InterCls();
            inter.print("Outer.new");

            inter = outer.getInner();
            inter.print("Outer.get");

            // 返回 Class 实例
            Object outerCls = outer.getClass();

            // Exception
            int ex = 12 / 0;

        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }

        //【5】集合类


    }

    //推荐使用getxxx()来获取成员内部类，尤其是该内部类的构造函数无参数时
    private InterCls getInner() {
        return new InterCls();
    }

    /**
     * 方法内部类
     */
    public class InterCls {
        public void print(String str) throws Exception {
            System.out.println(str);
        }
    }
}