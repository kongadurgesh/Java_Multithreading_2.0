package multithreading.basic;

public class Q09_Createadaemonthreadandobserveitsbehavior {
    public static void main(String[] args) {
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon Thread is running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Daemon Thread Interrupted");
                }
            }

        });

        daemonThread.setDaemon(true);
        daemonThread.start();

        System.out.println("Main thread sleeping for 2 seconds");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main Thread Finished");
    }
}
