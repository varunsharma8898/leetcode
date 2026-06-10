import org.junit.Assert;

public class MergeSortedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int pos = m + n - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[pos--] = nums1[i--];
            } else {
                nums1[pos--] = nums2[j--];
            }
        }
    }

    public static void main(String[] args) {
        MergeSortedArrays obj = new MergeSortedArrays();
        int[] nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
        obj.merge(nums1, 3, new int[] { 2, 5, 6 }, 3);
        Assert.assertArrayEquals(new int[] { 1, 2, 2, 3, 5, 6 }, nums1);

        nums1 = new int[] { 1 };
        obj.merge(nums1, 1, new int[] { }, 0);
        Assert.assertArrayEquals(new int[] { 1 }, nums1);

        nums1 = new int[] { 0 };
        obj.merge(nums1, 0, new int[] { 1 }, 1);
        Assert.assertArrayEquals(new int[] { 1 }, nums1);
    }
    /**
     * Example 1:
     *
     * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * Output: [1,2,2,3,5,6]
     * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
     * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
     * Example 2:
     *
     * Input: nums1 = [1], m = 1, nums2 = [], n = 0
     * Output: [1]
     * Explanation: The arrays we are merging are [1] and [].
     * The result of the merge is [1].
     * Example 3:
     *
     * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
     * Output: [1]
     * Explanation: The arrays we are merging are [] and [1].
     * The result of the merge is [1].
     * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
     * */
}
