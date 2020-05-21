package test;

public class Factorial {

    //安装 JUnit插件和JUnitGeneratorV2.0 插件
    //自动生成测试文件
    public static long fact(long n) {
        long r = 1;
        for (long i = 1; i <= n; i++) {
            r = r * i;
        }

        return r;
    }
}
