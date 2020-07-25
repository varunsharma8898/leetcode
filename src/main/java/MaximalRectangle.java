import java.util.Stack;

import org.junit.Assert;

public class MaximalRectangle {

    // Easiest solution is to copy code from maxRectangleInHistogram and pass the heights array to it.
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int n = matrix[0].length;

        int[] heights = new int[n];
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    // copied from MaxRectangleInHistogram
    private int largestRectangleArea(int[] heights) {

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

        MaximalRectangle obj = new MaximalRectangle();
        Assert.assertEquals(1, obj.maximalRectangle(new char[][] {
                { '1' }
        }));
        Assert.assertEquals(6, obj.maximalRectangle(new char[][] {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' }
        }));
    }
}
