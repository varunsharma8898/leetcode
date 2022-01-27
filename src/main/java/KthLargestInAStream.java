import java.util.PriorityQueue;

import org.junit.Assert;

public class KthLargestInAStream {

    PriorityQueue<Integer> pq;

    int capacity;

    public KthLargestInAStream(int k, int[] nums) {
        pq = new PriorityQueue<>(k);
        capacity = k;
        for (int num : nums) {
            add(num);                    // v-imp, using add() instead of pq.offer() here
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > capacity) {
            pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        KthLargestInAStream obj = new KthLargestInAStream(3, new int[] { 4, 5, 8, 2 });
        Assert.assertEquals(4, obj.add(3));
        Assert.assertEquals(5, obj.add(5));
        Assert.assertEquals(5, obj.add(10));
        Assert.assertEquals(8, obj.add(9));
        Assert.assertEquals(8, obj.add(4));
    }
}
