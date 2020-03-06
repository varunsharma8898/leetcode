import org.junit.Assert;

public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (rows == 0 || cols == 0) {
            return 0;
        }

        int perimeter = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                int connections = 4;
                if (i > 0 && grid[i - 1][j] == 1) {
                    connections--;
                }
                if (i < rows - 1 && grid[i + 1][j] == 1) {
                    connections--;
                }
                if (j > 0 && grid[i][j - 1] == 1) {
                    connections--;
                }
                if (j < cols - 1 && grid[i][j + 1] == 1) {
                    connections--;
                }
                perimeter += connections;
            }
        }
        return perimeter;
    }

    public static void main(String[] args) {

        IslandPerimeter ip = new IslandPerimeter();

        int[][] grid1 = new int[][] {
                { 0, 1, 0, 0 },
                { 1, 1, 1, 0 },
                { 0, 1, 0, 0 },
                { 1, 1, 0, 0 }
        };

        Assert.assertEquals(16, ip.islandPerimeter(grid1));

        int[][] grid2 = new int[][] {
                { 1, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 }
        };

        Assert.assertEquals(4, ip.islandPerimeter(grid2));

        int[][] grid3 = new int[][] {
                { 1, 0, 0, 0 },
                { 1, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 }
        };

        Assert.assertEquals(6, ip.islandPerimeter(grid3));
    }
}
