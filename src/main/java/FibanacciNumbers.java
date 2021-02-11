import org.junit.Assert;

public class FibanacciNumbers {

    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        int[] map = new int[n+1];
        map[0] = 0;
        map[1] = 1;
        for (int i = 2; i <= n; i++) {
            map[i] = map[i-1] + map[i-2];
        }
        return map[n];
    }

    public static void main(String[] args) {
        FibanacciNumbers fib = new FibanacciNumbers();
        Assert.assertEquals(3, fib.fib(4));
        Assert.assertEquals(1, fib.fib(1));
        Assert.assertEquals(0, fib.fib(0));
    }
}
