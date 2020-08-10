import org.junit.Assert;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    dfs(grid, i, j, 2);             // start counting+marking above 2 and return ans-minus-2
                }
            }
        }

        int maxDays = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                maxDays = Math.max(maxDays, grid[i][j]); // most imp line
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return maxDays == 0 ? maxDays : maxDays - 2;     // most imp line
    }

    private void dfs(int[][] grid, int i, int j, int day) {

        if (i < 0 || i >= grid.length
                || j < 0 || j >= grid[0].length
                || grid[i][j] == 0
                || grid[i][j] > 1 && grid[i][j] < day    // most imp line
        ) {
            return;
        }

        grid[i][j] = day;

        dfs(grid, i + 1, j, day + 1); // down
        dfs(grid, i - 1, j, day + 1); // up
        dfs(grid, i, j + 1, day + 1); // right
        dfs(grid, i, j - 1, day + 1); // left
    }

    public static void main(String[] args) {
        RottingOranges ro = new RottingOranges();

        // Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
        Assert.assertEquals(0, ro.orangesRotting(new int[][] {
                { 0, 2 }
        }));

        Assert.assertEquals(2, ro.orangesRotting(new int[][] {
                { 1, 2, 1, 1, 2, 1, 1 }
        }));

        Assert.assertEquals(4, ro.orangesRotting(new int[][] {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 }
        }));

        // Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten,
        // because rotting only happens 4-directionally.
        Assert.assertEquals(-1, ro.orangesRotting(new int[][] {
                { 2, 1, 1 },
                { 0, 1, 1 },
                { 1, 0, 1 }
        }));

        Assert.assertEquals(2, ro.orangesRotting(new int[][] {
                { 2 },
                { 1 },
                { 1 },
                { 1 },
                { 2 },
                { 1 },
                { 1 },
        }));
    }

    /**
     * In a given grid, each cell can have one of three values:
     *
     *     the value 0 representing an empty cell;
     *     the value 1 representing a fresh orange;
     *     the value 2 representing a rotten orange.
     *
     * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
     *
     * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
     * If this is impossible, return -1 instead.
     *
     * */
}
