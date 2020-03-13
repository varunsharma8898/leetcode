import org.junit.Assert;

public class UncrossedLinesDP {

    public int maxUncrossedLines(int[] A, int[] B) {

        if (A == null || B == null || A.length == 0 && B.length == 0) {
            return 0;
        }

        int[][] res = new int[A.length + 1][B.length + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                res[i][j] = Math.max(res[i - 1][j], res[i][j - 1]);
                if (A[i - 1] == B[j - 1]) {
                    res[i][j] = Math.max(res[i][j], res[i - 1][j - 1] + 1);
                }
            }
        }
        return res[A.length][B.length];
    }

    public static void main(String[] args) {

        UncrossedLinesDP ul = new UncrossedLinesDP();
        Assert.assertEquals(2, ul.maxUncrossedLines(new int[] { 1, 4, 2 }, new int[] { 1, 2, 4 }));
        Assert.assertEquals(3, ul.maxUncrossedLines(new int[] { 2, 5, 1, 2, 5 }, new int[] { 10, 5, 2, 1, 5, 2 }));
        Assert.assertEquals(2, ul.maxUncrossedLines(new int[] { 1, 3, 7, 1, 7, 5 }, new int[] { 1, 9, 2, 5, 1 }));

        long startTime = System.currentTimeMillis();
        Assert.assertEquals(11, ul.maxUncrossedLines(
                new int[] { 1, 2, 4, 1, 4, 4, 3, 5, 5, 1, 4, 4, 4, 1, 4, 3, 4, 2, 4, 2 },
                new int[] { 2, 4, 1, 1, 3, 5, 2, 1, 5, 1, 2, 3, 3, 2, 1, 4, 1, 2, 5, 5 }));
        long timeTaken = System.currentTimeMillis() - startTime;

        System.out.println("Total time take - " + timeTaken);
    }
}
