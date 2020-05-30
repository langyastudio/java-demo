package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 同线程状态传递
 */
public class ThreadLocalT {
    public static void main(String[] args) {
        ExecutorService es    = Executors.newFixedThreadPool(4);
        String[]        users = new String[]{"Bob", "Alice", "Tim", "Mike", "Lily", "Jack", "Bush"};
        for (String user : users) {
            es.submit(new Task(user));
        }

        es.shutdown();
    }
}

/**
 * 任务
 */
class Task implements Runnable {
    final String userName;

    public Task(String userName) {
        this.userName = userName;
    }

    @Override
    public void run() {
        try {
            try (var ctx = new UserContext(this.userName)) {
                //内部进行N个方法调用
                new Task1().process();
                new Task2().process();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Task1 {
    public void process() {
        System.out.printf("[%s] check user %s...\n", Thread.currentThread().getName(), UserContext.getContext());
    }
}

class Task2 {
    public void process() {
        System.out.printf("[%s] registered user %s...\n", Thread.currentThread().getName(), UserContext.getContext());
    }
}


/**
 * 线程状态
 */
class UserContext implements AutoCloseable {
    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public UserContext(String name) {
        threadLocal.set(name);
    }

    public static String getContext() {
        return threadLocal.get();
    }

    @Override
    public void close() throws Exception {
        // 使用完毕后需要清空
        // 否则线程复用时状态污染
        threadLocal.remove();
    }
}