package structure.adapter;

import java.util.concurrent.Callable;

public class Task implements Callable<Long> {
    private long num;

    public Task(long num)
    {
        this.num = num;
    }

    @Override
    public Long call() throws Exception {
        long r = 0;
        for (long n=1; n<this.num; n++)
        {
            System.out.println(n);
            r += n;
        }

        return r;
    }

    public static void main(String[] args) {
        Callable<Long> callable = new Task(10);
        Thread thread = new Thread(new RunableTask(callable));
        thread.start();
    }
}
