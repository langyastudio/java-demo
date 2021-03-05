package structure.proxy;

public class ACheck implements A{
    private A a;

    public ACheck(A a)
    {
        this.a = a;
    }

    @Override
    public int handle() {
        //处理校验逻辑
        return this.a.handle();
    }
}
