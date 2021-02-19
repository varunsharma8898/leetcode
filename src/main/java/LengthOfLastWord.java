import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;

public class LengthOfLastWord {

    Pattern pat = Pattern.compile("\\s?(\\w+)\\s?$");
    public int lengthOfLastWord(String s) {
        Matcher matcher = pat.matcher(s);
        if (matcher.matches()) {
            String ss = matcher.group(1);
            if (ss.isEmpty()) {
                return 0;
            } else {
                return ss.length();
            }
        }
        return 0;
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
