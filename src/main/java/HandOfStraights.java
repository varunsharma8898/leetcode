import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Assert;

public class HandOfStraights {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(Math::abs));
        for (int i : hand) {
            pq.offer(i);
        }

        while (!pq.isEmpty()) {
            int num = pq.peek();
            for (int i = 0; i < groupSize; i++) {
                if (!pq.remove(num + i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        HandOfStraights obj = new HandOfStraights();
        Assert.assertTrue(obj.isNStraightHand(new int[] { 1, 2, 3, 6, 2, 3, 4, 7, 8 }, 3));
    }
}
