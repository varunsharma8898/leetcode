import org.junit.Assert;

public class FindPeakElement {

    private int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0; // only one element, so it must be the peak
        }

        if (nums[0] > nums[1]) {
            return 0; // first element itself is a peak
        }
        if (nums[len - 1] > nums[len - 2]) {
            return len - 1; // last element is a peak
        }

        int left = 1, right = len - 2; // since we've already checked 0 and last element, search space is between 1 and len-2
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] < nums[mid - 1]) {
                right = mid - 1;
            } else if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }
        }
        return -1; // default
    }

    public static void main(String[] args) {
        FindPeakElement fpe = new FindPeakElement();
        Assert.assertEquals(2, fpe.findPeakElement(new int[] { 1, 2, 3, 1 }));
        Assert.assertEquals(5, fpe.findPeakElement(new int[] { 1, 2, 1, 3, 5, 6, 4 }));
    }

}
