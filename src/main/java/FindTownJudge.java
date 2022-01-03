public class FindTownJudge {

    public int findJudge(int n, int[][] trust) {
        int[] visited = new int[n + 1];
        for (int[] entry : trust) {
            visited[entry[0]] -= 1;
            visited[entry[1]] += 1;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
