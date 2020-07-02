import org.junit.Assert;

public class IntegerToRoman {

    public String intToRoman(int num) {
        int[] romans = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        int i = 0;
        StringBuilder builder = new StringBuilder();
        while (num > 0) {
            if (num >= romans[i]) {
                builder.append(symbols[i]);
                num -= romans[i];
            } else {
                i++;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        Assert.assertEquals("III", integerToRoman.intToRoman(3));
        Assert.assertEquals("IV", integerToRoman.intToRoman(4));
        Assert.assertEquals("IX", integerToRoman.intToRoman(9));
        Assert.assertEquals("XL", integerToRoman.intToRoman(40));
        Assert.assertEquals("XC", integerToRoman.intToRoman(90));
        Assert.assertEquals("CD", integerToRoman.intToRoman(400));
        Assert.assertEquals("CM", integerToRoman.intToRoman(900));
        Assert.assertEquals("LVIII", integerToRoman.intToRoman(58));
        Assert.assertEquals("MCMXCIV", integerToRoman.intToRoman(1994));
    }
}
