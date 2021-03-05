package thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程等待
 */
public class WaitT {
    public static void main(String[] args) throws InterruptedException {
        TaskQueueCls      taskQueueCls = new TaskQueueCls();
        ArrayList<Thread> gets         = new ArrayList<>();

        //获取任务
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                while (true) {
                    try {
                        String task = taskQueueCls.get();
                        System.out.println("get task " + task);

                        Thread.sleep(400);
                    } catch (InterruptedException interruptedException) {
                        break;
                    }
                }
            });

            thread.start();
            gets.add(thread);
        }

        //添加任务
        Thread threadAdd = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("add task " + i);
                taskQueueCls.add("value " + i);

                try { Thread.sleep(200); } catch(InterruptedException e) {}
            }
        });
        threadAdd.start();
        threadAdd.join();

        Thread.sleep(1000);

        for (Thread item : gets) {
            item.interrupt();
        }
    }
}
