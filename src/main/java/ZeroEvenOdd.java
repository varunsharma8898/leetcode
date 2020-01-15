import java.util.function.IntConsumer;

public class ZeroEvenOdd {

    private int n;

    private volatile boolean zero = true, even = false, odd = false;

    private static final Object lock = new Object();

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

        synchronized (lock) {

            for (int i = 1; i <= n; i++) {

                while (!zero) {
                    lock.wait();
                }
                if (i % 2 == 0) {
                    even = true;
                }
                if (i % 2 != 0) {
                    odd = true;
                }
                zero = false;
                if (i <= n) {
                    printNumber.accept(0);
                }
                lock.notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        synchronized (lock) {
            for (int i = 2; i <= n; i = i + 2) {
                while (!even) {
                    lock.wait();
                }
                printNumber.accept(i);
                zero = true;
                even = false;
                lock.notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        synchronized (lock) {
            for (int i = 1; i <= n; i = i + 2) {
                while (!odd) {
                    lock.wait();
                }
                printNumber.accept(i);
                zero = true;
                odd = false;
                lock.notifyAll();
            }
        }
    }

    public static void main(String args[]) {

//        // Leaving these as comments here to understand IntConsumer
//        IntConsumer zeroPrinter = new IntConsumer() {
//            @Override
//            public void accept(int i) {
//                System.out.print(i);
//            }
//        };
//        IntConsumer evenPrinter = a -> System.out.print(a);
//        IntConsumer oddPrinter = a -> System.out.print(a);
        ZeroEvenOdd zeo = new ZeroEvenOdd(9);
        Thread t1 = new Thread(() -> {
            try {
                zeo.zero(a -> System.out.print(a));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                zeo.even(a -> System.out.print(a));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                zeo.odd(a -> System.out.print(a));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
