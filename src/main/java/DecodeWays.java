import org.junit.Assert;

public class DecodeWays {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // there is only one way to decode an empty string
        dp[1] = 1; // first char is not zero, there is only one way to decode it

        for (int i = 2; i <= n; i++) {
            // single char
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i] + dp[i - 1];
            }

            // double char
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] = dp[i] + dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        DecodeWays decoder = new DecodeWays();
        Assert.assertEquals(2, decoder.numDecodings("12")); // Output: 2
        Assert.assertEquals(3, decoder.numDecodings("226")); // Output: 3
        Assert.assertEquals(0, decoder.numDecodings("06")); // Output: 0
    }
}
