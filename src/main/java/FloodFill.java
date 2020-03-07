import java.util.Arrays;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if (image.length == 0 || image[0].length == 0 || image[sr][sc] == newColor) {
            return image;
        }

        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void dfs(int[][] image, int x, int y, int oldColor, int newColor) {
        if (x < 0 || x >= image.length
                || y < 0 || y >= image[0].length
                || image[x][y] != oldColor
        ) {
            return;
        }

        image[x][y] = newColor;
        dfs(image, x - 1, y, oldColor, newColor);
        dfs(image, x + 1, y, oldColor, newColor);
        dfs(image, x, y - 1, oldColor, newColor);
        dfs(image, x, y + 1, oldColor, newColor);
    }

    public static void main(String[] args) {
        FloodFill ff = new FloodFill();

        int[][] image1 = new int[][] {
                { 0, 1, 0, 0 },
                { 1, 1, 1, 0 },
                { 0, 1, 0, 0 },
                { 1, 1, 0, 1 }
        };

        ff.printBoard(image1);
        ff.floodFill(image1, 1, 1, 1);
        ff.printBoard(image1);

        int[][] image2 = new int[][] {
                { 0, 1, 0, 0 },
                { 1, 1, 1, 0 },
                { 0, 1, 0, 0 },
                { 1, 1, 0, 1 }
        };

        ff.printBoard(image2);
        ff.floodFill(image2, 1, 1, 2);
        ff.printBoard(image2);
    }

    private void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println("------------");
    }
}
