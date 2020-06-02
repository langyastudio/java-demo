package thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程安全
 */
public class TaskQueueReentrantCls {
    private       Queue<String> queue     = new LinkedList<>();
    private final Lock          lock      = new ReentrantLock();
    private final Condition     condition = lock.newCondition();

    public synchronized void add(String task) {
        // tryLock()失败的时候不会导致死锁
        // lock.tryLock(1, TimeUnit.SECONDS)

        lock.lock();
        try {
            this.queue.offer(task);

            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public synchronized String get() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                condition.await();
            }
        }finally {
            lock.unlock();
        }

        return queue.poll();
    }
}
