import java.util.Arrays;
import java.util.Stack;

import org.junit.Assert;

public class NextGreaterElement2 {

    /**
     * The trick here is i % n.length; it'll always return the correct index from the original array.
     * Second, we have to run through the array twice since its a circular array.
     *
     * */
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < 2 * nums.length; i++) {
            while (!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % nums.length];
            }
            stack.push(i % nums.length);
        }
        return res;
    }

    public static void main(String[] args) {
        NextGreaterElement2 obj = new NextGreaterElement2();
        Assert.assertArrayEquals(new int[] { 2, -1, 2 }, obj.nextGreaterElements(new int[] { 1, 2, 1 }));
        Assert.assertArrayEquals(new int[] { 2, 3, 4, 5, -1, 2 }, obj.nextGreaterElements(new int[] { 1, 2, 3, 4, 5, 1 }));
        Assert.assertArrayEquals(new int[] { 2, 3, 4, -1, 4 }, obj.nextGreaterElements(new int[] { 1, 2, 3, 4, 3 }));
        Assert.assertArrayEquals(new int[] { -1, 5, 5, 5, 5 }, obj.nextGreaterElements(new int[] { 5, 4, 3, 2, 1 }));

    }
}
