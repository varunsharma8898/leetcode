import org.junit.Assert;

public class Search2DMatrix {

    private boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / cols;
            int col = mid % cols;
            if (target == matrix[row][col]) {
                return true;
            } else if (target > matrix[row][col]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Search2DMatrix obj = new Search2DMatrix();
        Assert.assertTrue(obj.searchMatrix(new int[][] {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 }
        }, 3));

        Assert.assertFalse(obj.searchMatrix(new int[][] {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 }
        }, 13));
    }

    private boolean searchMatrix1(int[][] grid, int target) {
        int rows = grid.length, cols = grid[0].length;
        int left = 0, right = rows * cols - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / cols;
            int col = mid % cols;
            if (grid[row][col] == target) {
                return true;
            } else if (grid[row][col] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
