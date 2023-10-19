package Q3;

class Starvation extends Thread {
    static int count = 1;
    public void run() {
        System.out.println(count + " Thread execution starts");
        System.out.println("Thread execution completes");
        count++;
    }
}
