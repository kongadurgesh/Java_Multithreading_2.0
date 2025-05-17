package multithreading.advanced;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Q29_UseCyclicBarrierforbarriersynchronization {
    public static void main(String[] args) {
        int numThreads = 3;
        CyclicBarrier barrier = new CyclicBarrier(numThreads, () -> {
            System.out.println("All workers have reached the barrier, proceeding...");
        });
        for (int i = 0; i < 10; i++) {
            new Thread(new Worker1(barrier, i + 1)).start();
        }
    }
}

class Worker1 implements Runnable {
    private CyclicBarrier barrier;
    private int id;

    public Worker1(CyclicBarrier barrier, int id) {
        this.barrier = barrier;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread " + id + " is working");
            Thread.sleep(new Random().nextInt(3000));
            System.out.println("Thread " + id + " is waiting at the barrier...");
            barrier.await();
            System.out.println("Thread " + id + " continues after the barrier");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

}