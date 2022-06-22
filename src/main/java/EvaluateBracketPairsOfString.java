import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

public class EvaluateBracketPairsOfString {

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> dict = new HashMap<>();
        for (List<String> list : knowledge) {
            dict.put(list.get(0), list.get(1));
        }

        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == '(') {
                i++;
                StringBuilder keySB = new StringBuilder();
                while (i < s.length() && s.charAt(i) != ')') {
                    keySB.append(s.charAt(i++));
                }
                String key = keySB.toString();
                sb.append(dict.containsKey(key) ? dict.get(key) : '?');
                i++;
                continue;
            }

            sb.append(s.charAt(i));
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        EvaluateBracketPairsOfString obj = new EvaluateBracketPairsOfString();
        List<List<String>> knowledge = new ArrayList<>();
        knowledge.add(Arrays.asList(new String[] { "name", "bob" }));
        knowledge.add(Arrays.asList(new String[] { "age", "two" }));
        Assert.assertEquals("bobistwoyearsold", obj.evaluate("(name)is(age)yearsold", knowledge));
        Assert.assertEquals("hi?", obj.evaluate("hi(varun)", knowledge));
    }
}
