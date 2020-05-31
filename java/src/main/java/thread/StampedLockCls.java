package thread;

import java.util.concurrent.locks.StampedLock;

/**
 * 乐观读
 */
public class StampedLockCls {
    private final StampedLock stampedLock = new StampedLock();

    private double x;
    private double y;

    public void move(double deltaX, double deltaY) {
        long stamp = stampedLock.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }

    public double distance() {
        //乐观读锁
        long stamp = stampedLock.tryOptimisticRead();

        double xVal = this.x;
        double yVal = this.y;

        // 检查乐观读锁后是否有其他写锁发生
        if (!stampedLock.validate(stamp)) {

            //获取悲观锁，重新读
            stamp = stampedLock.readLock();
            try {
                xVal = this.x;
                yVal = this.y;
            } finally {
                stampedLock.unlockRead(stamp);
            }
        }

        return Math.sqrt(xVal * xVal + yVal * yVal);
    }
}
