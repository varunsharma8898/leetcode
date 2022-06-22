public class ClimbingStairs {

    /**
     * Explaination: This is a fibonacci sequence
     * <p>
     * 1 step can be reached in 1 way (1)
     * 2 steps can be in 2 ways (1,1 and 2)
     * 3 in 3. (1,1,1 - 1,2 - 2,1)
     * So far so good.
     * 4 in 5 ways (1,1,1,1 - 1,1,2 - 1,2,1 - 2,1,1 - 2,2)
     * 5 in 8 ways (11111 - 1112 - 1121 - 1211 - 2111 - 122 - 212 - 221)
     * <p>
     * If you pay attention, the pattern here is similar to fibonacci numbers
     * that is, add prev two entries to get current ans
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}
