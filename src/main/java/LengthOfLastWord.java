import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;

public class LengthOfLastWord {

    Pattern pat = Pattern.compile("\\s?(\\w+)\\s?$");
    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (count > 0) return count;
            } else {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LengthOfLastWord obj = new LengthOfLastWord();
        Assert.assertEquals(0, obj.lengthOfLastWord(""));
        Assert.assertEquals(5, obj.lengthOfLastWord("Hello"));
        Assert.assertEquals(5, obj.lengthOfLastWord("Hello a s d World"));
        Assert.assertEquals(5, obj.lengthOfLastWord("Hello World"));
        Assert.assertEquals(5, obj.lengthOfLastWord("Hello     World"));
        Assert.assertEquals(10, obj.lengthOfLastWord("HelloWorldHelloWorldHelloWorldHelloWorldHelloWorldHelloWorldHelloWorld HelloWorld"));
    }
}
