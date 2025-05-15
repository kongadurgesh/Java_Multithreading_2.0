package multithreading.basic;

public class Q10_UseThreadcurrentThreadtogetcurrentthreadinfo {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println("Name: " + Thread.currentThread().getName());
            System.out.println("Priority: " + Thread.currentThread().getPriority());
            System.out.println("Alive Status: " + Thread.currentThread().isAlive());
        });
        thread1.setPriority(8);
        thread1.setName("Test");
        thread1.start();
    }
}
