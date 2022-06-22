import java.util.Arrays;

public class SpiralMatrix2 {

    public int[][] generateMatrix(int n) {
        if (n == 0) return new int[][] {};
        if (n == 1) return new int[][] {{1}};

        int[][] res = new int[n][n];

        int rowStart = 0, rowEnd = n - 1;
        int colStart = 0, colEnd = n - 1;
        int size = n * n;

        int val = 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd && val <= size; i++) {
                res[rowStart][i] = val++;
            }
            rowStart++;

            for (int i = rowStart; i <= rowEnd && val <= size; i++) {
                res[i][colEnd] = val++;
            }
            colEnd--;

            for (int i = colEnd; i >= colStart && val <= size; i--) {
                res[rowEnd][i] = val++;
            }
            rowEnd--;

            for (int i = rowEnd; i >= rowStart && val <= size; i--) {
                res[i][colStart] = val++;
            }
            colStart++;
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralMatrix2 sm = new SpiralMatrix2();
        int[][] res = sm.generateMatrix(20);
        for (int[] row : res) System.out.println(Arrays.toString(row));
    }

}
