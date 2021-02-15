import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;

public class HappyNumbers {

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int i = n % 10;
            sum += i * i;
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        HappyNumbers hn = new HappyNumbers();
        Assert.assertTrue(hn.isHappy(19));
//        Assert.assertTrue(hn.isHappy(91));
        Assert.assertFalse(hn.isHappy(2));
    }
}
