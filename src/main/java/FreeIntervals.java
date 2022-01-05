import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FreeIntervals {

    /**
     * Problem: Given mutiple meetings which happen within a day. Return all the time brackets of no meetings.
     * <p>
     * Input: [(2, 6), (2, 3) (8, 10), (15, 18)]
     * Output: [(1, 2), (6, 8), (10, 15), (18, 24)]
     */

    public int[][] coolFeature(int[][] a) {

        Arrays.sort(a, (a1, a2) -> a1[0] == a2[0] ? a1[1] - a2[1] : a1[0] - a2[0]);

        int len = a.length;
        List<int[]> result = new ArrayList<>();
        int start = 1, end = 24;

        for (int[] curr : a) {
            if (curr[0] > start) { // initial gap found
                result.add(new int[] { start, curr[0] });
                start = curr[1];
            } else if (curr[0] < start) { // overlap found
                start = curr[1];
            }
        }

        if (a[len - 1][1] < end) { // last gap found
            result.add(new int[] {a[len - 1][1], end});
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        FreeIntervals fi = new FreeIntervals();
        int[][] res = fi.coolFeature(new int[][] {
                { 2, 6 },
                { 2, 3 },
                { 8, 10 },
                { 15, 18 }
        });

        System.out.println(Arrays.stream(res).map(i -> "[ " + i[0] + ", " + i[1] + " ] ").collect(Collectors.joining()));
    }

}
