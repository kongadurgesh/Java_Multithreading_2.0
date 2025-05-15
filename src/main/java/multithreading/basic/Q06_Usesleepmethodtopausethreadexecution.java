package multithreading.basic;

public class Q06_Usesleepmethodtopausethreadexecution {
    public static void main(String[] args) {
        Thread thread = new Thread(new SleepingThread());
        thread.start();
    }
}

class SleepingThread implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
