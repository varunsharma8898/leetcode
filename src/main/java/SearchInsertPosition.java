import org.junit.Assert;

public class SearchInsertPosition {

    /**
     * Given a sorted array of distinct integers and a target value, return the index if the target is found.
     * If not, return the index where it would be if it were inserted in order.
     * You must write an algorithm with O(log n) runtime complexity. (Binary Search)
     */
    private int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) return mid;                // found target in array
            else if (target > nums[mid]) left = mid + 1;        // increase left
            else if (target < nums[mid]) right = mid - 1;       // decrease right
        }
        return left;                                            // v-imp to return left
    }

    public static void main(String[] args) {
        SearchInsertPosition sip = new SearchInsertPosition();
        Assert.assertEquals(2, sip.searchInsert(new int[] { 1, 3, 5, 6 }, 5));
        Assert.assertEquals(1, sip.searchInsert(new int[] { 1, 3, 5, 6 }, 2));
        Assert.assertEquals(4, sip.searchInsert(new int[] { 1, 3, 5, 6 }, 7));
    }
}
