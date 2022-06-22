import java.util.HashMap;
import java.util.Map;

public class UniquePathsWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        Map<String, Integer> memoMap = new HashMap<>();
        return dfs(0, 0, obstacleGrid, memoMap);
    }

    private int dfs(int m, int n, int[][] obs, Map<String, Integer> map) {
        int rows = obs.length, cols = obs[0].length;
        if (obs[m][n] == 1) return 0;
        String key = m + "-" + n;
        if (map.containsKey(key)) return map.get(key);
        if (m == rows - 1 && n == cols - 1) return 1;

        int val = 0;
        if (m+1 < rows) val += dfs(m+1, n, obs, map);
        if (n+1 < cols) val += dfs(m, n+1, obs, map);
        map.put(key, val);
        return val;
    }
}
