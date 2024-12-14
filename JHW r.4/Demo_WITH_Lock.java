// Dean Shalev 209707470
public class Demo_WITH_Lock {
    
    public static void main(String[] args) {
        System.out.println("In main() Demo_WITH_Lock");

        LockedCounter counter = new LockedCounter();
        Exec_Threads eT = new Exec_Threads(counter);

        Thread t1 = new Thread(eT);
        Thread t2 = new Thread(eT);
        t2.start(); 
        t1.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (counter.get() == 0)
            System.out.println("\nCounter final value: " + counter.get());
        else
            System.err.println("\n!!! Counter final value: " + counter.get() + "===> NOT = 0");

        System.out.println("Exiting main() Demo_WITH_Lock");
    }
}
