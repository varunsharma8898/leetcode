import java.util.HashSet;

import org.junit.Assert;

public class DistributeCandies {

    public int distributeCandies(int[] candyType) {

        if (candyType == null || candyType.length < 2) {
            return candyType.length;
        }

        int halfLen = candyType.length / 2;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : candyType) {
            hashSet.add(i);
        }

        if (hashSet.size() > halfLen) {
            return halfLen;
        } else {
            return hashSet.size();
        }
    }

    public static void main(String[] args) {
        DistributeCandies dc = new DistributeCandies();
        Assert.assertEquals(3, dc.distributeCandies(new int[] { 1, 1, 2, 2, 3, 3 }));
        Assert.assertEquals(2, dc.distributeCandies(new int[] { 1, 1, 2, 3 }));
        Assert.assertEquals(1, dc.distributeCandies(new int[] { 6, 6, 6, 6 }));
    }

}
