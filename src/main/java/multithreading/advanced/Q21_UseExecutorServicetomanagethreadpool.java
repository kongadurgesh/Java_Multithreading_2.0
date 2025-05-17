package multithreading.advanced;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Q21_UseExecutorServicetomanagethreadpool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 1; i < 11; i++) {
            executorService.execute(new Task("Task " + i));
        }
        executorService.shutdown();
    }
}

class Task implements Runnable {

    private String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " is executing" + taskName);
    }

}
