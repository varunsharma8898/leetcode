import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Assert;

public class BuddyStrings {

    public boolean buddyStrings(String s, String goal) {
        if (s == null || s.length() < 2 || s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            HashSet<Character> set1 = new HashSet<>();
            for (char c : s.toCharArray()) {
                set1.add(c);
            }
            return set1.size() < s.length();
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                list.add(i);
            }
        }

        return list.size() == 2
                && s.charAt(list.get(0)) == goal.charAt(list.get(1))
                && s.charAt(list.get(1)) == goal.charAt(list.get(0));
    }

    public static void main(String[] args) {
        BuddyStrings bs = new BuddyStrings();
        Assert.assertTrue(bs.buddyStrings("ab", "ba"));
        Assert.assertTrue(bs.buddyStrings("aa", "aa"));
        Assert.assertFalse(bs.buddyStrings("ab", "ab"));
    }
}
