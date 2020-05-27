package thread;

/**
 * 线程实现体
 */
public class RunnableT implements Runnable {
    @Override
    public void run() {
        System.out.println("thread running");
    }
}
