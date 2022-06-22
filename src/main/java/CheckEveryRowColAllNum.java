import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;

public class CheckEveryRowColAllNum {

    public boolean checkValid(int[][] matrix) {
        Set<String> seen = new HashSet<>();
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < 1 || matrix[i][j] > n)
                    return false;
                if (
                        !seen.add(matrix[i][j] + "in row " + i)
                        || !seen.add(matrix[i][j] + "in col " + j)
                ) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckEveryRowColAllNum obj = new CheckEveryRowColAllNum();
        Assert.assertTrue(obj.checkValid(new int[][] {
                { 1, 2, 3 },
                { 3, 1, 2 },
                { 2, 3, 1 } }));

        Assert.assertFalse(obj.checkValid(new int[][] {
                { 1, 1, 1 },
                { 1, 2, 3 },
                { 1, 2, 3 } }));
    }
}
