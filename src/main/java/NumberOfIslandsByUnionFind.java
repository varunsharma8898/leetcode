import java.util.Arrays;

import org.junit.Assert;

public class NumberOfIslandsByUnionFind {

    class UnionFind {

        int count = 0;

        int[] parents;

        UnionFind(char[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;
            parents = new int[rows * cols];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                    }
                }
            }
        }

        public void union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 != root2) {
                parents[root1] = root2;
                count--;
            }
        }

        public int find(int node) {
            if (parents[node] == node) {
                return node;
            }
            parents[node] = find(parents[node]);
            return parents[node];
        }

    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        UnionFind uf = new UnionFind(grid);

        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                int x = i * cols + j;
                int y;

                // There's no need to go up or left as we're already going through those elements here

//                if (i > 0 && grid[i - 1][j] == '1') {           // up
//                    y = x - cols;
//                    uf.union(x, y);
//                }
                if (i < rows - 1 && grid[i + 1][j] == '1') {    // down
                    y = x + cols;
                    uf.union(x, y);
                }
//                if (j > 0 && grid[i][j - 1] == '1') {           // left
//                    y = x - 1;
//                    uf.union(x, y);
//                }
                if (j < cols - 1 && grid[i][j + 1] == '1') {    // right
                    y = x + 1;
                    uf.union(x, y);
                }
            }
        }
        return uf.count;
    }

    public static void main(String[] args) {
        NumberOfIslandsByUnionFind ni = new NumberOfIslandsByUnionFind();

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
