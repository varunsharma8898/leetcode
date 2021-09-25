import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

public class CombinationSum4 {

    // top-down approach
    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> dpMap = new HashMap<>();
        dpMap.put(0, 1);
        return helper(nums, target, dpMap);
    }

    private int helper(int[] nums, int target, Map<Integer, Integer> dpMap) {
        if (dpMap.containsKey(target)) {
            return dpMap.get(target);
        }
        int res = 0;
        for (int num : nums) {
            if (target >= num) {
                res += helper(nums, target - num, dpMap);
            }
        }
        dpMap.put(target, res);
        return res;
    }

    // bottom-up approach
    public int combinationSum4_bottomUpApproach(int[] nums, int target) {

        int[] map = new int[target + 1];
        map[0] = 1;
        for (int i = 1; i < map.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    map[i] += map[i - nums[j]];
                }
            }
        }
        return map[target];
    }

    public static void main(String[] args) {
        CombinationSum4 obj = new CombinationSum4();

        Assert.assertEquals(7, obj.combinationSum4(new int[] { 1, 2, 3 }, 4));
        Assert.assertEquals(0, obj.combinationSum4(new int[] { 9 }, 3));

        Assert.assertEquals(7, obj.combinationSum4_bottomUpApproach(new int[] { 1, 2, 3 }, 4));
        Assert.assertEquals(0, obj.combinationSum4_bottomUpApproach(new int[] { 9 }, 3));
    }
}
