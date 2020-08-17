import org.junit.Assert;

public class WordDictionary {

    private TrieNode root;

    static class TrieNode {

        boolean isEndOfWord;

        TrieNode[] next;

        TrieNode() {
            isEndOfWord = false;
            next = new TrieNode[26];
        }
    }

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        this.root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TrieNode();
            }
            node = node.next[c - 'a'];
        }
        node.isEndOfWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int level, TrieNode node) {
        if (level == word.length()) {
            return node.isEndOfWord;
        }
        char c = word.charAt(level);
        if (c != '.') {
            return (node.next[c - 'a'] != null && searchHelper(word, level + 1, node.next[c - 'a']));
        } else {
            for (int i = 0; i < node.next.length; i++) {
                if (node.next[i] != null) {
                    if (searchHelper(word, level + 1, node.next[i])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        Assert.assertFalse(wordDictionary.search("pad")); // return False
        Assert.assertTrue(wordDictionary.search("bad")); // return True
        Assert.assertTrue(wordDictionary.search(".ad")); // return True
        Assert.assertTrue(wordDictionary.search("b..")); // return True
    }
}
