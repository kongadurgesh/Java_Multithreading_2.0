package multithreading.advanced;

public class Q31_ThreadLocal {
    public static void main(String[] args) {
        ThreadLocal<String> local = new ThreadLocal<>();

        Thread thread1 = new Thread(() -> {
            local.set("Thread 1 Value");
            System.out.println("Thread Name: " + Thread.currentThread().getName() + ", Value: " + local.get());
        });

        Thread thread2 = new Thread(() -> {
            local.set("Thread 2 Value");
            System.out.println("Thread Name: " + Thread.currentThread().getName() + ", Value: " + local.get());
        });

        thread1.start();
        thread2.start();
    }
}
