import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

public class LetterCombinationPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        StringBuilder builder = new StringBuilder();
        String[] mappings = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        dfs(digits, 0, result, builder, mappings);

        return result;
    }

    private void dfs(String digits, int position, List<String> result, StringBuilder builder, String[] mappings) {
        if (position == digits.length()) {
            result.add(builder.toString());
            return;
        }

        String letters = mappings[digits.charAt(position) - '0'];
        for (char c : letters.toCharArray()) {
            builder.append(c);
            dfs(digits, position + 1, result, builder, mappings);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationPhoneNumber lc = new LetterCombinationPhoneNumber();
        List<String> result = lc.letterCombinations("23");
        Assert.assertArrayEquals(new String[] { "ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf" }, result.toArray());
    }


    /*
     *
     * Input: "23"
     * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * */

}
