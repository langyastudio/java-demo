package structure.proxy;

public class ALogic implements A{
    private A a;

    public ALogic(A a)
    {
        this.a = a;
    }

    @Override
    public int handle() {
        //处理业务逻辑
        return this.a.handle();
    }
}
