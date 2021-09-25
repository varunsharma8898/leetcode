import java.util.HashSet;

import org.junit.Assert;

public class StringContainsAllBinCodes {

    public boolean hasAllCodes(String s, int k) {
        if (k > s.length()) {
            return false;
        }
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            set.add(s.substring(i, i + k));
        }

        return set.size() == Math.pow(2, k);
    }

    public boolean hasAllCodes_TimeLimitExceeded(String s, int k) {
        if (k > s.length()) {
            return false;
        }
        int allPossibleNums = (int) Math.pow(2, k);
        for (int i = 0; i < allPossibleNums; i++) {
            String str = Integer.toBinaryString(i) + "";
            str = String.format("%" + k + "s", str).replace(' ', '0');

            if (s.contains(str)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        StringContainsAllBinCodes obj = new StringContainsAllBinCodes();
        Assert.assertTrue(obj.hasAllCodes("00110110", 2));
        Assert.assertTrue(obj.hasAllCodes("00110", 2));
        Assert.assertTrue(obj.hasAllCodes("0110", 1));
        Assert.assertFalse(obj.hasAllCodes("0110", 2));
        Assert.assertFalse(obj.hasAllCodes("0000000001011100", 4));
    }
}
