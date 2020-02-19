import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

public class AlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        char start = 'a';
        Map<Character, Character> orderMap = new HashMap();
        for (Character c : order.toCharArray()) {
            orderMap.put(c, start++);
        }

        String[] converted = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            converted[i] = convertWord(words[i], orderMap);
            if (i < 1) {
                continue;
            }
            if (converted[i - 1].compareTo(converted[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    private String convertWord(String word, Map<Character, Character> orderMap) {
        char[] chars = new char[word.length()];
        int i = 0;
        for (char c : word.toCharArray()) {
            chars[i++] = orderMap.get(c);
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        AlienDictionary dictionary = new AlienDictionary();

        Assert.assertTrue(dictionary.isAlienSorted(new String[] { "hello", "leetcode" }, "hlabcdefgijkmnopqrstuvwxyz"));
        Assert.assertFalse(dictionary.isAlienSorted(new String[] { "word", "world",
                "row" }, "worldabcefghijkmnpqstuvxyz"));
        Assert.assertFalse(dictionary.isAlienSorted(new String[] { "apple", "app" }, "abcdefghijklmnopqrstuvwxyz"));
    }


/*
    Example 1:

    Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
    Output: true
    Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.

            Example 2:

    Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
    Output: false
    Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.

            Example 3:

    Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
    Output: false
    Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
*/
}
