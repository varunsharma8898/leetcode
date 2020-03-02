import java.util.Arrays;

import org.junit.Assert;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int count = 0;

        if (grid.length == 0 || grid[0].length == 0) {
            return count;
        }

        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {

        if (i < 0 || i >= grid.length
                || j < 0 || j >= grid[0].length
                || grid[i][j] == '0'
        ) {
            return;
        }
        grid[i][j] = '0';

        dfs(grid, i - 1, j); // left
        dfs(grid, i + 1, j); // right
        dfs(grid, i, j - 1); // up
        dfs(grid, i, j + 1); // down
    }

    public static void main(String[] args) {
        NumberOfIslands ni = new NumberOfIslands();

        char[][] grid1 = new char[][] {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        };

//        ni.printBoard(grid1);
        Assert.assertEquals(1, ni.numIslands(grid1));
//        ni.printBoard(grid1);

        char[][] grid2 = new char[][] {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
//        ni.printBoard(grid2);
        Assert.assertEquals(3, ni.numIslands(grid2));
//        ni.printBoard(grid2);
    }

    private void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println("------------");
    }
}
