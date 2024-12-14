public class Counter {
    private volatile int sum = 0;

    public void inc() {
        sum++;
    }

    public void dec() {
        sum--;
    }

    public int get() {
        return sum;
    }
}