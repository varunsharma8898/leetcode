import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

public class ThreeSumWithMultiplicity {

    public int threeSumMulti(int[] arr, int target) {
        long ans = 0l;

        Map<Integer, Long> freqMap = new HashMap<>();

        for (int i : arr) {
            Long freq = freqMap.getOrDefault(i, 0l);
            freqMap.put(i, freq + 1l);
        }

        // Selecting r combinations from n items: nCr =  n! / (r! * (n-r)!)
        for (int i : freqMap.keySet()) {
            for (int j : freqMap.keySet()) {
                int k = target - i - j;
                if (freqMap.containsKey(k)) {
                    Long f1 = freqMap.get(i);
                    Long f2 = freqMap.get(j);
                    Long f3 = freqMap.get(k);

                    if (i == j && j == k) {
                        ans += f1 * (f1 - 1) * (f1 - 2) / 6;
                    } else if (i == j && j != k) {
                        ans += (f1 * (f1 - 1) / 2) * f3;
                    } else if (i < j && j < k) {
                        ans += f1 * f2 * f3;
                    }
                }
                ans = ans % 1000000007;
            }
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        ThreeSumWithMultiplicity obj = new ThreeSumWithMultiplicity();
        Assert.assertEquals(20, obj.threeSumMulti(new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 }, 8));
        Assert.assertEquals(12, obj.threeSumMulti(new int[] { 1, 1, 2, 2, 2, 2 }, 5));
    }
}
