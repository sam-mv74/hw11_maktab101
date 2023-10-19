package Q1;

import java.util.List;

public class OddThread implements Runnable {
    private int n;
    private List<Integer> sharedList;

    public OddThread(int n, List<Integer> sharedList) {
        this.n = n;
        this.sharedList = sharedList;
    }

    @Override
    public void run() {
        for (int i = 1; i <= n; i += 2) {
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
