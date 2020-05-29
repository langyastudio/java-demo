package thread;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 */
public class ThreadPoolT {

    public static void main(String[] args) throws InterruptedException {
        //固定线程池
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (int ix=0; ix<10; ix++){
            executor.submit(new RunnableCls(Integer.toString(ix)));
        }
        //等待多长时间后，再关闭
        //executor.awaitTermination(10, TimeUnit.MINUTES);
        executor.shutdown();

        //定时任务
        ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(4);

        //上个任务执行完毕后，再间隔执行
        /*scheduled.scheduleWithFixedDelay(()->{
            System.out.println(LocalDateTime.now());
        }, 1, 1, TimeUnit.SECONDS);*/

        //不管任务有没有执行完毕，定时执行
        scheduled.scheduleAtFixedRate(()->{
            System.out.println(LocalDateTime.now());
            }, 1, 1, TimeUnit.SECONDS);
    }
}
