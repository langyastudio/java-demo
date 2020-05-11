import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class BasicT {
    /**
     * 入口函数
     * @param args 参数
     */
    public static void main(String[] args) {
        //--------------------------------------------------------------------------------------------------------------
        // 包装类
        //--------------------------------------------------------------------------------------------------------------
        //包装类 —— 基本数据类型是不面向对象的
        //自动拆装箱
        Integer inCls  = 123;
        int     ini = inCls;
        System.out.println("包装类自动拆装箱: " + Integer.parseInt("123456"));

        //进制转换
        System.out.println("123的二进制: " + Integer.toBinaryString(123));
        System.out.println("int 最大值" + Integer.MAX_VALUE);

        //unsigned
        System.out.println(Integer.toUnsignedLong(-123));

        //--------------------------------------------------------------------------------------------------------------
        // 整数运算
        //--------------------------------------------------------------------------------------------------------------
        //| & ^ ~ << >> >>> 等
        //与运算的规则是，必须两个数同时为1，结果才为1
        //或运算的规则是，只要任意一个为1，结果就为1
        //非运算的规则是，0和1互换
        //异或运算的规则是，如果两个数不同，结果为1，否则为0
        System.out.println( 0 & 0);// 0
        System.out.println( 0 & 1);// 0
        System.out.println( 0 | 1);// 1
        System.out.println( 0 ^ 1);// 1

        //对两个整数进行位运算，实际上就是按位对齐，然后依次对每一位进行运算。例如：
        System.out.println( ~0);// -1
        System.out.println( ~1);// -2

        //--------------------------------------------------------------------------------------------------------------
        // 浮点数运算
        //--------------------------------------------------------------------------------------------------------------
        double x = 1.0/10;
        double y = 1 - 9.0/10;
        System.out.println(x);
        System.out.println(y);

        //比较x和y是否相等
        if(Math.abs(x - y) < 0.00001)
        {
            System.out.println("相等");
        }

        //浮点数由于是非精度数据，所以/0不会报告异常
        System.out.println(0.0 / 0);
        System.out.println(1.0 / 0);
        System.out.println(-1.0 / 0);

        boolean b = 5 > 3;
        //System.out.println(b && (5/0 > 0));

        //--------------------------------------------------------------------------------------------------------------
        // 随机数
        //--------------------------------------------------------------------------------------------------------------
        SecureRandom sr = null;
        try {
            sr = SecureRandom.getInstanceStrong();

        }catch (NoSuchAlgorithmException e){
            sr = new SecureRandom();
        }
        System.out.println(sr.nextInt(100));

        byte [] bytes = new byte[16];
        sr.nextBytes(bytes);
        System.out.println(Arrays.toString(bytes));
    }
}