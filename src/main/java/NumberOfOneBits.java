import org.junit.Assert;

public class NumberOfOneBits {

    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    /**
     * https://leetcode.com/problems/number-of-1-bits/solution/
     * */
    public int hammingWeight2(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        NumberOfOneBits obj = new NumberOfOneBits();

        Assert.assertEquals(3, obj.hammingWeight(11));
        Assert.assertEquals(31, obj.hammingWeight(-3));

        Assert.assertEquals(3, obj.hammingWeight2(11));
        Assert.assertEquals(31, obj.hammingWeight2(-3));
    }
}
