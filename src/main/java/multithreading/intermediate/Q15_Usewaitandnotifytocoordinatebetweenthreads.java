package multithreading.intermediate;

import java.util.Scanner;

public class Q15_Usewaitandnotifytocoordinatebetweenthreads {
    public static void main(String[] args) throws InterruptedException {
        Processor processor = new Processor();

        Thread thread1 = new Thread(() -> {
            try {
                processor.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                processor.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}

class Processor {
    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Thread 1 is Runnning...");
            wait();
            System.out.println("Thread 1 resumed...");
        }
    }

    public void consume() throws InterruptedException {
        synchronized (this) {
            Thread.sleep(2000);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Thread 2 is runnning and waiting for enter to be pressed...");
            scanner.nextLine();
            notify();
            System.out.println("Enter pressed...");
        }
    }
}
