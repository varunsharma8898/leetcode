import org.junit.Assert;

public class EditDistance {

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m == 0 || n == 0) {
            return Math.max(m, n);
        }

        // initialize with default values in row0 and col0
        int[][] res = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            res[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            res[0][i] = i;
        }

        // levinshtein's algo
        // if char matches, put replace val
        // else put = 1 + min (replace, delete, insert)

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int replace = res[i - 1][j - 1];
                int delete = res[i - 1][j];
                int insert = res[i][j - 1];

                int min = Math.min(replace, Math.min(delete, insert));
                res[i][j] = 1 + min;

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    res[i][j] = replace;
                }
            }
        }

        return res[m][n];
    }

    public static void main(String[] args) {
        EditDistance ed = new EditDistance();
        Assert.assertEquals(3, ed.minDistance("horse", "ros"));
    }

}
