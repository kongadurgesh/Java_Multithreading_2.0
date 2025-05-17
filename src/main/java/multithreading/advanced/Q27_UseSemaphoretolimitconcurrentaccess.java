package multithreading.advanced;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Q27_UseSemaphoretolimitconcurrentaccess {
    public static void main(String[] args) {
        SemaphoreExample semaphoreExample = new SemaphoreExample(3);
        for (int i = 0; i < 10; i++) {
            final String threadName = "Thread-" + i;
            Thread thread = new Thread(() -> semaphoreExample.accessResource(threadName));
            thread.start();
        }
    }
}

class SemaphoreExample {
    private Semaphore semaphore;

    public SemaphoreExample(int permits) {
        semaphore = new Semaphore(permits);
    }

    public void accessResource(String threadName) {
        try {
            semaphore.acquire();
            System.out.println("Thread: " + Thread.currentThread().getName() + " has acquired the semaphore...");
            Thread.sleep(new Random().nextInt(2000) + 1000);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread: " + threadName + " was interrupted.");
        } finally {
            semaphore.release();
            System.out.println("Thread: " + Thread.currentThread().getName() + " released the semaphore...");
        }
    }
}
