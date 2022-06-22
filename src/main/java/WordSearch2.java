import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch2 {


    /**
     *
     * Time complexity:
     *  O(m * n * min(3^wl, m * n) + wl * num_words)
     *
     *      we iterate m*n times, in 3 different directions (not 4 since we mark nodes visited),
     *      wl is max-word len.
     *      to build a trie, wl * num_words time will be needed
     *
     * Space:
     *  Only additional space is to keep the trie data structure, I think it'd be wl * num_words additional soace
     * */

    TrieNode root;
    Set<String> result;  // must be a set as there might be duplicates as we dont want to return those

    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        result = new HashSet<>();
        for (String word : words) {
            insert(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, "");
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, int i, int j, String str) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;
        if (board[i][j] == '*') return;

        str += board[i][j];
        if (!startsWith(str)) return;

        if (search(str)) {
            result.add(str);
            //return;          // dont return here, as we might have a bigger string to search yet
        }

        char c = board[i][j];
        board[i][j] = '*';
        dfs(board, i+1, j, str);
        dfs(board, i-1, j, str);
        dfs(board, i, j+1, str);
        dfs(board, i, j-1, str);
        board[i][j] = c;
    }

    private void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    private boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] != null) {
                node = node.children[index];
            } else {
                return false;
            }
        }
        return node.isEndOfWord;
    }

    private boolean startsWith(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] != null) {
                node = node.children[index];
            } else {
                return false;
            }
        }
        return true;
    }

    class TrieNode {
        boolean isEndOfWord;
        TrieNode[] children = new TrieNode[26];
        TrieNode() {
            this.isEndOfWord = false;
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static void main(String[] args) {
        WordSearch2 ws = new WordSearch2();

        // testcase 1
        char[][] board = new char[][] {
                { 'o', 'a', 'a', 'n' },
                { 'e', 't', 'a', 'e' },
                { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' }
        };

        String[] words = new String[] { "oath", "pea", "eat", "rain" };

        List<String> output = ws.findWords(board, words);
        System.out.println(output);

        // testcase 2
        char[][] board2 = new char[][] {
                {'o', 'a', 'b', 'n'},
                {'o', 't', 'a', 'e'},
                {'a', 'h', 'k', 'r' },
                {'a', 'f', 'l', 'v'}
        };
        String[] words2 = new String[] { "oa", "oaa" };
        List<String> output2 = ws.findWords(board2, words2);
        System.out.println(output2);
    }

    /**
     *
     * Testcase 1:
     * Input:
     *   board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]],
     *   words = ["oath","pea","eat","rain"]
     * Output:
     *   ["eat","oath"]
     *
     *
     * Testcase 2:
     * Input:
     *   board = [["o","a","b","n"],["o","t","a","e"],["a","h","k","r"],["a","f","l","v"]]
     *   words = ["oa","oaa"]
     * Output:
     *   ["oa","oaa"]
     *
     * */
}
