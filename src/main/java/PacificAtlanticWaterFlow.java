import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {

        List<List<Integer>> result = new ArrayList<>();
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        boolean[][] pacificReachable = new boolean[numRows][numCols];
        boolean[][] atlanticReachable = new boolean[numRows][numCols];

        // start checking from boundaries, instead of checking all nodes
        for (int i = 0; i < numRows; i++) {
            dfs(matrix, i, 0, pacificReachable);
            dfs(matrix, i, numCols - 1, pacificReachable);
        }
        for (int j = 0; j < numCols; j++) {
            dfs(matrix, 0, j, atlanticReachable);
            dfs(matrix, numRows - 1, j, atlanticReachable);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (pacificReachable[i][j] == atlanticReachable[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                }
            }
        }
        return result;
    }

    private boolean dfs(int[][] matrix, int i, int j, boolean[][] reachable) {

        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            return false;
        }

        return false;
    }

    public static void main(String[] args) {

        PacificAtlanticWaterFlow obj = new PacificAtlanticWaterFlow();

        int[][] matrix = new int[][] {
                new int[] { 1, 2, 2, 3, 5 },
                new int[] { 3, 2, 3, 4, 4 },
                new int[] { 2, 4, 5, 3, 1 },
                new int[] { 6, 7, 1, 4, 5 },
                new int[] { 5, 1, 1, 2, 4 },
        };

        List<List<Integer>> result = obj.pacificAtlantic(matrix);
        System.out.println(result);

    }
}
