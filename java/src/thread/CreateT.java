package thread;

/**
 * 创建
 */
public class CreateT {
    public static void main(String[] args) {
        Thread t = new Thread(new RunnableT());

        // 启动新线程
        t.start();

        System.out.println("main thread running");
    }
}
