import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

public class LongestPalindrome {

    public int longestPalindrome(String s) {

        int count = 0;
        Map<Character, Integer> myMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (myMap.containsKey(c)) {
                int cnt = myMap.get(c);
                if (cnt == 1) {
                    count += 2;
                    myMap.remove(c);
                } else {
                    myMap.put(c, cnt + 1);
                }
            } else {
                myMap.put(c, 1);
            }
        }
        if (myMap.size() > 0 && count > 0) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        Assert.assertEquals(0, lp.longestPalindrome("abcd"));
        Assert.assertEquals(7, lp.longestPalindrome("abccccdd"));
    }

    /**
     * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
     *
     * This is case sensitive, for example "Aa" is not considered a palindrome here.
     *
     * Note:
     * Assume the length of given string will not exceed 1,010.
     *
     * */
}
