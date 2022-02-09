import org.junit.Assert;

public class MinSwapsToGroupAll1s {

    private int minSwaps(int[] nums) {
        int totalOnes = 0, n = nums.length;
        for (int num : nums) {
            if (num == 1) totalOnes++;
        }
        if (totalOnes == 0) return 0;

        int maxOnesInSlidingWindow = 0, onesInCurrentSlidingWindow = 0;
        for (int i = 0; i < totalOnes; i++) {
            if (nums[i] == 1) onesInCurrentSlidingWindow++;
        }
        maxOnesInSlidingWindow = onesInCurrentSlidingWindow;

        for (int i = totalOnes; i < n + totalOnes; i++) {
            onesInCurrentSlidingWindow += nums[i % n] - nums[i - totalOnes];
            maxOnesInSlidingWindow = Math.max(maxOnesInSlidingWindow, onesInCurrentSlidingWindow);
        }
        return totalOnes - maxOnesInSlidingWindow;
    }

    private int helper(int[] nums, int start, int end, int onesCount) {

        int maxOnesInSlidingWindow = 0;
        for (int i = start; i < end - onesCount; i++) {
            int onesInSlidingWindow = 0;
            for (int j = i; j < i + onesCount; j++) {
                if (nums[j] == 1) onesInSlidingWindow++;
            }
            maxOnesInSlidingWindow = Math.max(onesInSlidingWindow, maxOnesInSlidingWindow);
        }

        return onesCount - maxOnesInSlidingWindow;
    }

    public static void main(String[] args) {
        MinSwapsToGroupAll1s obj = new MinSwapsToGroupAll1s();
        Assert.assertEquals(1, obj.minSwaps(new int[] { 0, 1, 0, 1, 1, 0, 0 }));
        Assert.assertEquals(2, obj.minSwaps(new int[] { 0, 1, 1, 1, 0, 0, 1, 1, 0 }));
        Assert.assertEquals(0, obj.minSwaps(new int[] { 1, 1, 0, 0, 1 }));
    }

}
