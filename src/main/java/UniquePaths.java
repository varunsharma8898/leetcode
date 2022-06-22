import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        Map<String, Integer> memoMap = new HashMap<>();
        return helper(m, n, memoMap);
    }

    private int helper(int m, int n, Map<String, Integer> memoMap) { // since using memoization: O(m*n) time, without memo O(2^(m+n)) time
        String key = m + "-" + n;
        if (memoMap.containsKey(key))  return memoMap.get(key);
        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;

        int val = helper(m - 1, n, memoMap) + helper(m, n - 1, memoMap);
        memoMap.put(key, val);
        return val;
    }

    public int uniquePathsDP(int m, int n) { // O(m*n)
        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = 1;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i+1 <= m) dp[i+1][j] += dp[i][j];
                if (j+1 <= n) dp[i][j+1] += dp[i][j];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        UniquePaths up = new UniquePaths();
        Assert.assertEquals(28, up.uniquePaths(3, 7));
        Assert.assertEquals(28, up.uniquePathsDP(3, 7));
    }
}
