import org.junit.Assert;

public class UncrossedLines {

    public int maxUncrossedLines(int[] A, int[] B) {

        if (A == null || B == null || A.length == 0 && B.length == 0) {
            return 0;
        }

        int maxLines = LCS(A, B, 0, 0);

        return maxLines;
    }

    private int LCS(int[] A, int[] B, int i, int j) {
        if (i >= A.length || j >= B.length) {
            return 0;
        } else if (A[i] == B[j]) {
            return 1 + LCS(A, B, i + 1, j + 1);
        } else {
            return Math.max(LCS(A, B, i + 1, j), LCS(A, B, i, j + 1));
        }
    }

    public static void main(String[] args) {

        UncrossedLines ul = new UncrossedLines();
        Assert.assertEquals(2, ul.maxUncrossedLines(new int[] { 1, 4, 2 }, new int[] { 1, 2, 4 }));
        Assert.assertEquals(3, ul.maxUncrossedLines(new int[] { 2, 5, 1, 2, 5 }, new int[] { 10, 5, 2, 1, 5, 2 }));
        Assert.assertEquals(2, ul.maxUncrossedLines(new int[] { 1, 3, 7, 1, 7, 5 }, new int[] { 1, 9, 2, 5, 1 }));

        long startTime = System.currentTimeMillis();
        Assert.assertEquals(11, ul.maxUncrossedLines(
                new int[] { 1, 2, 4, 1, 4, 4, 3, 5, 5, 1, 4, 4, 4, 1, 4, 3, 4, 2, 4, 2 },
                new int[] { 2, 4, 1, 1, 3, 5, 2, 1, 5, 1, 2, 3, 3, 2, 1, 4, 1, 2, 5, 5 }));
        long timeTaken = System.currentTimeMillis() - startTime;
        System.out.println("Total time taken - " + timeTaken);
    }

}
