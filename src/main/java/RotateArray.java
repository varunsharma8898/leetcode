import org.junit.Assert;

public class RotateArray {


    // Using reverse - 3 times
    // Space - O(1) time - O(n) * 3 = O(n)
    // Original List                   : 1 2 3 4 5 6 7
    // After reversing all numbers     : 7 6 5 4 3 2 1
    // After reversing first k numbers : 5 6 7 4 3 2 1
    // After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
    public void rotate2(int[] nums, int k) {
        int times = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, times - 1);
        reverse(nums, times, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    // rotate using additional array
    // space O(n) to store n elements, time O(n) for 1 pass
    public void rotate(int[] nums, int k) {
        int[] expected = new int[nums.length];
        for (int i = 0; i < nums.length ; i++) {
            expected[(i + k) % nums.length] = nums[i];
        }
        for (int i =0; i < nums.length; i++) {
            nums[i] = expected[i];
        }
    }

    public static void main(String[] args) {
        RotateArray ra = new RotateArray();
        int[] test1 = new int[] { 1, 2, 3, 4, 5, 6, 7};
        ra.rotate(test1, 3);
        Assert.assertArrayEquals(new int[] { 5, 6, 7, 1, 2, 3, 4}, test1);

        test1 = new int[] { 1, 2, 3, 4, 5, 6, 7};
        ra.rotate2(test1, 3);
        Assert.assertArrayEquals(new int[] { 5, 6, 7, 1, 2, 3, 4}, test1);
    }
}
