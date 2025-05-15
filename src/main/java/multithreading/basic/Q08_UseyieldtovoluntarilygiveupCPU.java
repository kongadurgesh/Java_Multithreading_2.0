package multithreading.basic;

public class Q08_UseyieldtovoluntarilygiveupCPU {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("Thread Name: " + Thread.currentThread().getName());
                counter.increment();
                System.out.println("Counter: " + counter.getCount());
                Thread.yield();
            }
        };

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        thread1.start();
        thread2.start();

    }
}
