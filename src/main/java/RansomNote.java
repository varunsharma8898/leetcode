import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.standard.RequestingUserName;

import org.junit.Assert;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for (char c : magazine.toCharArray()) {
            map[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (map[c - 'a'] == 0) return false;
            map[c - 'a']--;
        }
        return true;
    }

    public static void main(String[] args) {
        RansomNote rn = new RansomNote();
        Assert.assertTrue(rn.canConstruct("aa", "aab"));
    }
}
