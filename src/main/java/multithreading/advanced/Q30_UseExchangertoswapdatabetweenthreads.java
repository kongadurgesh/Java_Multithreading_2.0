package multithreading.advanced;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Q30_UseExchangertoswapdatabetweenthreads {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        Thread thread1 = new Thread(() -> {
            String message1 = "Message from thread 1";
            try {
                String recievedMessage = exchanger.exchange(message1);
                System.out.println(
                        Thread.currentThread().getName() + " sent: " + message1 + ", received: " + recievedMessage);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            String message2 = "Message from thread 2";
            try {
                String recievedMessage = exchanger.exchange(message2, 5, TimeUnit.SECONDS);
                System.out.println(
                        Thread.currentThread().getName() + " sent: " + message2 + ", received: " + recievedMessage);
            } catch (InterruptedException | TimeoutException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();
    }
}
