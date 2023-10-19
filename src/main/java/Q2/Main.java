package Q2;

public class Main {
    private static Object resource1 = new Object();
    private static Object resource2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("thread 1 has resource 1 ..");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}
                System.out.println("thread 1 is waiting for resource 2 ..");
                synchronized (resource2) {
                    System.out.println("thread 1 got resource 2 ..");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("thread 2 has resource 2 ..");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}
                System.out.println("thread 2 is waiting for resource 1 ..");
                synchronized (resource1) {
                    System.out.println("thread 2 got resource 1 ..");
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
