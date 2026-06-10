import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.junit.Assert;

public class MinimumGeneticMutation {

    private int minMutation(String startGene, String endGene, String[] bank) {
        char[] allowedChars = new char[] { 'A', 'C', 'G', 'T' };

        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(startGene);
        int level = 0;

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                String currGene = q.poll();
                if (currGene.equals(endGene)) {
                    return level;
                }
                char[] curr = currGene.toCharArray();
                visited.add(currGene);
                for (int j = 0; j < endGene.length(); j++) {
                    char tmp = curr[j];
                    for (char c : allowedChars) {
                        curr[j] = c;
                        String next = new String(curr);
                        if (bankSet.contains(next) && !visited.contains(next)) {
                            q.offer(next);
                        }
                    }
                    curr[j] = tmp;
                }
            }
            level++; // must not increase at the start, always at the end
        }

        return -1;
    }

    public static void main(String[] args) {
        MinimumGeneticMutation mg = new MinimumGeneticMutation();
        Assert.assertEquals(1, mg.minMutation("AACCGGTT", "AACCGGTA", new String[] { "AACCGGTA" }));
        Assert.assertEquals(2, mg.minMutation("AACCGGTT", "AAACGGTA", new String[] {
                "AACCGGTA", "AACCGCTA", "AAACGGTA" }));
    }

}
