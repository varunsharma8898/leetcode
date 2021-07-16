public class TriePrefixTree {

    TrieNode root;

    static class TrieNode {
        boolean isEndOfWord;
        TrieNode[] children = new TrieNode[26];
        TrieNode() {
            this.isEndOfWord = false;
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public TriePrefixTree() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        int len = word.length();
        for (int level = 0; level < len; level++) {
            int index = word.charAt(level) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (int level = 0; level < word.length(); level++) {
            int index = word.charAt(level) - 'a';
            if (node.children[index] != null) {
                node = node.children[index];
            } else {
                return false;
            }
        }
        return node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int level = 0; level < prefix.length(); level++) {
            int index = prefix.charAt(level) - 'a';
            if (node.children[index] != null) {
                node = node.children[index];
            } else {
                return false;
            }
        }
        return true;
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
