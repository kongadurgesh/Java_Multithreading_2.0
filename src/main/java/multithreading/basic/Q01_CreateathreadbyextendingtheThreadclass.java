package multithreading.basic;

public class Q01_CreateathreadbyextendingtheThreadclass {
    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello from thread!");
    }
}
