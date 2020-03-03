import java.util.Arrays;

import org.junit.Assert;

public class MaxAreaOfIslanByUnionFind {

    class UnionFind {

        int[] parents;

        int[] weights;

        int maxArea = 0;

        UnionFind(int[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;
            parents = new int[rows * cols];
            weights = new int[rows * cols];
//            Arrays.fill(weights, 1);

            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
                weights[i] = 1;
            }
        }

        private int find(int node) {
            if (parents[node] == node) {
                return node;
            }
            parents[node] = find(parents[node]);
            return parents[node];
        }

        private int union(int node1, int node2) {
            int dad1 = find(node1);
            int dad2 = find(node2);
            if (dad1 == dad2) {
                return weights[dad1];
            }
            if (weights[dad1] > weights[dad2]) {
                parents[dad2] = dad1;
                weights[dad1] += weights[dad2];
                maxArea = Math.max(maxArea, weights[dad1]);
            } else {
                parents[dad1] = dad2;
                weights[dad2] += weights[dad1];
                maxArea = Math.max(maxArea, weights[dad2]);
            }
            return maxArea;
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        if (rows == 1 && cols == 1 && grid[0][0] == 1) {
            return 1;
        }

        int maxArea = 0;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    if (maxArea == 0) {
                        maxArea = 1;
                    }
                    int x = i * cols + j;
                    int y;
                    if (i < rows - 1 && grid[i + 1][j] == 1) {    // down
                        y = x + cols;
                        maxArea = Math.max(maxArea, uf.union(x, y));
                    }
                    if (j < cols - 1 && grid[i][j + 1] == 1) {    // right
                        y = x + 1;
                        maxArea = Math.max(maxArea, uf.union(x, y));
                    }
                } else {
                    continue;
                }
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        MaxAreaOfIslanByUnionFind mai = new MaxAreaOfIslanByUnionFind();

        int[][] grid3 = new int[][] {
                { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 }
        };
//        ni.printBoard(grid2);
        Assert.assertEquals(6, mai.maxAreaOfIsland(grid3));
//        ni.printBoard(grid2);

        int[][] grid1 = new int[][] { { 1 } };
        Assert.assertEquals(1, mai.maxAreaOfIsland(grid1));

        int[][] grid2 = new int[][] { { 0 } };
        Assert.assertEquals(0, mai.maxAreaOfIsland(grid2));

        int[][] grid4 = new int[][] { { 0, 0 } };
        Assert.assertEquals(0, mai.maxAreaOfIsland(grid4));

        int[][] grid5 = new int[][] { { 0 }, { 0 } };
        Assert.assertEquals(0, mai.maxAreaOfIsland(grid5));

        int[][] grid6 = new int[][] { { 0, 1 } };
        Assert.assertEquals(1, mai.maxAreaOfIsland(grid6));

        int[][] grid7 = new int[][] { { 0 }, { 1 } };
        Assert.assertEquals(1, mai.maxAreaOfIsland(grid7));

    }

    private void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println("------------");
    }
}
