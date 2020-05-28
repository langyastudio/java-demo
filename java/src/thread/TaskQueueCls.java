package thread;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 线程安全
 */
public class TaskQueueCls {
    Queue<String> queue = new LinkedList<>();

    public synchronized void add(String task){
        this.queue.offer(task);

        this.notifyAll();
    }

    public synchronized String get() throws InterruptedException{
        while (queue.isEmpty()){
            this.wait();
        }

        return queue.poll();
    }
}
