import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;

public class MinTimeCollectApples {

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // first build tree
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            map.get(a).add(b);
            map.get(b).add(a);
        }

        Set<Integer> visited = new HashSet<>();
        return dfs(0, map, hasApple, visited);
    }

    private int dfs(int node, Map<Integer, List<Integer>> map, List<Boolean> hasApple, Set<Integer> visited) {
        visited.add(node);
        int res = 0;
        for (int child : map.get(node)) {
            if (visited.contains(child)) continue;
            res += dfs(child, map, hasApple, visited);
        }

        // if the node has apple or any of its children has apples
        // AND it is not a root node, we need to add 2 to res for traversing in and out of the node
        if (
            (res > 0 || hasApple.get(node))
            && node != 0
        ) {
            res += 2;
        }
        return res;
    }

    public static void main(String[] args) {
        MinTimeCollectApples obj = new MinTimeCollectApples();
        Assert.assertEquals(8, obj.minTime(7, new int[][] {
                        { 0, 1 }, { 0, 2 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, { 2, 6 }
                }, Arrays.asList(false, false, true, false, true, true, false))
        );

        /**
         * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,true,true,false]
         * Output: 8
         * Explanation: The figure above represents the given tree where red vertices have an apple.
         * One optimal path to collect all apples is shown by the green arrows.
         * */
    }

}
