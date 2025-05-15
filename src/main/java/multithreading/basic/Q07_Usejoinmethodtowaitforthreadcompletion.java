package multithreading.basic;

public class Q07_Usejoinmethodtowaitforthreadcompletion {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Thread thread_1 = new Thread(task);
        Thread thread_2 = new Thread(task);

        thread_1.start();
        thread_2.start();
        thread_1.join();
        thread_2.join();
        System.out.println("Count: " + counter.getCount());
    }
}

class Counter {
    private int counter;

    public Counter() {
        counter = 0;
    }

    public void increment() {
        synchronized (this) {
            counter++;
        }
    }

    public int getCount() {
        return counter;
    }
}
