package multithreading.basic;

public class Q03_Printnumbersfrom1to10usingtwothreads {
    public static void main(String[] args) {
        Thread thread_1 = new MyThread1();
        Thread thread_2 = new Thread(new MyThread2());
        thread_1.start();
        thread_2.start();
    }
}

class MyThread1 extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }
    }
}

class MyThread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 6; i <= 10; i++) {
            System.out.println(i);
        }
    }

}
