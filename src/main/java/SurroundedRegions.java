import java.util.Arrays;

public class SurroundedRegions {

    public void solve(char[][] board) {

        if (board.length == 0 || board[0].length == 0
                || board.length < 2 || board[0].length < 2) {
            return;
        }

        int m = board.length - 1;
        int n = board[0].length - 1;
        for (int i = 0; i <= m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n] == 'O') {
                dfs(board, i, n);
            }
        }
        for (int i = 0; i <= n; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[m][i] == 'O') {
                dfs(board, m, i);
            }
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[i].length - 1 || board[i][j] == 'X') {
            return;
        }
        if (board[i][j] == 'O') {
            board[i][j] = '*';
        }

        if (i > 1 && board[i - 1][j] == 'O') {
            dfs(board, i - 1, j);       // left
        }

        if (i < board.length - 2 && board[i + 1][j] == 'O') {
            dfs(board, i + 1, j);       // right
        }

        if (j > 1 && board[i][j - 1] == 'O') {
            dfs(board, i, j - 1);       // up
        }

        if (j < board[i].length - 2 && board[i][j + 1] == 'O') {
            dfs(board, i, j + 1);       // down
        }
    }

    public static void main(String[] args) {

        SurroundedRegions sr = new SurroundedRegions();
        char[][] board1 = new char[4][4];
        board1[0] = new char[] { 'X', 'X', 'X', 'X' };
        board1[1] = new char[] { 'X', 'O', 'O', 'X' };
        board1[2] = new char[] { 'X', 'X', 'O', 'X' };
        board1[3] = new char[] { 'X', 'O', 'X', 'X' };

        sr.printBoard(board1);
        sr.solve(board1);
        sr.printBoard(board1);

//        X X X X
//        X O O X
//        X X O X
//        X O X X
    }

    private void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println("------------");
    }
}
