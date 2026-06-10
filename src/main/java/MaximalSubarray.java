import org.junit.Assert;

public class MaximalSubarray {

    private int maxSubArray(int[] nums) {
        int max = nums[0], maxSoFar = nums[0];
        for (int i = 1; i < nums.length; i++) { // v-imp - from 1 to end
            int num = nums[i];
            maxSoFar = Math.max(maxSoFar + num, num);
            max = Math.max(max, maxSoFar);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximalSubarray ms = new MaximalSubarray();
        Assert.assertEquals(6, ms.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
        Assert.assertEquals(1, ms.maxSubArray(new int[] {1}));
        Assert.assertEquals(-1, ms.maxSubArray(new int[] {-1}));
        Assert.assertEquals(23, ms.maxSubArray(new int[] {5,4,-1,7,8}));
    }
}
