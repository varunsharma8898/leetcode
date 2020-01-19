import java.util.function.IntConsumer;

public class FizzBuzz {

    private int n;

    private volatile int counter = 1;

    FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {

        while (counter > 0 && counter <= n) {
            if (counter % 3 == 0 && counter % 5 != 0) {
                printFizz.run();
                counter++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while (counter > 0 && counter <= n) {
            if (counter % 3 != 0 && counter % 5 == 0) {
                printBuzz.run();
                counter++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (counter > 0 && counter <= n) {
            if (counter % 3 == 0 && counter % 5 == 0) {
                printFizzBuzz.run();
                counter++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while (counter > 0 && counter <= n) {
            if (counter % 3 != 0 && counter % 5 != 0) {
                printNumber.accept(counter);
                counter++;
                notifyAll();
            } else {
                wait();
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
