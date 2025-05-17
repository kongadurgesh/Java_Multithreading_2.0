package multithreading.advanced;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Q22_SubmittasksusingCallableandgetresultusingFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 5; i++) {
            int n = new Random().nextInt(10) + 1;
            executorService.submit(new SumCalculatorTask(n));
        }
        executorService.shutdown();
    }
}

class SumCalculatorTask implements Callable<Integer> {

    private int n;

    public SumCalculatorTask(int n) {
        this.n = n;
    }

    @Override
    public Integer call() throws Exception {
        int sum = (n * (n + 1)) / 2;
        System.out.println("Thread " + Thread.currentThread().getName() + " computed sum: " + sum);
        return sum;
    }

}
