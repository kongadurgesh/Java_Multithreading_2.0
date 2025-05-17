package multithreading.advanced;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class Q25_ImplementcustomThreadFactory {
    public static void main(String[] args) {
        CustomThreadFactory customThreadFactory = new CustomThreadFactory("MyPool");
        ExecutorService executorService = Executors.newFixedThreadPool(3, customThreadFactory);
        for (int i = 0; i < 10; i++) {
            final int taskNumber = i;
            executorService.execute(() -> {
                System.out.println("Task " + taskNumber + " running in thread: " + Thread.currentThread().getName());
            });

        }
        executorService.shutdown();
    }
}

class CustomThreadFactory implements ThreadFactory {

    private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
    private final AtomicInteger THREAD_NUMBER = new AtomicInteger(1);
    private final String namePrefix;

    public CustomThreadFactory(String poolName) {
        namePrefix = poolName + "-" + POOL_NUMBER.getAndIncrement() + "-thread-";
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, namePrefix + THREAD_NUMBER.getAndIncrement());
        thread.setUncaughtExceptionHandler((t, e) -> {
            System.err.println("Uncaught Exception in thread: " + t.getName());
            e.printStackTrace();
        });
        return thread;
    }
}
