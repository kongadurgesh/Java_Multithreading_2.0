package multithreading.advanced;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Q26_ScheduletasksusingScheduledExecutorService {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        executorService.schedule(() -> {
            System.out.println("Delayed task executed by " + Thread.currentThread().getName());
        }, 2, TimeUnit.SECONDS);

        executorService.scheduleWithFixedDelay(() -> {
            System.out.println("Fixed-delay task executed by " + Thread.currentThread().getName());
        }, 1, 2, TimeUnit.SECONDS);

        executorService.scheduleAtFixedRate(() -> {
            System.out.println("Fixed-rate task executed by " + Thread.currentThread().getName());
        }, 1, 2, TimeUnit.SECONDS);

        executorService.schedule(() -> {
            executorService.shutdown();
        }, 10, TimeUnit.SECONDS);

    }
}
