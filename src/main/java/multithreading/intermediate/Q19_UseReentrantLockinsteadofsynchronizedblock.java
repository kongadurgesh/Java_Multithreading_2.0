package multithreading.intermediate;

import java.util.concurrent.locks.ReentrantLock;

public class Q19_UseReentrantLockinsteadofsynchronizedblock {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLockExample example = new ReentrantLockExample();
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                example.increment();
            }
        };
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Counter: " + example.getCounter());
    }
}

class ReentrantLockExample {
    private ReentrantLock lock = new ReentrantLock();
    private int counter = 0;

    public void increment() {
        lock.lock();
        try {
            counter++;
        } finally {
            lock.unlock();
        }
    }

    public int getCounter() {
        lock.lock();
        try {
            return counter;
        } finally {
            lock.unlock();
        }
    }
}
