import org.junit.Assert;

public class LongestPalindromicSubstring {

    private int low, maxLength;

    public String longestPalindrome(String s) {

        String longestSubstring = "";
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            int oddLength = isPalindrome(s, i, i);
            int evenLength = isPalindrome(s, i, i + 1);

            if (maxLength < oddLength) {
                maxLength = oddLength;
                int movePositions = oddLength / 2;
                longestSubstring = s.substring(i - movePositions, i + movePositions + 1);
            }
            if (maxLength < evenLength) {
                maxLength = evenLength;
                int movePositions = evenLength / 2;
                longestSubstring = s.substring(i - movePositions + 1, i + movePositions + 1);
            }
        }

        return longestSubstring;
    }

    private int isPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
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
