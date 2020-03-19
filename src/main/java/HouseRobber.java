import java.util.Arrays;

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

    public int robRecursively(int[] nums) {
        int[] robbed = new int[nums.length + 1];
        Arrays.fill(robbed, -1);
        return robRecursively(nums, nums.length - 1, robbed);
    }

    private int robRecursively(int[] nums, int i, int[] robbed) {
        if (i < 0) {
            return 0;
        }
        if (robbed[i] >= 0) {
            return robbed[i];
        }
        robbed[i] = Math.max(robRecursively(nums, i - 2, robbed) + nums[i], robRecursively(nums, i - 1, robbed));
        return robbed[i];
    }

    public static void main(String[] args) {
        HouseRobber hr = new HouseRobber();
        Assert.assertEquals(4, hr.rob(new int[] { 1, 2, 3, 1 }));
        Assert.assertEquals(12, hr.rob(new int[] { 2, 7, 9, 3, 1 }));
        Assert.assertEquals(4, hr.robRecursively(new int[] { 1, 2, 3, 1 }));
        Assert.assertEquals(12, hr.robRecursively(new int[] { 2, 7, 9, 3, 1 }));
    }
}
