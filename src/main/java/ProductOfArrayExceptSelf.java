import org.junit.Assert;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] products = new int[length];
        int[] left_fwd = new int[length];
        int[] right_fwd = new int[length];

        left_fwd[0] = 1;
        right_fwd[length - 1] = 1;
        for (int i = 1; i < length; i++) {
            left_fwd[i] = left_fwd[i - 1] * nums[i - 1];
            right_fwd[length - i - 1] = right_fwd[length - i] * nums[length - i];
        }
//        for (int j = length - 2; j >= 0; j--) {
//            right_fwd[j] = right_fwd[j + 1] * nums[j + 1];
//        }

        for (int i = 0; i < length; i++) {
            products[i] = left_fwd[i] * right_fwd[i];
        }
        return products;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf poa = new ProductOfArrayExceptSelf();
        Assert.assertArrayEquals(new int[] { 24, 12, 8, 6 }, poa.productExceptSelf(new int[] { 1, 2, 3, 4 }));

    }
}
