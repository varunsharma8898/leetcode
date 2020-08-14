import org.junit.Assert;

public class ThreeConsecutiveOdds {

    public boolean threeConsecutiveOdds(int[] arr) {

        if (arr == null || arr.length < 3) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                count = 0;
            } else if (++count == 3) {
                return true;
            }
        }
        return false;
    }

    /**
     * https://leetcode.com/problems/three-consecutive-odds/
     */
    public static void main(String[] args) {
        ThreeConsecutiveOdds obj = new ThreeConsecutiveOdds();
        Assert.assertFalse(obj.threeConsecutiveOdds(null));
        Assert.assertFalse(obj.threeConsecutiveOdds(new int[] { }));
        Assert.assertFalse(obj.threeConsecutiveOdds(new int[] { 2, 6, 4, 1 }));
        Assert.assertTrue(obj.threeConsecutiveOdds(new int[] { 1, 2, 34, 3, 4, 5, 7, 23, 12 }));
    }

}
