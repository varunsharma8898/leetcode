import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.junit.Assert;

public class IslandPerimeterByBFS {

    Queue<String> queue;

    Set<String> visited;

    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (rows == 0 || cols == 0) {
            return 0;
        }

        queue = new LinkedList<>();
        visited = new HashSet<>();

        int perimeter = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0 || visited.contains(i + "," + j)) {
                    continue;
                }

                queue.offer(i + "," + j);
                perimeter = bfs(grid, queue);
            }
        }
        return perimeter;
    }

    private int bfs(int[][] grid, Queue queue) {

        int edges = 0;
        while (!queue.isEmpty()) {

            if (visited.contains(queue.peek())) {
                queue.poll();
                continue;
            }
            String entry = (String) queue.poll();
            visited.add(entry);
            String[] coords = entry.split(",");
            int i = Integer.parseInt(coords[0]);
            int j = Integer.parseInt(coords[1]);

            int connections = 4;
            if (i > 0 && grid[i - 1][j] == 1) {
                queue.offer((i - 1) + "," + j);
                connections--;
            }
            if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                queue.offer((i + 1) + "," + j);
                connections--;
            }
            if (j > 0 && grid[i][j - 1] == 1) {
                queue.offer(i + "," + (j - 1));
                connections--;
            }
            if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
                queue.offer(i + "," + (j + 1));
                connections--;
            }

//            edges += connectedMap.get(connections);
            edges += connections;
        }
        return edges;
    }

    public static void main(String[] args) {

        IslandPerimeterByBFS ip = new IslandPerimeterByBFS();

        int[][] grid1 = new int[][] {
                { 0, 1, 0, 0 },
                { 1, 1, 1, 0 },
                { 0, 1, 0, 0 },
                { 1, 1, 0, 0 }
        };

        Assert.assertEquals(16, ip.islandPerimeter(grid1));

        int[][] grid2 = new int[][] {
                { 1, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 }
        };

        Assert.assertEquals(4, ip.islandPerimeter(grid2));

        int[][] grid3 = new int[][] {
                { 1, 0, 0, 0 },
                { 1, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 }
        };

        Assert.assertEquals(6, ip.islandPerimeter(grid3));
    }
}
