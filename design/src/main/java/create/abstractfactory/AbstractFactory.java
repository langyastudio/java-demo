package create.abstractfactory;

/**
 * 抽象工厂
 *   多个供应商负责提供一系列类型的产品
 */
public interface AbstractFactory {
    public static AbstractFactory createFactory(String name)
    {
        if("fast".equalsIgnoreCase(name)){
            return new FastFactory();
        } else {
            throw new IllegalArgumentException("Invalid factory name");
        }
    }

    // 创建Html文档
    HtmlDocument createHtml(String md);
    // 创建Word文档
    WordDocument createWord(String md);
}