package multithreading.intermediate;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Q20_UsetryLockwithtimeout {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLockExample1 counter = new ReentrantLockExample1();
        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                try {
                    counter.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Counter: " + counter.getCounter());
    }
}

class ReentrantLockExample1 {
    private ReentrantLock lock = new ReentrantLock();
    private int counter = 0;

    public void increment() throws InterruptedException {
        if (lock.tryLock(1L, TimeUnit.SECONDS)) {
            try {
                counter++;
            } finally {
                lock.unlock();
            }
        }
    }

    public int getCounter() throws InterruptedException {
        if (lock.tryLock(1L, TimeUnit.SECONDS)) {
            try {
                return counter;
            } finally {
                lock.unlock();
            }
        }
        return -1;
    }
}
