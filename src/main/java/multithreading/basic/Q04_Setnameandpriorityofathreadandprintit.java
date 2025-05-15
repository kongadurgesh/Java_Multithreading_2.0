package multithreading.basic;

public class Q04_Setnameandpriorityofathreadandprintit {
    public static void main(String[] args) throws InterruptedException {
        Thread thread_1 = new MyThread_1();
        thread_1.setName("Class Thread");
        thread_1.setPriority(Thread.MAX_PRIORITY);

        Thread thread_2 = new Thread(new RunnableThread());
        thread_2.setName("Runnable Thread");
        thread_2.setPriority(Thread.MIN_PRIORITY);

        thread_1.start();
        thread_2.start();
        thread_1.join();
        thread_2.join();
    }
}

class MyThread_1 extends Thread {
    public void run() {
        System.out.println("Thread Name: " + Thread.currentThread().getName());
        System.out.println("Thread priority: " + Thread.currentThread().getPriority());
    }
}

class RunnableThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread Name: " + Thread.currentThread().getName());
        System.out.println("Thread priority: " + Thread.currentThread().getPriority());
    }

}