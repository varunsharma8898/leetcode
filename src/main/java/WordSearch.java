public class WordSearch {


    /**
     * Time complexity:  O(M * N * 3^L)
     *  where m = row.len, n = col.len, L = word.len
     *  3^L because we mark node visited and so we move in only 3 directions effectively.
     *
     * Space complexity: no additional space used, but since it is dfs using recursion,
     * the recursion will open space on call stack, which consumes additional space.
     * The space is O(size of board)
     *
     * */
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {    // imp to return true here
            return true;
        }
        if (
            i < 0 || j < 0
            || i >= board.length || j >= board[0].length
            || board[i][j] != word.charAt(index)
            || board[i][j] == '*'
        ) {
            return false;
        }
        char c = board[i][j];     // keep a copy
        board[i][j] = '*';        // mark visited
        boolean exists = dfs(board, word, i + 1, j, index + 1)
                || dfs(board, word, i - 1, j, index + 1)
                || dfs(board, word, i, j + 1, index + 1)
                || dfs(board, word, i, j - 1, index + 1);

        board[i][j] = c;          // backtrack, put back copied char
        return exists;

    }
}
