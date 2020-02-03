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

        System.out.println("2 ** 10 => Expected: " + 1024.000 + " Got: " + expo.myPow(2.00000, 10));
        System.out.println("2 ** -2 => Expected: " + 0.25 + " Got: " + expo.myPow(2.00000, -2));
    }

}
