public class MaxAreaContainer {

    MaxAreaContainer() {
    }

    public int maxArea(int[] height) {

        int maxArea = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int area = 0;
            if (height[l] < height[r]) {
                area = height[l] * (r - l);
                l++;
            } else {
                area = height[r] * (r - l);
                r--;
            }
            maxArea = area > maxArea ? area : maxArea;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        MaxAreaContainer mac = new MaxAreaContainer();
        int result = mac.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 });
        System.out.println(result);
    }
}
