import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class H2O {

    private static final int H_COUNT = 2;

    private static final int O_COUNT = 1;

    private static final int TOTAL_COUNT = H_COUNT + O_COUNT;

    Semaphore hydSemaphore = new Semaphore(H_COUNT);

    Semaphore oxySemaphore = new Semaphore(O_COUNT);

    AtomicInteger groupCount = new AtomicInteger(0);

    H2O() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        this.hydSemaphore.acquire(1);

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();

        this.groupCount.incrementAndGet();

        resetIfNeeded();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        this.oxySemaphore.acquire(1);

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();

        this.groupCount.incrementAndGet();

        resetIfNeeded();
    }

    private void resetIfNeeded() {
        if (this.groupCount.compareAndSet(TOTAL_COUNT, 0)) {
            this.hydSemaphore.release(H_COUNT);
            this.oxySemaphore.release(O_COUNT);
        }
    }

    public static void main(String[] args) {
        String input = "OOHHHH";

        for (char c : input.toCharArray()) {
            Thread t = new Thread(() -> System.out.print(c));
            t.start();
        }
    }
}
