import java.util.Arrays;

import org.junit.Assert;

public class MaximalRectangleUsingLRBoundaries {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int n = matrix[0].length;

        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(height, 0);
        Arrays.fill(left, 0);
        Arrays.fill(right, n);

        for (int i = 0; i < matrix.length; i++) {

            int currLeft = 0, currRight = n;

            // fill right array
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], currRight);
                } else {
                    right[j] = n;
                    currRight = j;
                }
            }

            // The next 3 for loops can be refactored into one loop
            // but I'm keeping them here for readability purposes.

            // fill height array
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }

            // fill left array
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], currLeft);
                } else {
                    left[j] = 0;
                    currLeft = j + 1;
                }
            }

            for (int j = 0; j < n; j++) {
                int area = height[j] * (right[j] - left[j]);
                maxArea = Math.max(area, maxArea);
            }
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
