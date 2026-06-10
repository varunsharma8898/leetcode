import org.junit.Assert;

public class SearchInRotatedSortedArray {

    private int search_(int[] nums, int target) {
        // 1. first find start of the array - min element
        // 2. then find search area
        // 3. then do a binary search

        int start = findMinIndex(nums);
        int left = 0, right = nums.length - 1;

        if (target > nums[right]) {
            right = start;
        } else if (target <= nums[right]) {
            left = start;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    /**
     * Thing to remember - whenever we are not finding a mid value, we're dividing the space in two.
     * so, we should not do left = mid - 1 and right = mid + 1.
     * Atleast one should be mid, like left = mid - 1 and right = mid.
     * */
    private int findMinIndex(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {                   // vvvv-imp - if <= is there, it'll go in forever loop, keep only <
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {       /// v-v-v-imp - checking mid with right since it is a rotated array
                left = mid + 1;                  // mid + 1
            } else {
                right = mid;                     // only mid
            }
        }
        return left;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray se = new SearchInRotatedSortedArray();
        Assert.assertEquals(4, se.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
        Assert.assertEquals(-1, se.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3));
        Assert.assertEquals(-1, se.search(new int[] { 1 }, 0));
        Assert.assertEquals(1, se.search(new int[] { 3, 1 }, 1));
        Assert.assertEquals(0, se.search(new int[] { 3, 1 }, 3));
        Assert.assertEquals(1, se.search(new int[] { 8,9,2,3,4 }, 9));
    }

    private int search(int[] nums, int target) {
        // first find min index
        int start = findMinIndex_(nums);

        // then find search space
        int left = 0, right = nums.length - 1;
        if (target > nums[right]) {
            right = start;
        } else {
            left = start;
        }

        // then find element through binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int findMinIndex_(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
