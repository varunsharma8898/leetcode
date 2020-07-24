import java.util.Stack;

import org.junit.Assert;

public class MaxRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {

        if (heights == null || heights.length == 0) {
            return 0;
        }
        int maxArea = 0;

        Stack<Integer> heightStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {

            int tmpIndex = i;
            while (!heightStack.isEmpty() && heightStack.peek() > heights[i]) {
                int tmpHeight = heightStack.pop();
                tmpIndex = indexStack.pop();
                int area = tmpHeight * (i - tmpIndex);
                maxArea = Math.max(area, maxArea);
            }

            heightStack.push(heights[i]);
            indexStack.push(tmpIndex);
        }

        while (!heightStack.isEmpty()) {
            int tmpHeight = heightStack.pop();
            int tmpIndex = indexStack.pop();
            int area = tmpHeight * (heights.length - tmpIndex);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        MaxRectangleInHistogram obj = new MaxRectangleInHistogram();
        Assert.assertEquals(0, obj.largestRectangleArea(null));
        Assert.assertEquals(0, obj.largestRectangleArea(new int[] {}));
        Assert.assertEquals(10, obj.largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
    }
}
