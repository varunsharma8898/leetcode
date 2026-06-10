import org.junit.Assert;

public class MaxSumCircularSubarray {

    private int maxSubarraySumCircular(int[] nums) {

        int total = 0;
        int maxSoFar = 0, max = nums[0];
        int minSoFar = 0, min = nums[0];
        for (int num : nums) {
            maxSoFar = Math.max(maxSoFar + num, num);
            max = Math.max(maxSoFar, max);

            minSoFar = Math.min(minSoFar + num, num);
            min = Math.min(minSoFar, min);

            total += num;
        }
        return max > 0 ? Math.max(max, total - min) : max;
    }

    /**
     * Explanation:
     *  Considering a non-circular array, the max sum would lie between the boundaries
     *  But for a circular one, the max sum would lie between start and end.
     *  so the min would lie between the boundaries.
     *  So the max subarray circular sum equals to:
     *      max(the max subarray sum, the total sum - the min subarray sum)
     * */

    public static void main(String[] args) {
        MaxSumCircularSubarray obj = new MaxSumCircularSubarray();
        Assert.assertEquals(3, obj.maxSubarraySumCircular(new int[] { 1, -2, 3, -2 }));
        Assert.assertEquals(10, obj.maxSubarraySumCircular(new int[] { 5, -3, 5 }));
        Assert.assertEquals(-2, obj.maxSubarraySumCircular(new int[] { -3, -2, -3 }));
    }

    private int test(int[] nums) {
        int total = 0;
        int maxSoFar = 0, max = nums[0];
        int minSoFar = 0, min = nums[0];
        for (int num: nums) {
            maxSoFar = Math.max(maxSoFar + num, num);
            max = Math.max(max, maxSoFar);

            minSoFar = Math.min(minSoFar + num, num);
            min = Math.min(min, minSoFar);

            total += num;
        }
        return max > 0 ? Math.max(max, total - min) : max;
    }
}
