import org.junit.Assert;

public class TrappingRainWater {

    /**
     * Approach:
     *  - Create 2 arrays - left and right.
     *  - Store max seen so far in each.
     *  - Traverse through the array again and find:
     *    min(left[i], right[i]) and subtract height[i]
     *  - Add this value to total.
     * */
    private int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int total = 0;
        int[] leftArr = new int[height.length];
        int[] rightArr = new int[height.length];

        // Important to init with boundary values
        leftArr[0] = height[0];
        rightArr[height.length - 1] = height[height.length - 1];

        int i = 1; // imp to start with 1
        while (i < height.length) {
            int left = i;
            int right = height.length - i - 1;
            leftArr[left] = Math.max(height[left], leftArr[left - 1]);
            rightArr[right] = Math.max(height[right], rightArr[right + 1]);
            i++;
        }
        for (i = 0; i < height.length; i++) {
            total += Math.min(leftArr[i], rightArr[i]) - height[i];
        }
        return total;
    }

    public static void main(String[] args) {
        TrappingRainWater obj = new TrappingRainWater();
        Assert.assertEquals(0, obj.trap(null));
        Assert.assertEquals(0, obj.trap(new int[] { }));
        Assert.assertEquals(0, obj.trap(new int[] { 1 }));
        Assert.assertEquals(0, obj.trap(new int[] { 1, 2 }));
        Assert.assertEquals(0, obj.trap(new int[] { 1, 2, 3 }));
        Assert.assertEquals(1, obj.trap(new int[] { 1, 0, 1 }));
        Assert.assertEquals(6, obj.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
    }

}
