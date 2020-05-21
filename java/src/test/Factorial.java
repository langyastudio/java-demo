package test;

public class Factorial {

    //安装 JUnit插件和JUnitGeneratorV2.0 插件
    //自动生成测试文件
    public static long fact(long n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        long r = 1;
        for (long i = 1; i <= n; i++) {
            r = r * i;
        }

        return r;
    }

    public static String capitalize(String s)
    {
        if(s.length() < 1)
        {
            return s;
        }

        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }
}
