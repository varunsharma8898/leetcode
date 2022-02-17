import org.junit.Assert;

public class NumberOfProvinces {

    public static void main(String[] args) {
        NumberOfProvinces nop = new NumberOfProvinces();
        Assert.assertEquals(2, nop.findCircles(new int[][] {
                { 1, 1, 0 },
                { 1, 1, 0 },
                { 0, 0, 1 }
        }));
    }

    private int findCircles(int[][] grid) {
        int count = 0;
        boolean[] visited = new boolean[grid.length];
        for (int i = 0; i < grid.length; i++) {
            if (!visited[i]) {
                dfs(grid, i, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] grid, int i, boolean[] visited) {
        visited[i] = true;
        for (int j = 0; j < grid.length; j++) {
            if (grid[i][j] == 1 && !visited[j] && i != j) {
                visited[j] = true;
                dfs(grid, j, visited);
            }
        }
    }
}
