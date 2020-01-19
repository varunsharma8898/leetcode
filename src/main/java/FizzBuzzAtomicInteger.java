import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class FizzBuzzAtomicInteger {

    private int n;

    private AtomicInteger counter = new AtomicInteger(1);

    FizzBuzzAtomicInteger(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            int i = counter.get();
            if (i > n) return;
            if (i % 3 == 0 && i % 5 != 0) {
                printFizz.run();
                counter.incrementAndGet();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            int i = counter.get();
            if (i > n) return;
            if (i % 3 != 0 && i % 5 == 0) {
                printBuzz.run();
                counter.incrementAndGet();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            int i = counter.get();
            if (i > n) return;
            if (i % 3 == 0 && i % 5 == 0) {
                printFizzBuzz.run();
                counter.incrementAndGet();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            int i = counter.get();
            if (i > n) return;
            if (i % 3 != 0 && i % 5 != 0) {
                printNumber.accept(i);
                counter.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) {

        final FizzBuzz fizzBuzz = new FizzBuzz(15);
        Thread t1 = new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> System.out.println("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> System.out.println("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.println("fizzbuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t4 = new Thread(() -> {
            try {
                fizzBuzz.number(a -> System.out.println(a));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
