import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

public class RomanToInteger {

    public int romanToInt(String s) {
        Map<Character, Integer> symbols = new HashMap<>();
        symbols.put('I', 1);
        symbols.put('V', 5);
        symbols.put('X', 10);
        symbols.put('L', 50);
        symbols.put('C', 100);
        symbols.put('D', 500);
        symbols.put('M', 1000);

        int returnVal = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            char next = 0;
            if (i + 1 < s.length()) next = s.charAt(i + 1);

            // cant do a null check or char here as null char is actually stored as \0 in Java
            if (next != 0) {
                if (symbols.get(next) > symbols.get(curr)) {
                    returnVal += symbols.get(next) - symbols.get(curr);
                    i++;
                } else {
                    returnVal += symbols.get(curr);
                }
            } else {
                returnVal += symbols.get(curr);
            }
        }
        return returnVal;
    }

    public int romanToIntBruteForce(String s) {
        Map<Character, Integer> symbols = new HashMap<>();
        symbols.put('I', 1);
        symbols.put('V', 5);
        symbols.put('X', 10);
        symbols.put('L', 50);
        symbols.put('C', 100);
        symbols.put('D', 500);
        symbols.put('M', 1000);

        int returnVal = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I':
                    if (i + 1 < s.length() && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X' || s.charAt(i + 1) == 'M')) {
                        returnVal += symbols.get(s.charAt(i + 1)) - symbols.get(s.charAt(i));
                        i += 1;
                    } else {
                        returnVal += symbols.get(s.charAt(i));
                    }
                    break;
                case 'X':
                    if (i + 1 < s.length() && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
                        returnVal += symbols.get(s.charAt(i + 1)) - symbols.get(s.charAt(i));
                        i += 1;
                    } else {
                        returnVal += symbols.get(s.charAt(i));
                    }
                    break;
                case 'V':
                case 'L':
                case 'D':
                case 'M':
                    returnVal += symbols.get(s.charAt(i));
                    break;
                case 'C':
                    if (i + 1 < s.length() && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
                        returnVal += symbols.get(s.charAt(i + 1)) - symbols.get(s.charAt(i));
                        i += 1;
                    } else {
                        returnVal += symbols.get(s.charAt(i));
                    }
                    break;
            }
        }
        return returnVal;
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        Assert.assertEquals(3, romanToInteger.romanToInt("III"));
        Assert.assertEquals(4, romanToInteger.romanToInt("IV"));
        Assert.assertEquals(9, romanToInteger.romanToInt("IX"));
        Assert.assertEquals(40, romanToInteger.romanToInt("XL"));
        Assert.assertEquals(90, romanToInteger.romanToInt("XC"));
        Assert.assertEquals(400, romanToInteger.romanToInt("CD"));
        Assert.assertEquals(900, romanToInteger.romanToInt("CM"));
        Assert.assertEquals(58, romanToInteger.romanToInt("LVIII"));
        Assert.assertEquals(1994, romanToInteger.romanToInt("MCMXCIV"));
    }
}
