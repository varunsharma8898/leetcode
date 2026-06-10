import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

public class LCSWithChanges {

    /**
     * LCS with k replacements
     */

    // Keeping dp array out of the method so that we can reconstruct in another method
    int[][][] dp;

    private int lcsWithChanges(String s1, String s2, int k) {
        int m = s1.length(), n = s2.length();
        dp = new int[m + 1][n + 1][k + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                for (int changes = 0; changes <= k; changes++) {
                    if (i == 0 || j == 0) {
                        dp[i][j][changes] = 0;
                    } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j][changes] = 1 + dp[i - 1][j - 1][changes];
                    } else {
                        dp[i][j][changes] = Math.max(
                                Math.max(dp[i - 1][j][changes], dp[i][j - 1][changes]),
                                changes > 0 ? 1 + dp[i - 1][j - 1][changes - 1] : 0
                        );
                    }
                }
            }
        }
        return dp[m][n][k];
    }

    private List<Character> reconstructLCS(String s1, String s2, int k) {
        if (dp == null) {
            return null;
        }
        List<Character> result = new ArrayList<>();
        int i = s1.length(), j = s2.length();
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                result.add(0, s1.charAt(i - 1));
                i--;
                j--;
            } else if (k > 0 && dp[i][j][k] == dp[i - 1][j - 1][k - 1] + 1) {
                result.add(0, s1.charAt(i - 1));
                i--;
                j--;
                k--;
            } else if (dp[i][j][k] == dp[i - 1][j][k]) {
                i--;
            } else {
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LCSWithChanges lcs = new LCSWithChanges();
        Assert.assertEquals(6, lcs.lcsWithChanges("kitten", "sitting", 2));
        Assert.assertEquals("[k, i, t, t, e, n]", lcs.reconstructLCS("kitten", "sitting", 2).toString());

        Assert.assertEquals(7, lcs.lcsWithChanges("kitteng", "sitting", 2));
        Assert.assertEquals("[k, i, t, t, e, n, g]", lcs.reconstructLCS("kitteng", "sitting", 2).toString());

        Assert.assertEquals(4, lcs.lcsWithChanges("kitten", "sitting", 0));
        Assert.assertEquals("[i, t, t, n]", lcs.reconstructLCS("kitten", "sitting", 0).toString());

        Assert.assertEquals(5, lcs.lcsWithChanges("kitten", "sitting", 1));
        Assert.assertEquals("[i, t, t, e, n]", lcs.reconstructLCS("kitten", "sitting", 1).toString());

    }

    // for practice
    private int lcsWithChanges1(String s1, String s2, int changes) {
       int m = s1.length(), n = s2.length();
       int[][][] dp = new int[m+1][n+1][changes+1];
       for (int i = 0; i <= m; i++) {
           for (int j = 0; j <= n; j++) {
               for (int k = 0; k <= changes; k++) {
                   if (i == 0 || j == 0) {
                       dp[i][j][k] = 0;
                   } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                       dp[i][j][k] = 1 + dp[i - 1][j - 1][k];
                   } else {
                       dp[i][j][k] = Math.max(
                               Math.max(dp[i-1][j][k], dp[i][j-1][k]),
                               k > 0 ? 1 + dp[i-1][j-1][k-1] : 0
                       );
                   }
               }
           }
       }
       return dp[m][n][changes];
    }
//
//    private List<Character> reconstructLCS(String s1, String s2, int changes) {
//    }
}
