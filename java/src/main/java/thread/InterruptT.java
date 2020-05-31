package thread;

/**
 * 中断与守护
 */
public class InterruptT extends Thread {
    /**
     * 共享变量在线程间的可见性问题
     */
    public volatile boolean running = true;

    public static void main(String[] args) throws Throwable{
        InterruptT t = new InterruptT();

        //守护进程
        //t.setDaemon(true);

        t.start();
        Thread.sleep(1);

        //中断
        //t.interrupt();
        t.running = false;

        // 等待hello线程结束
        try {
            t.join();
        } catch (InterruptedException e) {
            t.interrupt();
            System.out.println("interrupted!");
        }
        System.out.println("end");
    }

    @Override
    public void run() {
        int n = 1;
        while(!isInterrupted() && running){
            System.out.println(n++);
        }
    }
}
