package create.singleton;

/**
 * 单例模式
 */
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    public static Singleton getInstant()
    {
        return INSTANCE;
    }

    //确保外部无法实例化
    private Singleton()
    {

    }
}
