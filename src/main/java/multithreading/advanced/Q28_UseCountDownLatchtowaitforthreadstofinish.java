package multithreading.advanced;

import java.util.concurrent.CountDownLatch;

public class Q28_UseCountDownLatchtowaitforthreadstofinish {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            final String threadName = "Thread-" + i;
            Thread thread = new Thread(new Worker(countDownLatch, threadName));
            thread.start();
        }
        countDownLatch.await();
        System.out.println("All worker threads have completed...");
    }
}

class Worker implements Runnable {

    private CountDownLatch countDownLatch;
    private String name;

    public Worker(CountDownLatch countDownLatch, String name) {
        this.countDownLatch = countDownLatch;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println("Worker Thread " + name + " started working");
            Thread.sleep(1000);
            System.out.println("Worker Thread " + name + " completed working");
        } catch (InterruptedException e) {
            System.out.println("InterruptedException occurred");
        } finally {
            countDownLatch.countDown();
        }
    }

}
