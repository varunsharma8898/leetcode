import java.util.regex.Pattern;

import org.junit.Assert;

public class DetectCapital {

    /**
     * We define the usage of capitals in a word to be right when one of the following cases holds:
     * - All letters in this word are capitals, like "USA".
     * - All letters in this word are not capitals, like "leetcode".
     * - Only the first letter in this word is capital, like "Google".
     * <p>
     * Otherwise, we define that this word doesn't use capitals in a right way.
     */

    private static final Pattern[] rules = new Pattern[3];

    static {
        rules[0] = Pattern.compile("^[A-Z]+$");
        rules[1] = Pattern.compile("^[a-z]+$");
        rules[2] = Pattern.compile("^[A-Z][a-z]+$");
    }

    public boolean detectCapitalUseIntuition(String word) {
        for (Pattern rule : rules) {
            if (rule.matcher(word).matches()) {
                return true;
            }
        }
        return false;
    }

    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]*|.[a-z]*");
    }

    public static void main(String[] args) {
        DetectCapital dc = new DetectCapital();
        Assert.assertTrue(dc.detectCapitalUse("USA"));
        Assert.assertTrue(dc.detectCapitalUse("Test"));
        Assert.assertTrue(dc.detectCapitalUse("flag"));
        Assert.assertFalse(dc.detectCapitalUse("FlaG"));
    }
}
