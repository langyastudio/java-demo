package basic;

/*
 在Java中被推荐的资源释放方法为，提供显式的具有良好命名的接口方法，
 如 FileInputStream.close() 和 Graphic2D.dispose() 等。
 然后使用者在finally区块中调用该方法
 */
public class FinalizeEx {
    private int _myStatus;

    @Override
    protected void finalize() throws Throwable {
        try {
            //在调试过程中通过该方法，打印对象在被收集前的各种状态，
            //如判断是否仍有资源未被释放，或者是否有状态不一致的现象存在。
            //推荐将该finalize方法设计成仅在debug状态下可用，而在release
            //下该方法并不存在，以避免其对运行时效率的影响。
            System.out.println("The current status: " + _myStatus);
        } finally {
            //在finally中对超类finalize方法的调用是必须的，这样可以保证整个class继承
            //体系中的finalize链都被执行。
            super.finalize();
        }
    }
}
