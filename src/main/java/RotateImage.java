import java.util.Arrays;

public class RotateImage {

    public void rotate(int[][] matrix) {
        // first reverse top to down
        // then swap
        reverse(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void rotateAntiClockwise(int[][] matrix) {
        // first swap
        // then reverse top to down
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        reverse(matrix);
    }

    private void reverse(int[][] matrix) {
        int last = matrix.length - 1;
        for (int i = 0; i <= last / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[last - i];
            matrix[last - i] = temp;
        }
    }

    public static void main(String[] args) {
        RotateImage ri = new RotateImage();

        System.out.println("Clockwise\n---------");
        int[][] matrix1 = new int[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        ri.printMatrix(matrix1);
        ri.rotate(matrix1);
        ri.printMatrix(matrix1);
        ri.printMatrix(new int[][] {
                { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 }
        });

        System.out.println("Anti-Clockwise\n---------");
        int[][] matrix2 = new int[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        ri.printMatrix(matrix2);
        ri.rotateAntiClockwise(matrix2);
        ri.printMatrix(matrix2);
        ri.printMatrix(new int[][] {
                { 3, 6, 9 },
                { 2, 5, 8 },
                { 1, 4, 7 }
        });
    }


    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println("---------");
    }
}
