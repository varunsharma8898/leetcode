import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

public class MajorityElementInArray {

    private int majorityElement(int[] arr) {
        int len = arr.length;
        if (len == 1) {
            return arr[0];
        }

        int count = 1;
        Arrays.sort(arr);
        for (int i = 1; i < len; i++) {
            if (arr[i - 1] == arr[i]) {
                count++;
            } else {
                if (count > len / 2) {
                    return arr[i - 1];
                }
                count = 1;
            }
        }
        if (count > len / 2) {
            return arr[len - 1];
        }

        return -1;
    }

    private int majorityElement_optimal(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int element : arr) {
            map.put(element, map.getOrDefault(element, 0) + 1);

            if (map.get(element) > n / 2) {
                return element;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MajorityElementInArray obj = new MajorityElementInArray();
        Assert.assertEquals(1, obj.majorityElement(new int[] { 1, 2, 3, 1, 1, 4, 1 }));
        Assert.assertEquals(1, obj.majorityElement_optimal(new int[] { 1, 2, 3, 1, 1, 4, 1 }));
    }

}
