import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void helper(String s, int start, ArrayList<String> currPath, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(currPath));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                currPath.add(s.substring(start, i + 1));
                helper(s, i + 1, currPath, res);
                currPath.remove(currPath.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning pp = new PalindromePartitioning();
        Assert.assertEquals("[[a, a, b], [aa, b]]", pp.partition("aab").toString());
        Assert.assertEquals("[[a]]", pp.partition("a").toString());
    }

}
