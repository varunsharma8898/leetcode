import java.util.Arrays;

import org.junit.Assert;

public class HouseRobber2 {

    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        return Math.max(helper(nums, 0, len - 2), helper(nums, 1, nums.length - 1));
    }

    private int helper(int[] nums, int start, int end) {
        int prev1 = 0, prev2 = 0;
        for (int i = start; i <= end; i++) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + nums[i], prev1);
            prev2 = tmp;
        }
        return prev1;
    }

    public int robRecursively(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        int[] robFromFirst = new int[len];
        int[] robFromSecond = new int[len];
        Arrays.fill(robFromFirst, -1);
        Arrays.fill(robFromSecond, -1);
        return Math.max(robRecursively(nums, 0, len - 1, robFromFirst), robRecursively(nums, 1, len, robFromSecond));
    }

    private int robRecursively(int[] nums, int curr, int length, int[] robbed) {
        if (curr >= length) {
            return 0;
        }
        if (robbed[curr] >= 0) {
            return robbed[curr];
        }

        robbed[curr] = Math.max(robRecursively(nums, curr + 2, length, robbed) + nums[curr], robRecursively(nums, curr + 1, length, robbed));
        return robbed[curr];
    }

    public static void main(String[] args) {
        HouseRobber2 hr = new HouseRobber2();
        Assert.assertEquals(3, hr.rob(new int[] { 2, 3, 2 }));
        Assert.assertEquals(4, hr.rob(new int[] { 1, 2, 3, 1 }));

        Assert.assertEquals(3, hr.robRecursively(new int[] { 2, 3, 2 }));
        Assert.assertEquals(4, hr.robRecursively(new int[] { 1, 2, 3, 1 }));
    }

}
