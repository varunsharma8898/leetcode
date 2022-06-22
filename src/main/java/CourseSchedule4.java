import java.util.ArrayList;
import java.util.List;

public class CourseSchedule4 {

    /**
     * Idea
     * - This problem is to check if 2 vertices are connected in directed graph.
     * - Floyd-Warshall O(n^3) is an algorithm that will output the min distance of any vertices. We can modify it to output if any vertices are connected or not.
     *
     * Complexity:
     * - Time: O(n^3)
     * - Space: O(n^2)
     *
     * More Floy-warshall problems:
     * - 1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance
     */
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] hasPath = new boolean[n][n];
        for (int[] pre : prerequisites) {
            hasPath[pre[0]][pre[1]] = true;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    hasPath[i][j] = hasPath[i][j] || hasPath[i][k] && hasPath[k][j];
                }
            }
        }

        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            ans.add(hasPath[query[0]][query[1]]);
        }
        return ans;
    }

    public static void main(String[] args) {
        CourseSchedule4 cs = new CourseSchedule4();

    }
}
