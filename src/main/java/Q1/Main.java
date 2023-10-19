package Q1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        Integer number = scanner.nextInt();

        List<Integer> sharedList = new ArrayList<>();

        Thread evenThread = new Thread(new EvenThread(number, sharedList));
        Thread oddThread = new Thread(new OddThread(number, sharedList));

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
