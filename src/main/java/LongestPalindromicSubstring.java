import org.junit.Assert;

public class LongestPalindromicSubstring {

    private int low, maxLength;

    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        low = 0;
        maxLength = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            expandPalindrome(s, i, i);     // odd
            expandPalindrome(s, i, i + 1); // even
        }

        return s.substring(low, low + maxLength);
    }

    private void expandPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        int length = right - left - 1;
        if (maxLength < length) {
            low = left + 1;
            maxLength = length;
        }
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();

        Assert.assertEquals("", lps.longestPalindrome(""));
        Assert.assertEquals("a", lps.longestPalindrome("a"));
        Assert.assertEquals("bb", lps.longestPalindrome("bb"));
        Assert.assertEquals("bab", lps.longestPalindrome("zrsbabad"));
        Assert.assertEquals("racecar", lps.longestPalindrome("racecar"));
        Assert.assertEquals("tattarrattat", lps.longestPalindrome("tattarrattat"));
    }
}
