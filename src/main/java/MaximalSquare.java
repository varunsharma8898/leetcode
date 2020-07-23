import org.junit.Assert;

public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int maxEdge = 0;
        int[][] squares = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (matrix[i-1][j-1] == '1') {
                    squares[i][j] = Math.min(Math.min(squares[i - 1][j], squares[i][j - 1]), squares[i - 1][j - 1]) + 1;
                }

                maxEdge = Math.max(squares[i][j], maxEdge);
            }
        }

        return maxEdge * maxEdge;
    }

    public static void main(String[] args) {
        MaximalSquare obj = new MaximalSquare();
        Assert.assertEquals(4, obj.maximalSquare(new char[][] {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '0', '1', '1', '1' },
                { '1', '0', '0', '1', '0' },
        }));
    }
}
