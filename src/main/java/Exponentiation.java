import org.junit.Assert;

public class Exponentiation {

    public double myPow(double a, int n) {
        double powa = pow(a, n);
        if (n < 0) {
            return 1 / powa;
        } else {
            return powa;
        }
    }

    private double pow(double a, int n) {
        if (n == 0) {
            return 1;
        }

        int nByTwo = n / 2;
        double powa = pow(a, nByTwo);

        if (n % 2 == 0) {
            return powa * powa;
        } else {
            return a * powa * powa;
        }
    }

    public static void main(String[] args) {
        Exponentiation expo = new Exponentiation();
        Assert.assertEquals(1024.000, expo.myPow(2.00000, 10), 0.001);
        Assert.assertEquals(0.25, expo.myPow(2.00000, -2), 0.001);
    }

}
