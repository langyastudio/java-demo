package create.factoryfunction;

import java.math.BigDecimal;

/**
 * 工厂方法
 */
public class NumberFactory {
    /**
     * 静态方法直接生产产品
     *  BigDecimal是具体的产品
     *  Number是抽象产品
     */
    public static Number parse(String str)
    {
        return new BigDecimal(str);
    }
}