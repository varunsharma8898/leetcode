import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;

public class PowerOfThree {

    public boolean isPowerOfThree(int n) {

        if (n <= 0) return false;

        while (n % 3 == 0) {
            n = n / 3;
        }

        return n == 1;
    }

    // cheating method - but works well for all sorts of power-of related problems
    public boolean isPowerOfThree_alternateApproach(int n) {

        Set<Integer> set = new HashSet<>(Arrays.asList(1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683,
                59049, 177147, 531441, 1594323, 4782969, 14348907, 43046721, 129140163, 387420489, 1162261467));
//        int x  = 3;
//        for  (int i = 0; i < 19; i++) {
//            System.out.println(i + " - " + x);
//            x = x * 3;
//        }

        return set.contains(n);
    }

    public static void main(String[] args) {
        PowerOfThree pot = new PowerOfThree();
        Assert.assertFalse(pot.isPowerOfThree(0));
        Assert.assertTrue(pot.isPowerOfThree(1));
        Assert.assertTrue(pot.isPowerOfThree(27));
        Assert.assertTrue(pot.isPowerOfThree(1162261467));

        Assert.assertFalse(pot.isPowerOfThree_alternateApproach(0));
        Assert.assertTrue(pot.isPowerOfThree_alternateApproach(1));
        Assert.assertTrue(pot.isPowerOfThree_alternateApproach(27));
        Assert.assertTrue(pot.isPowerOfThree_alternateApproach(1162261467));
    }
}
