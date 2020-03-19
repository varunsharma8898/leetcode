import org.junit.Assert;

public class HouseRobber {

    public int rob(int[] nums) {

        int prev1 = 0, prev2 = 0;
        for (int num : nums) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;
    }

    public static void main(String[] args) {
        HouseRobber hr = new HouseRobber();
        Assert.assertEquals(4, hr.rob(new int[] { 1, 2, 3, 1 }));
        Assert.assertEquals(12, hr.rob(new int[] { 2, 7, 9, 3, 1 }));
    }
}
