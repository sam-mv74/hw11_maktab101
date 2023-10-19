package Q1;

import java.util.List;

public class EvenThread implements Runnable{
    private int n;
    private List<Integer> sharedList;

    public EvenThread(int n, List<Integer> sharedList) {
        this.n = n;
        this.sharedList = sharedList;
    }
    @Override
    public void run() {
        for (int i = 0; i <= n; i += 2) {
            synchronized (sharedList) {
                sharedList.add(i);
                sharedList.notify();
                if (i < n) {
                    try {
                        sharedList.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
