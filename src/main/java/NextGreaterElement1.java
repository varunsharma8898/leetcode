import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Assert;

public class NextGreaterElement1 {

    // starting from last element of nums2 till first one
    public int[] nextGreaterElementDecreasingLoop(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = nums2.length - 1;

        Stack<Integer> stack = new Stack<>();
        while (i >= 0) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
            i--;
        }

        for (int j = 0; j < nums1.length; j++) {
            nums1[j] = map.getOrDefault(nums1[j], -1);
        }
        return nums1;
    }

    // starting the loop from first element
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        for (int j = 0; j < nums1.length; j++) {
            nums1[j] = map.getOrDefault(nums1[j], -1);
        }
        return nums1;
    }

    public static void main(String[] args) {
        NextGreaterElement1 nge = new NextGreaterElement1();
        Assert.assertArrayEquals(new int[] { -1, 3, -1 },
                nge.nextGreaterElement(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 }));
        Assert.assertArrayEquals(new int[] { 3, -1 },
                nge.nextGreaterElement(new int[] { 2, 4 }, new int[] { 1, 2, 3, 4 }));
        Assert.assertArrayEquals(new int[] { },
                nge.nextGreaterElement(new int[] { }, new int[] { 1, 2, 3, 4 }));

        Assert.assertArrayEquals(new int[] { 7, 7, 7, 7, 7 },
                nge.nextGreaterElement(new int[] { 1, 3, 5, 2, 4 }, new int[] { 6, 5, 4, 3, 2, 1, 7 }));

        Assert.assertArrayEquals(new int[] { 236, 92, 122, 131, 131, 236, 236, -1 },
                nge.nextGreaterElement(new int[] { 137, 59, 92, 122, 52, 131, 79, 236 }, new int[] { 137, 59, 92, 122,
                        52, 131, 79, 236 }));
    }
}

// 3 1 4 2
// 4 4 -1 -1
