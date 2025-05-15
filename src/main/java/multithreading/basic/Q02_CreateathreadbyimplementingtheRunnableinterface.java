package multithreading.basic;

public class Q02_CreateathreadbyimplementingtheRunnableinterface {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread());
        thread.start();
    }
}

class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello from Runnable!");
    }

}