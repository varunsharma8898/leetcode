import org.junit.Assert;

public class MaxProductSubarray {

    public int maxProduct(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        int min = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tmp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(tmp * nums[i], min * nums[i]), nums[i]);

            if (max > result) {
                result = max;
            }
//            maxProducts[i] = Math.max(nums[i], nums[i] * maxProducts[i - 1]);
//            maxProducts[i] = Math.max(maxProducts[i], nums[i] * minProducts[i - 1]);
//            minProducts[i] = Math.min(nums[i], nums[i] * minProducts[i - 1]);
//            minProducts[i] = Math.min(minProducts[i], nums[i] * maxProducts[i - 1]);
//
//            maxProduct = Math.max(maxProduct, maxProducts[i]);
        }
        return result;
    }

    public int maxProduct1(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] maxProducts = new int[len];
        int[] minProducts = new int[len];
        int maxProduct = nums[0];
        maxProducts[0] = nums[0];
        minProducts[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxProducts[i] = Math.max(nums[i], nums[i] * maxProducts[i - 1]);
            maxProducts[i] = Math.max(maxProducts[i], nums[i] * minProducts[i - 1]);
            minProducts[i] = Math.min(nums[i], nums[i] * minProducts[i - 1]);
            minProducts[i] = Math.min(minProducts[i], nums[i] * maxProducts[i - 1]);

            maxProduct = Math.max(maxProduct, maxProducts[i]);
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        MaxProductSubarray mps = new MaxProductSubarray();
        Assert.assertEquals(6, mps.maxProduct(new int[] { 2, 3, -2, 4 }));
        Assert.assertEquals(0, mps.maxProduct(new int[] { -2, 0, -1 }));
    }
}
