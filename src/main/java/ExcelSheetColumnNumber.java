import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

public class ExcelSheetColumnNumber {

    public int titleToNumberBruteForce(String s) {
        char c = 'A';
        Map<Character, Integer> map = new HashMap();
        for (int i = 1; i <= 26; i++) {
            map.put(c++, i);
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += Math.pow(26, i) * map.get(s.charAt(s.length() - 1 - i));
        }
        return res;
    }

    public int titleToNumberUpdated(String s) {
        int res = 0;
        for (int i = s.length() - 1, j = 0; i >= 0; i--) {
            res += Math.pow(26, j++) * (s.charAt(i) - 'A' + 1);
        }
        return res;
    }

    public int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 26 + (s.charAt(i) - 'A' + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber obj = new ExcelSheetColumnNumber();
        Assert.assertEquals(1, obj.titleToNumber("A"));
        Assert.assertEquals(28, obj.titleToNumber("AB"));
        Assert.assertEquals(701, obj.titleToNumber("ZY"));
//        Assert.assertEquals(1, obj.titleToNumber("A"));
//        Assert.assertEquals(1, obj.titleToNumber("A"));

    }
}
