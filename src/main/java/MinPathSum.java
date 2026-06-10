import org.junit.Assert;

public class MinPathSum {

    private int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        for (int row = 1; row < m; row++) {
            grid[row][0] += grid[row - 1][0];
        }
        for (int col = 1; col < n; col++) {
            grid[0][col] += grid[0][col - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }



    private int minPathSumRecursive(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        return helper(grid, 0, 0);
    }
    private int helper(int[][] grid, int i, int j) {
        int m = grid.length - 1, n = grid[0].length - 1;
        if (i == m && j == n) {             // boundary condition, last element
            return grid[i][j];
        }
        if (i == m) {                       // reached last row, can only proceed col-wise
            return grid[i][j] + helper(grid, i, j+1);
        }
        if (j == n) {                       // reached last col, can only proceed row-wise
            return grid[i][j] + helper(grid, i+1, j);
        }
        int currMin = grid[i][j];           // for elements in the middle of grid
        currMin += Math.min(helper(grid, i+1, j), helper(grid, i, j+1));
        return currMin;
    }

    public static void main(String[] args) {
        MinPathSum obj = new MinPathSum();
        Assert.assertEquals(7, obj.minPathSum(new int[][] {
                { 1, 3, 1 },
                { 1, 5, 1 },
                { 4, 2, 1 }
        }));

        Assert.assertEquals(12, obj.minPathSum(new int[][] {
                { 1, 2, 3 },
                { 4, 5, 6 }
        }));
    }

}
