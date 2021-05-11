import org.junit.Assert;

public class LongestPalindromicSubsequence {

    /**
     * If you know how to find LCS, tihs problem becomes straightforward
     * Just find LCS of the original string and the reversed string.
     * */
    public int longestPalindromeSubseq(String s) {
        int m = s.length();
        String t = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[m + 1][m + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - 1][j - 1]);
                }
            }
        }

        return dp[m][m];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence obj = new LongestPalindromicSubsequence();
        Assert.assertEquals(4, obj.longestPalindromeSubseq("bbbab"));
    }
}
