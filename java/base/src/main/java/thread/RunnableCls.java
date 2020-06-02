package thread;

/**
 * 线程实现体
 */
public class RunnableCls implements Runnable {
    private final String name;

    public RunnableCls(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println( this.name + " thread running");
        try {
            Thread.sleep(100);
        }catch (InterruptedException e){

        }
        System.out.println( this.name + " thread end");
    }
}