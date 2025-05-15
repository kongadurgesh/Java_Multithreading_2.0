package multithreading.basic;

public class Q05_CheckifathreadisaliveusingisAlivemethod {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new AliveThread();
        thread.start();
        System.out.println(thread.isAlive());
        thread.join();
        System.out.println(thread.isAlive());
    }
}

class AliveThread extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
            System.out.println();
        }
    }
}
