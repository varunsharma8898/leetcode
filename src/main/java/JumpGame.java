public class JumpGame {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return true;
        }
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (maxIndex >= n - 1) {
                return true;
            }
            maxIndex = Math.max(maxIndex, i + nums[i]);
            if (maxIndex == i) {
                return false;
            }
        }
        return true;
    }

    public boolean canJump_rightToLeft(int[] nums) {
        int target = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= target) {
                target = i;
            }
        }
        return target == 0;
    }
}
