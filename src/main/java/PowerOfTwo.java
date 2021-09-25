import org.junit.Assert;

public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) {
            n = n / 2;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        PowerOfTwo pot = new PowerOfTwo();
        Assert.assertTrue(pot.isPowerOfTwo(1));
        Assert.assertTrue(pot.isPowerOfTwo(4));
        Assert.assertTrue(pot.isPowerOfTwo(16));
        Assert.assertFalse(pot.isPowerOfTwo(0));
        Assert.assertFalse(pot.isPowerOfTwo(3));
        Assert.assertFalse(pot.isPowerOfTwo(5));
    }
}
