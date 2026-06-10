import java.util.LinkedList;
import java.util.Queue;

import org.junit.Assert;

public class Dota2Senate {

    public String predictPartyVictory(String senate) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        int n = 1;
        for (char c : senate.toCharArray()) {
            if (c == 'R') {
                q1.offer(n);
            } else {
                q2.offer(n);
            }
            n++;
        }
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int rad = q1.poll();
            int dir = q2.poll();
            if (rad < dir) {
                q1.offer(rad + n);
            } else {
                q2.offer(dir + n);
            }
        }
        return q1.isEmpty() ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        Dota2Senate dota2Senate = new Dota2Senate();
        Assert.assertEquals("Radiant", dota2Senate.predictPartyVictory("RD"));
        Assert.assertEquals("Dire", dota2Senate.predictPartyVictory("RDD"));
        Assert.assertEquals("Radiant", dota2Senate.predictPartyVictory("RRD"));
    }
}
