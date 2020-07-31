import org.junit.Assert;

public class ValidPalindrome {

    public boolean isPalindromeIntuitive(String s) {

        if (s == null) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }

        String str = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        int len = str.length();
        int mid = len / 2;
        int left = mid;
        int right = mid;
        if (len % 2 == 0) {
            left = mid - 1;
        }
        while (left >= 0 && right < len && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }

        int maxLen = right - left - 1;

        return maxLen == len;
    }

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }

        String str = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        int len = str.length() - 1;
        int end = len;
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) == str.charAt(len)) {
                end--;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        Assert.assertTrue(vp.isPalindrome(""));
        Assert.assertTrue(vp.isPalindrome("ab_a"));
        Assert.assertTrue(vp.isPalindrome("racecar"));
        Assert.assertTrue(vp.isPalindrome("tattarrattat"));
        Assert.assertTrue(vp.isPalindrome("A man, a plan, a canal: Panama"));
        Assert.assertFalse(vp.isPalindrome(null));
        Assert.assertFalse(vp.isPalindrome("race a car"));
        Assert.assertFalse(vp.isPalindrome("aabbac"));
    }
}
