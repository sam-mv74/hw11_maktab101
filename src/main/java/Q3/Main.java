package Q3;

public class Main {
    public static void main(String[] args) {
        System.out.println("Parent thread execution starts");

        Starvation thread1 = new Starvation();
        thread1.setPriority(7);

        Starvation thread2 = new Starvation();
        thread2.setPriority(6);

        Starvation thread3 = new Starvation();
        thread3.setPriority(5);

        Starvation thread4 = new Starvation();
        thread4.setPriority(4);

        Starvation thread5 = new Starvation();
        thread5.setPriority(3);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

  /* Here thread 5 have to wait because of the
     other threads */
        thread5.run();

        System.out.println("Parent thread execution completes");
    }
}
