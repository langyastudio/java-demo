package structure.adapter;

import java.util.concurrent.Callable;

/**
 * 转换器
 */
public class RunableTask implements Runnable {
    Callable<?> callable;

    public RunableTask(Callable<?> callable) {
        this.callable = callable;
    }

    @Override
    public void run() {
        try {
            callable.call();
        } catch (Exception e) {
        }
    }
}
