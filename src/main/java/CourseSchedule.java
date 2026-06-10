import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.junit.Assert;

public class CourseSchedule {

    /**
     * Topological sort - using BFS
     * <p>
     * 1. create adjacency list and in-degree array
     * 2. add all in-degree == 0 elements onto a queue
     * 3. process each element in queue using bfs
     * 4. for all neighbors, reduce in-degree by 1
     * 5. if in-degree goes down to 0, add it to queue.
     * 6. keep a count of all elements in the queue
     * 7. if count matches number of nodes, no cycle.
     * 8. Topological sort order can be obtained by getting all elements in queue.
     */

//    public boolean canFinish(int n, int[][] prerequisites) {
//
//        ArrayList<Integer>[] adjList = new ArrayList[n];
//        for (int i = 0; i < n; i++) {
//            adjList[i] = new ArrayList<>();
//        }
//
//        int[] in_degree = new int[n];
//
//        for (int[] arr : prerequisites) {
//            adjList[arr[1]].add(arr[0]);
//            in_degree[arr[0]]++;         // in-degree means edges coming-in to this node
//        }
//
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < n; i++) {
//            if (in_degree[i] == 0) {
//                queue.offer(i);
//            }
//        }
//
//        int count = 0;
//        while (!queue.isEmpty()) {
//            int element = queue.poll();
//            count++;
//            for (int neighbor : adjList[element]) {
//                in_degree[neighbor]--;
//                if (in_degree[neighbor] == 0) {
//                    queue.offer(neighbor);
//                }
//            }
//        }
//
//        return count == n;
//
//    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDegree = new int[numCourses];
        for (int[] arr : prerequisites) {
            adjList.putIfAbsent(arr[1], new ArrayList<>());
            adjList.get(arr[1]).add(arr[0]);

            inDegree[arr[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            int key = q.poll();
            count++;
            for (int neigh : adjList.getOrDefault(key, Collections.emptyList())) {
                inDegree[neigh]--;
                if (inDegree[neigh] == 0) {
                    q.offer(neigh);
                }
            }
        }
        return count == numCourses;
    }
    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        Assert.assertTrue(cs.canFinish(2, new int[][] { { 1, 0 } }));
        Assert.assertFalse(cs.canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } }));
    }

}
