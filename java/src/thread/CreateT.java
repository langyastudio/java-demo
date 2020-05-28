package thread;

/**
 * 创建
 */
public class CreateT {
    public static void main(String[] args) throws InterruptedException{
        Thread t = new Thread(new RunnableCls());

        // 启动新线程
        t.start();

        //等待其执行结束
        //t.join();

        System.out.println("main thread running");
    }
}
