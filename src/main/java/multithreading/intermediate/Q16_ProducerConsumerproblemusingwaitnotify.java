package multithreading.intermediate;

import java.util.LinkedList;
import java.util.Random;

public class Q16_ProducerConsumerproblemusingwaitnotify {

    public static void main(String[] args) throws InterruptedException {
        Processor1 processor = new Processor1();
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

class Processor1 {
    private LinkedList<Integer> list = new LinkedList<>();
    private final int LIMIT = 10;
    private Object lock = new Object();

    public void produce() throws InterruptedException {
        int value = 0;

        while (true) {
            synchronized (lock) {
                while (list.size() == LIMIT) {
                    lock.wait();
                }
                list.add(value);
                System.out.print("List size: " + list.size());
                System.out.println(", Value added: " + value++);
                Thread.sleep(new Random().nextInt(10));
                lock.notify();
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (list.size() == 0) {
                    lock.wait();
                }
                System.out.print("List size: " + list.size());
                int value = list.removeFirst();
                System.out.println(", Value removed: " + value);
                lock.notify();
            }
        }

    }
}
