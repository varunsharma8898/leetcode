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

        for (int i = 1; i <= m; i++) {              // imp = i from 1 to m
            for (int j = 1; j <= n; j++) {          // imp = j from 1 to n

                if (matrix[i - 1][j - 1] == '1') {      // imp i-1 and j-1
                    squares[i][j] = Math.min(Math.min(squares[i - 1][j], squares[i][j - 1]), squares[i - 1][j - 1]) + 1;
                }

                maxEdge = Math.max(squares[i][j], maxEdge);
            }
        }

        return maxEdge * maxEdge;                   // imp square = edge * edge
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

    /**
     *
     * Similar to edit distance, but with a twist (instead of putting replace value if chars match,
     *   we are putting 1+min val and no default val if chars dont match).
     *
     *
     * If char is 1, put (1 + min of all 3 neighbours).
     * finally, get the max value in the dp array.
     *
     * See example below:
     *
     * first:
     *
     * 10100
     * 10111
     * 10111
     * 10010
     *
     * second:
     *
     * 10100
     * 10111
     * 10122
     * 10010
     *
     *
     * */
}
