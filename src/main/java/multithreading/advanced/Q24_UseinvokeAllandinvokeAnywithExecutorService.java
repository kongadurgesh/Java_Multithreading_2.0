package multithreading.advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Q24_UseinvokeAllandinvokeAnywithExecutorService {
    public static void main(String[] args) {
        List<Callable<String>> callables = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            callables.add(new StringCallable("Task " + i));
        }
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        try {
            List<Future<String>> futures = executorService.invokeAll(callables);
            for (Future<String> future : futures) {
                System.out.println("result: " + future.get());
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        } catch (ExecutionException e) {
            System.out.println("ExecutionException occurred");
        }
        executorService.shutdown();

        System.out.println("*********Completed Invoke All************");
        executorService = Executors.newFixedThreadPool(4);
        try {
            String result = executorService.invokeAny(callables);
            System.out.println("Result: " + result);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        } catch (ExecutionException e) {
            System.out.println("ExecutionException occured");
        }
        executorService.shutdown();
    }
}

class StringCallable implements Callable<String> {

    private String taskName;

    public StringCallable(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public String call() throws Exception {
        int delay = new Random().nextInt(3000);
        Thread.sleep(delay);
        String message = "Thread " + Thread.currentThread().getName() + " is executing " + taskName;
        System.out.println(message);
        return message;
    }
}
