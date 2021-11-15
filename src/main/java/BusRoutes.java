import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BusRoutes {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                if (!map.containsKey(routes[i][j])) {
                    map.put(routes[i][j], new ArrayList<Integer>());
                }
                map.get(routes[i][j]).add(i);
            }
        }

        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        q.offer(source);
        int result = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            result++;
            for (int i = 0; i < len; i++) {
                List<Integer> buses = map.get(q.poll());
                for (Integer bus : buses) {
                    if (visited.contains(bus)) {
                        continue;
                    }
                    visited.add(bus);
                    for (int stop : routes[bus]) {
                        if (stop == target) {
                            return result;
                        }
                        q.offer(stop);
                    }
                }
            }
        }

        return -1;
    }
}
