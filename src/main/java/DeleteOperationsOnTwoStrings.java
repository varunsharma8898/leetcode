import org.junit.Assert;

public class DeleteOperationsOnTwoStrings {

    /**
     * This is another LCS problem.
     * Find out LCS of two strings and then subtract LCS value
     * from both strings
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - 1][j - 1]);
                }
            }
        }
        return m + n - 2 * dp[m][n];
    }

    public static void main(String[] args) {
        DeleteOperationsOnTwoStrings obj = new DeleteOperationsOnTwoStrings();
        Assert.assertEquals(2, obj.minDistance("sea", "eat"));
    }
}
