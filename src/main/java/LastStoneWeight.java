import java.util.PriorityQueue;

import org.junit.Assert;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int stone : stones) pq.offer(stone);

        while (!pq.isEmpty()) {
            if (pq.size() == 1) return pq.poll();
            int one = pq.poll();
            int two = pq.poll();
            pq.offer(one - two);
        }
        return 0;
    }

    public static void main(String[] args) {
        LastStoneWeight o = new LastStoneWeight();
        Assert.assertEquals(1, o.lastStoneWeight(new int[] { 2, 7, 4, 1, 8, 1 }));
    }
}
