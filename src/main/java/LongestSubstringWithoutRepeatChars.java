import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;

public class LongestSubstringWithoutRepeatChars {

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        Set<Character> slidingWindow = new HashSet<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            while (slidingWindow.contains(s.charAt(right))) {
                slidingWindow.remove(s.charAt(left++));
            }

            slidingWindow.add(s.charAt(right++));
            result = Math.max(result, right - left);
        }

        return result;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatChars obj = new LongestSubstringWithoutRepeatChars();
        Assert.assertEquals(3, obj.lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(1, obj.lengthOfLongestSubstring("bbbbb"));
        Assert.assertEquals(3, obj.lengthOfLongestSubstring("pwwkew"));
    }
}
