import java.util.Arrays;

import org.junit.Assert;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    public boolean isAnagramUsingMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];             // use a hashmap if unicode chars are involved
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram va = new ValidAnagram();
        Assert.assertTrue(va.isAnagram("anagram", "nagaram"));
        Assert.assertTrue(va.isAnagramUsingMap("anagram", "nagaram"));
    }

}
