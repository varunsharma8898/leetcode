import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!seen.add(board[i][j] + " in row " + i)
                            || !seen.add(board[i][j] + " in column " + j)
                            || !seen.add(board[i][j] + " in gird " + i/3 + "-" + j/3)
                    ) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidSudoku vs = new ValidSudoku();
        char[][] board = new char[][] {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        Assert.assertTrue(vs.isValidSudoku(board));
    }
}
