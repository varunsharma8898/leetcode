import org.junit.Assert;

public class LongestIncreasingPath {

    public int longestIncreasingPath(int[][] matrix) {
        int maxLen = 0;
        int N = matrix.length;
        int M = matrix[0].length;
        int[][] cache = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maxLen = Math.max(maxLen, helper(matrix, cache, i, j, -1));
            }
        }
        return maxLen;
    }

    private int helper(int[][] matrix, int[][] cache, int i, int j, int prev) {
        int res = 0;
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length
                || matrix[i][j] <= prev
        ) {
            return res;
        }

        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        res++;

        int down = helper(matrix, cache, i + 1, j, matrix[i][j]); //down
        int up = helper(matrix, cache, i - 1, j, matrix[i][j]); //up
        int right = helper(matrix, cache, i, j + 1, matrix[i][j]); //right
        int left = helper(matrix, cache, i, j - 1, matrix[i][j]); //left

        res += Math.max(Math.max(up, down), Math.max(left, right));
        cache[i][j] = res;
        return res;
    }

    public static void main(String[] args) {
        LongestIncreasingPath obj = new LongestIncreasingPath();
        Assert.assertEquals(4, obj.longestIncreasingPath(new int[][] {
                { 9, 9, 4 },
                { 6, 6, 8 },
                { 2, 1, 1 }
        }));
    }
}
