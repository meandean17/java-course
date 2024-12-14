// Dean Shalev 209707470
public class LockedCounter {
    private volatile int sum = 0;
    private final java.util.concurrent.locks.Lock lock = new java.util.concurrent.locks.ReentrantLock();

    public void inc() {
        lock.lock();
        try {
            sum++;
        } finally {
            lock.unlock();
        }
    }

    public void dec() {
        lock.lock();
        try {
            sum--;
        } finally {
            lock.unlock();
        }
    }

    public int get() {
        lock.lock();
        try {
            return sum;
        } finally {
            lock.unlock();
        }
    }
}