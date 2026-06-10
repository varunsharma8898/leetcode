import org.junit.Assert;

public class FindFirstLastPositionSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] { -1, -1 };
        if (nums == null || nums.length == 0) {
            return result;
        }
        int start = findStart(nums, target);
        int end = findEnd(nums, target);
        if (nums[start] == target) {
            result[0] = start;
        }
        if (nums[end] == target) {
            result[1] = end;
        }
        return result;
    }

    private int findStart(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int start = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                start = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return start;
    }

    private int findEnd(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int end = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                end = mid;
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        FindFirstLastPositionSortedArray ff = new FindFirstLastPositionSortedArray();
        Assert.assertArrayEquals(new int[] { 3, 4 }, ff.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8));
        Assert.assertArrayEquals(new int[] { -1, -1 }, ff.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6));
        Assert.assertArrayEquals(new int[] { -1, -1 }, ff.searchRange(new int[] { }, 0));
    }

}
