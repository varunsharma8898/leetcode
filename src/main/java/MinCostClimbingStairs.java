public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int N = cost.length;
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            if (i < 2) {
                dp[i] = cost[i];
            } else {
                dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
            }
        }
        return Math.min(dp[N - 1], dp[N - 2]);
    }

    public int minCostClimbingStairs_refactored(int[] cost) {
        int n = cost.length;
        int first = cost[0];
        int second = cost[1];

        if (n <= 2) {
            return Math.min(first, second);
        }
        for (int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(first, second);
            first = second;
            second = curr;
        }
        return Math.min(first, second);
    }
}
