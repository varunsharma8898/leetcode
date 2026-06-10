import org.junit.Assert;

public class RemoveDuplicatesSortedArray2 {

    public static void main(String[] args) {
        RemoveDuplicatesSortedArray2 obj = new RemoveDuplicatesSortedArray2();

        int[] nums = new int[] { 1, 1, 1, 2, 2, 3 };
        int[] expectedNums = new int[] { 1, 1, 2, 2, 3 };
        int k = obj.removeDuplicates(nums);
        Assert.assertEquals(5, k);
        for (int i = 0; i < k; i++) {
            Assert.assertEquals(nums[i], expectedNums[i]);
        }
    }

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int curr: nums) {
            if (i < 2 || nums[i-2] != curr) {
                nums[i] = curr;
                i++;
            }
        }
        return i;
    }

}
