import java.math.BigDecimal;
import java.math.RoundingMode;


public class BigT {
    /**
     * 入口函数
     * @param args 参数
     */
    public static void main(String[] args) {
        //大数字运算 - BigInteger | BigDecimal
        //BigInteger和BigDecimal都是不可变 - 不适合于大量的数学计算
        //设计BigInteger和BigDecimal的目的是用来精确地表示大整数和小数，使用于在商业计算中使用
        double     d1 = 12.59;
        double     d2 = 56.59;

        //用String构造BigDecimal，避免用double构造无法精确表示
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        System.out.println("BigDecimal 12.59 multiply 56.59: " + (b1.multiply(b2)).doubleValue());

        //默认除法运算精度,即保留小数点多少位
        final int DEFAULT_DIV_SCALE = 10;
        System.out.println("BigDecimal 12.59 divide 56.59: " + (b1.divide(b2, DEFAULT_DIV_SCALE, RoundingMode.HALF_UP)).doubleValue());

        BigDecimal b3 = new BigDecimal(0.1);
        BigDecimal b4 = new BigDecimal("0.1");
        System.out.println("b3 double 0.1: " + b3);
        System.out.println("b4 string 0.1: " + b4);
        System.out.println("b3 equals b4:  " + (b3.equals(b4)));
        System.out.println("b3 compareTo b4:  " + (b3.compareTo(b4)));
    }
}