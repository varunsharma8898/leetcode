import java.util.Arrays;

import org.junit.Assert;

public class LongestIncreasingSubsequence {

//    private int lengthOfLIS(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//
//        int max = 1;                                // v-imp to init as 1
//        int len = nums.length;
//        int[] dp = new int[len];
//        Arrays.fill(dp, 1);                         // v-imp to init by 1
//        for (int i = 1; i < len; i++) {                 // i from 1 to len
//            for (int j = 0; j < i; j++) {               // j from 0 to i
//                if (nums[j] < nums[i]) {                // prev num vs curr num
//                    dp[i] = Math.max(dp[i], 1 + dp[j]); // dp[j]
//                    max = Math.max(max, dp[i]);
//                }
//            }
//        }
//        return max;
//    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        Assert.assertEquals(4, lis.lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
        Assert.assertEquals(4, lis.lengthOfLIS(new int[] { 0, 1, 0, 3, 2, 3 }));
        Assert.assertEquals(1, lis.lengthOfLIS(new int[] { 7, 7, 7, 7, 7, 7, 7 }));
        Assert.assertEquals(3, lis.lengthOfLIS(new int[] { 4, 10, 4, 3, 8, 9 }));
    }

    private int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

}
