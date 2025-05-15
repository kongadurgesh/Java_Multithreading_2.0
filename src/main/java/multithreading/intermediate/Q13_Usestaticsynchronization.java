package multithreading.intermediate;

public class Q13_Usestaticsynchronization {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                Counter1.increment();
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Counter: " + Counter1.getCounter());
    }
}

class Counter1 {
    private static int counter = 0;

    public static synchronized void increment() {
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
}
