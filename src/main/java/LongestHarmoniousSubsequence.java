import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

public class LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int max = 0;

        Map<Integer, Integer> integerMap = new HashMap<>();

        for (int num : nums) {
            integerMap.put(num, integerMap.getOrDefault(num, 0) + 1);

            if (integerMap.containsKey(num - 1)) {
                max = Math.max(integerMap.get(num) + integerMap.get(num - 1), max);
            }
            if (integerMap.containsKey(num + 1)) {
                max = Math.max(integerMap.get(num) + integerMap.get(num + 1), max);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        LongestHarmoniousSubsequence obj = new LongestHarmoniousSubsequence();
        Assert.assertEquals(0, obj.findLHS(null));
        Assert.assertEquals(0, obj.findLHS(new int[] { }));
        Assert.assertEquals(5, obj.findLHS(new int[] { 1, 3, 2, 2, 5, 2, 3, 7 }));
        Assert.assertEquals(2, obj.findLHS(new int[] { 1, 2, 3, 4 }));
        Assert.assertEquals(0, obj.findLHS(new int[] { 1, 1, 1, 1 }));
    }

}
