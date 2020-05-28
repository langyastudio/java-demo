package thread;

/**
 * 线程实现体
 */
public class RunnableCls implements Runnable {
    @Override
    public void run() {
        System.out.println("thread running");
    }
}