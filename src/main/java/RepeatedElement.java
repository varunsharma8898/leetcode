import java.util.HashMap;
import java.util.Map;

public class RepeatedElement {

    public int repeatedNTimes(int[] nums) {
        int n = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) == n) {
                return num;
            }
        }
        return 0;
    }

    /**
     * https://leetcode.com/problems/n-repeated-element-in-size-2n-array
     * */
}
