import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.junit.Assert;

public class KeyboardRow {

    public String[] findWords(String[] words) {

        Pattern row1 = Pattern.compile("^[qwertyuiop]*$");
        Pattern row2 = Pattern.compile("^[asdfghjkl]*$");
        Pattern row3 = Pattern.compile("^[zxcvbnm]*$");
        List<String> res = new ArrayList<>();
        for (String word : words) {
            String temp = word;
            for (Pattern p : new Pattern[] { row1, row2, row3 }) {
                if (p.matcher(temp.toLowerCase()).matches()) {
                    res.add(word);
                }
            }
        }
        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        KeyboardRow kr = new KeyboardRow();
        String[] arr = kr.findWords(new String[] { "Hello", "Alaska", "Dad", "Peace" });
        String res = Arrays.stream(arr).collect(Collectors.joining(","));
        Assert.assertEquals("Alaska,Dad", res);
    }
}
