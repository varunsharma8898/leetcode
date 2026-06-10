import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.junit.Assert;

public class WordLadder {

    private int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || !wordList.contains(endWord)) {
            return 0;
        }

        Set<String> bankSet = new HashSet<>();
        Set<Character> allowedChars = new HashSet<>();
        Set<String> visited = new HashSet<>();

        for (String word : wordList) {
            bankSet.add(word);
            for (char c : word.toCharArray()) {
                allowedChars.add(c);
            }
        }

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int level = 1;                      // yes, start with 1, not 0
        while (!q.isEmpty()) {
            int len = q.size();
            for (int j = 0; j < len; j++) {
                String currWord = q.poll();
                if (currWord.equals(endWord)) return level;
                visited.add(currWord);

                char[] curr = currWord.toCharArray();
                for (int i = 0; i < endWord.length(); i++) {
                    char tmp = curr[i];
                    for (char c : allowedChars) {
                        curr[i] = c;
                        String next = new String(curr);
                        if (bankSet.contains(next) && !visited.contains(next)) {
                            q.offer(next);
                        }
                    }
                    curr[i] = tmp;
                }
            }
            level++;
        }

        return 0;
    }

    public static void main(String[] args) {
        WordLadder wl = new WordLadder();
        Assert.assertEquals(5, wl.ladderLength("hit", "cog",
                Arrays.asList("hot", "dog", "dot", "lot", "log", "cog")));

        Assert.assertEquals(0, wl.ladderLength("hit", "cog",
                Arrays.asList("hot", "dog", "dot", "lot", "log")));
    }
}
