import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int best = 0;
        for (int x : nums) {
            if (numSet.contains(x - 1)) {
                continue;
            } else {
                int y = x + 1;
                while (numSet.contains(y)) {
                    y++;
                }
                best = Math.max(best, y - x);
            }
        }
        return best;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        Assert.assertEquals(4, lcs.longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
        Assert.assertEquals(9, lcs.longestConsecutive(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }));
    }
}
