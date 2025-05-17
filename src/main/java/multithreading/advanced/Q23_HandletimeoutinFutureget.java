package multithreading.advanced;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Q23_HandletimeoutinFutureget {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Integer> future = executorService.submit(new FutureTask());

        try {
            future.get(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        } catch (ExecutionException e) {
            System.out.println("Task Execution Exception");
        } catch (TimeoutException e) {
            System.out.println("Time out Exception occured");
            future.cancel(true);
        }
        executorService.shutdown();
    }
}

class FutureTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("Task started by " + Thread.currentThread().getName());
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("Working " + (i + 1) + " sec");
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted");
                return null;
            }

        }
        System.out.println("Task completed by " + Thread.currentThread().getName());
        return 123;
    }

}
