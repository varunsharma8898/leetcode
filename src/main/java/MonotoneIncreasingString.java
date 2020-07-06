import org.junit.Assert;

public class MonotoneIncreasingString {

    public int minFlipsMonoIncr(String S) {
        int flipCount = 0;
        int onesCount = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '0') {
                if (onesCount == 0) {
                    continue;
                }
                flipCount++;
            } else {
                onesCount++;
            }

            if (flipCount > onesCount) {
                flipCount = onesCount;
            }
        }
        return flipCount;
    }

    //  0 0 1 1 0
    //  3 2 2 2 1
    //  2 2 1 0 0
    //  2 2 2 2 1

    public static void main(String[] args) {
        MonotoneIncreasingString mis = new MonotoneIncreasingString();
        Assert.assertEquals(1, mis.minFlipsMonoIncr("00110"));
        Assert.assertEquals(2, mis.minFlipsMonoIncr("010110"));
        Assert.assertEquals(2, mis.minFlipsMonoIncr("00011000"));
        Assert.assertEquals(1, mis.minFlipsMonoIncr("00110"));
        Assert.assertEquals(3, mis.minFlipsMonoIncr("0101100011"));
    }
}
