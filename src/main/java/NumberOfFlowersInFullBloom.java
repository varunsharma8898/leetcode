import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.Assert;

public class NumberOfFlowersInFullBloom {


    /** sweep-line algo **/
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        /**
         * 0 = bloom
         * 1 = person
         * 2 = die
         * */

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        for (int i = 0; i < people.length; i++) {
            pq.offer(new int[] {people[i], 1, i});
        }

        for (int[] flower : flowers) {
            pq.offer(new int[] { flower[0], 0 });
            pq.offer(new int[] { flower[1], 2 });
        }

        int[] res = new int[people.length];
        int blooms = 0;
        while (!pq.isEmpty()) {
            int[] event = pq.poll();

            if (event[1] == 0) {
                blooms++;
            } else if (event[1] == 2) {
                blooms--;
            } else {
                res[event[2]] = blooms;
            }
        }
        return res;
    }


    public int[] fullBloomFlowers_bruteForce(int[][] flowers, int[] people) {
        int[] counts = new int[50001];
        Arrays.fill(counts, 0);
        for (int[] flower : flowers) {
            int start = flower[0], end = flower[1];
            for (int i = start; i <= end; i++) {
                counts[i]++;
            }
        }
        int[] res = new int[people.length];
        int i = 0;
        for (int p : people) {
            res[i] = counts[p];
            i++;
        }
        return res;
    }


    public static void main(String[] args) {
        NumberOfFlowersInFullBloom obj = new NumberOfFlowersInFullBloom();
        int[] res = obj.fullBloomFlowers(new int[][] { { 1, 10 }, { 3, 3 } }, new int[] { 3, 3, 2 });
        Assert.assertArrayEquals(new int[] {2, 2, 1}, res);
    }

}
