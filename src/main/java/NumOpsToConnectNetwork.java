import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumOpsToConnectNetwork {

    /**
     * https://leetcode.com/problems/number-of-operations-to-make-network-connected/
     *
     * similar to number of islands, but we have to make our own adjList instead of matrix here.
     *
     *
     * Time O(connections)
     * Space O(n)
     *
     * */

    public int makeConnected(int n, int[][] connections) {
        if (n > connections.length + 1) return -1;             // v-imp

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int[] connection: connections) {
            adjList.get(connection[0]).add(connection[1]);
            adjList.get(connection[1]).add(connection[0]);
        }

        boolean[] visited = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            dfs(i, adjList, visited);
            ans++;
        }
        return ans-1;
    }

    private void dfs(int i, Map<Integer, List<Integer>> adjList, boolean[] visited) {
        visited[i] = true;
        for (Integer neighbor : adjList.get(i)) {
            if (visited[neighbor]) continue;
            dfs(neighbor, adjList, visited);
        }
    }
}
