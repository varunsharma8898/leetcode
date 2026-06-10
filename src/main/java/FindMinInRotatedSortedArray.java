import org.junit.Assert;

public class FindMinInRotatedSortedArray {

    private int findMin(int[] nums) {
        /**
         * Always remember, since we dont have a mid to compare and return
         * we will do a while condition on left < right and not <=
         * also, we wont do left = mid + 1 and right = mid -1
         * instead it will be left = mid + 1 and right = mid
         * */

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        FindMinInRotatedSortedArray fm = new FindMinInRotatedSortedArray();
        Assert.assertEquals(1, fm.findMin(new int[] { 3, 4, 5, 1, 2 }));
        Assert.assertEquals(0, fm.findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
        Assert.assertEquals(11, fm.findMin(new int[] { 11, 13, 15, 17 }));
    }

}
