public class SetMatrixZeros {

    public void setZeroes(int[][] matrix) {
        boolean row0 = false, col0 = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) row0 = true;
                    if (j == 0) col0 = true;
                    matrix[0][j] = 0; // set start of row to 0
                    matrix[i][0] = 0; // set start of column to 0
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row0) {
            cleanRow(matrix);
        }
        if (col0) {
            cleanCol(matrix);
        }
    }

    private void cleanCol(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = 0;
        }
    }

    private void cleanRow(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[0][i] = 0;
        }
    }

    public static void main(String[] args) {
        SetMatrixZeros obj = new SetMatrixZeros();
        int[][] matrix = new int[][] {
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 }
        };
        obj.setZeroes(matrix);
        System.out.println(matrix);
    }
}
