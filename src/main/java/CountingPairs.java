import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

public class CountingPairs {

    public static void main(String[] args) {
        CountingPairs cp = new CountingPairs();
        Assert.assertEquals(1, cp.countPairs(new int[] { 1, 1, 1, 2 }, 1));
        Assert.assertEquals(0, cp.countPairs(new int[] { 1, 2 }, 2));
    }

    private int countPairs(int[] ints, int diff) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : ints) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : map.keySet()) {
            if (map.containsKey(num + diff)) {
                ans += 1;
            }
        }
        return ans;
    }

}
