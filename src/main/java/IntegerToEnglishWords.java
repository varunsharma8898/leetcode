import org.junit.Assert;

public class IntegerToEnglishWords {

    private static final String[] SPECIALS = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };

    private static final String[] TENS = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

    private static final String[] THOUSANDS = { "", "Thousand", "Million", "Billion" };

    public String numberToWords(int num) {

        if (num == 0) return "Zero";
        String res = "";
        int index = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                res = helper(num % 1000) + THOUSANDS[index] + " " + res;
            }
            index++;
            num /= 1000;
        }
        return res.trim();
    }

    private String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return SPECIALS[num] + " ";
        } else if (num < 100) {
            return TENS[num / 10] + " " + helper(num % 10);
        } else {
            return SPECIALS[num / 100] + " Hundred " + helper(num % 100);
        }
    }

    public static void main(String[] args) {
        IntegerToEnglishWords itew = new IntegerToEnglishWords();
        Assert.assertEquals("One Million", itew.numberToWords(1000000));
        Assert.assertEquals("One Hundred Twenty Three", itew.numberToWords(123));
        Assert.assertEquals("Twelve Thousand Three Hundred Forty Five", itew.numberToWords(12345));
        Assert.assertEquals("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven", itew.numberToWords(1234567));
        Assert.assertEquals("One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One",
                itew.numberToWords(1234567891));
    }

}
