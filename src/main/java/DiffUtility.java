public class DiffUtility {

    /**
     * LCS
     *
     * no-op  | delete
     * ----------------
     * insert | (1+no-op) if chars match, else max(insert, del)
     *
     */

    private void printDiff(String one, String two, int m, int n, int[][] dp) {
        if (m > 0 && n > 0 && one.charAt(m - 1) == two.charAt(n - 1)) {  // same char, so no diff
            printDiff(one, two, m - 1, n - 1, dp);
            System.out.print(" " + one.charAt(m - 1));
        } else if (n > 0 && dp[m][n - 1] > dp[m - 1][n]) {               // val at col > row, so char from second string got added
            printDiff(one, two, m, n - 1, dp);
            System.out.print(" +" + two.charAt(n - 1));
        } else if (m > 0 && dp[m - 1][n] > dp[m][n - 1]) {               // val at row > col, so char from first string got removed
            printDiff(one, two, m - 1, n, dp);
            System.out.print(" -" + one.charAt(m - 1));
        }
    }

    private int[][] lcs(String one, String two) {
        int m = one.length(), n = two.length();
        int[][] lookup = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                lookup[i][j] = Math.max(lookup[i][j - 1], lookup[i - 1][j]);

                if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    lookup[i][j] = Math.max(lookup[i][j], 1 + lookup[i - 1][j - 1]);
                }
            }
        }
        return lookup;
    }

    public static void main(String[] args) {
        DiffUtility du = new DiffUtility();
        String one = "abcde", two = "abef";
        int[][] lookup = du.lcs(one, two);
        System.out.println();
        du.printDiff(one, two, one.length(), two.length(), lookup); // Expected = a, b, -c, -d, e, +f
    }

}
