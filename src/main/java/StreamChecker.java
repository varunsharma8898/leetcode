import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

public class StreamChecker {

    private static final int ALPHABET_SIZE = 26;

    TrieNode root;

    List<Character> history;

    static class TrieNode {

        boolean isEndOfWord;

        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        TrieNode() {
            this.isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                children[i] = null;
            }
        }
    }

    public void insert(String key) {
        TrieNode node = root;
        for (int level = key.length() - 1; level >= 0; level--) {
            int charIndex = key.charAt(level) - 'a';
            if (node.children[charIndex] == null) {
                node.children[charIndex] = new TrieNode();
            }
            node = node.children[charIndex];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String key) {
        TrieNode node = root;
        for (int level = key.length() - 1; level >= 0; level--) {
            int charIndex = key.charAt(level) - 'a';
            if (node.children[charIndex] != null) {
                node = node.children[charIndex];
            } else {
                return false;
            }
        }
        return node.isEndOfWord;
    }

    public StreamChecker(String[] words) {
        this.root = new TrieNode();
        this.history = new ArrayList<>();
        for (String word : words) {
            this.insert(word);
        }
    }

    public boolean query(char letter) {
        history.add(letter);
        TrieNode p = root;
        for (int i = history.size() - 1; i >= 0; i--) {
            char c = history.get(i);
            //return false immediately when we can't find c in Trie
            if (p.children[c - 'a'] == null) {
                return false;
            }
            //find a word
            if (p.children[c - 'a'].isEndOfWord) {
                return true;
            }
            p = p.children[c - 'a'];
        }

        return false;
    }

    /**
     * Your StreamChecker object will be instantiated and called as such:
     * StreamChecker obj = new StreamChecker(words);
     * boolean param_1 = obj.query(letter);
     */
    public static void main(String[] args) {
        StreamChecker streamChecker = new StreamChecker(new String[] { "cd", "f", "kl" }); // init the dictionary.
        Assert.assertFalse(streamChecker.query('a'));          // return false
        Assert.assertFalse(streamChecker.query('b'));          // return false
        Assert.assertFalse(streamChecker.query('c'));          // return false
        Assert.assertTrue(streamChecker.query('d'));         // return true, because 'cd' is in the wordlist
        Assert.assertFalse(streamChecker.query('e'));          // return false
        Assert.assertTrue(streamChecker.query('f'));         // return true, because 'f' is in the wordlist
        Assert.assertFalse(streamChecker.query('g'));          // return false
        Assert.assertFalse(streamChecker.query('h'));          // return false
        Assert.assertFalse(streamChecker.query('i'));          // return false
        Assert.assertFalse(streamChecker.query('j'));          // return false
        Assert.assertFalse(streamChecker.query('k'));          // return false
        Assert.assertTrue(streamChecker.query('l'));         // return true, because 'kl' is in the wordlist
    }
}
