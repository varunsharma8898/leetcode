import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Assert;

public class CourseSchedule2 {

    public int[] findOrder(int n, int[][] prerequisites) {

        ArrayList<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        int[] in_degree = new int[n];
        for (int[] arr : prerequisites) {
            if (arr.length != 2) continue;
            adjList[arr[1]].add(arr[0]);
            in_degree[arr[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (in_degree[i] == 0) queue.offer(i);
        }

        int[] result = new int[n];
        int index = 0;
        while (!queue.isEmpty()) {
            int element = queue.poll();
            result[index++] = element;

            for (int neighbor : adjList[element]) {
                in_degree[neighbor]--;
                if (in_degree[neighbor] == 0) queue.offer(neighbor);
            }
        }

        return index == n ? result : new int[0];
    }

    public static void main(String[] args) {
        CourseSchedule2 cs2 = new CourseSchedule2();
        Assert.assertArrayEquals(new int[] { 0, 1 }, cs2.findOrder(2, new int[][] { { 1, 0 } }));

        Assert.assertArrayEquals(new int[] { 0, 1, 2, 3 }, cs2.findOrder(4, new int[][] {
                { 1, 0 },
                { 2, 0 },
                { 3, 1 },
                { 3, 2 }
        }));

        Assert.assertArrayEquals(new int[] { 0 }, cs2.findOrder(1, new int[][] { { } }));
    }
}
