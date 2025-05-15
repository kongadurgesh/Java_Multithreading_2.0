package multithreading.intermediate;

public class Q14_Demonstratedeadlockbetweentwothreads {
    public static void main(String[] args) throws InterruptedException {
        Object lock1 = new Object();
        Object lock2 = new Object();
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Lock 1 acquired by Thread 1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("Lock 2 acquired by Thread 1");
                }
            }

        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Lock 2 acquired by Thread 2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("Lock 1 acquired by Thread 2");
                }
            }

        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
