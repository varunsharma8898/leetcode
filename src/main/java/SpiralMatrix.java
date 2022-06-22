import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int m = matrix.length, n = matrix[0].length;
        int rowStart = 0, rowEnd = m - 1;
        int colStart = 0, colEnd = n - 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd && result.size() < m * n; i++) { // v-imp to check size < m*n as we might run into duplicates at the last iteration
                result.add(matrix[rowStart][i]);
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd && result.size() < m * n; i++) { // v-imp to put check in all for loops as we dont know where it will end
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            for (int i = colEnd; i >= colStart && result.size() < m * n; i--) {
                result.add(matrix[rowEnd][i]);
            }
            rowEnd--;
            for (int i = rowEnd; i >= rowStart && result.size() < m * n; i--) {
                result.add(matrix[i][colStart]);
            }
            colStart++;
        }

        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix sm = new SpiralMatrix();
        List<Integer> res = sm.spiralOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
        Assert.assertEquals("[1, 2, 3, 6, 9, 8, 7, 4, 5]", res.toString());

        res = sm.spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } });
        Assert.assertEquals("[1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]", res.toString());
    }

}
