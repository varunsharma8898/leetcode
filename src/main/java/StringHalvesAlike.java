import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;

public class StringHalvesAlike {

    public boolean halvesAreAlike(String s) {
        String s1 = s.substring(0, s.length() / 2);
        String s2 = s.substring(s.length() / 2);
        int sum = 0;
        for (char c : s1.toCharArray()) {
            if (c == 'a' || c == 'A'
                    || c == 'e' || c == 'E'
                    || c == 'i' || c == 'I'
                    || c == 'i' || c == 'O'
                    || c == 'u' || c == 'U'
            ) {
                sum++;
            }
        }

        for (char c : s2.toCharArray()) {
            if (c == 'a' || c == 'A'
                    || c == 'e' || c == 'E'
                    || c == 'i' || c == 'I'
                    || c == 'i' || c == 'O'
                    || c == 'u' || c == 'U'
            ) {
                sum--;
            }
        }
        return sum == 0;
    }

    public boolean halvesAreAlike_intuition(String s) {

        String s1 = s.substring(0, s.length() / 2);
        String s2 = s.substring(s.length() / 2);

        s1 = s1.replaceAll("[^aeiouAEIOU]", "");
        s2 = s2.replaceAll("[^aeiouAEIOU]", "");

        return s1.length() == s2.length();
    }

    public static void main(String[] args) {
        StringHalvesAlike obj = new StringHalvesAlike();
        Assert.assertTrue(obj.halvesAreAlike("book"));
        Assert.assertTrue(obj.halvesAreAlike("AbCdEfGh"));
        Assert.assertFalse(obj.halvesAreAlike("textbook"));
        Assert.assertFalse(obj.halvesAreAlike("MerryChristmas"));

        Assert.assertTrue(obj.halvesAreAlike_intuition("book"));
        Assert.assertTrue(obj.halvesAreAlike_intuition("AbCdEfGh"));
        Assert.assertFalse(obj.halvesAreAlike_intuition("textbook"));
        Assert.assertFalse(obj.halvesAreAlike_intuition("MerryChristmas"));
    }
}
