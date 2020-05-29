package thread;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 线程安全
 */
public class ReadWriteLockCls {
    private int [] queue = new int[]{};
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock rLock = readWriteLock.readLock();
    private final Lock wLock = readWriteLock.writeLock();


    public void inc(int index){
        wLock.lock();
        try
        {
            queue[index]++;
        }finally {
            wLock.unlock();
        }
    }

    public int [] get(){
        rLock.lock();
        try
        {
            return Arrays.copyOf(queue, queue.length);
        }finally {
            rLock.unlock();
        }
    }
}
