// Dean Shalev 209707470
import java.util.Random;
import static java.lang.Thread.sleep;

public class Exec_Threads implements Runnable {
    Random rand = new Random();
    double N = 1000;
    int range = 10;
    LockedCounter counter;

    public Exec_Threads(LockedCounter counter) {
        this.counter = counter;
    }

    public void run() {
        long tid = Thread.currentThread().getId();
        System.out.println("Thread ID: " + tid + " started");
        if (tid % 2 == 0) {
            for (int i = 0; i < 10000; i++) {
                try {
                    sleep(rand.nextInt(range));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter.inc();
            }
        }
        else {
            for (int i = 0; i < 10000; i++) {
                try {
                    sleep(rand.nextInt(range));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            counter.dec();
            }
        }
    }
}
