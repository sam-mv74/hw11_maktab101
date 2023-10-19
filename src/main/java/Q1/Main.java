package Q1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n = 10;

        List<Integer> sharedList = new ArrayList<>();

        Thread evenThread = new Thread(new EvenThread(n, sharedList));
        Thread oddThread = new Thread(new OddThread(n, sharedList));

        evenThread.start();
        oddThread.start();

        try {
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Generated List: " + sharedList);
    }
}
