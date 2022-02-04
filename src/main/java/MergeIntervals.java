import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {


        Arrays.sort(intervals, (a1, a2) -> a1[0] == a2[0] ? a1[1] - a2[1] : a1[0] - a2[0]);

        int start = 0, end = 1;
        List<int[]> result = new ArrayList<>();
        int[] prev = intervals[0];
        result.add(intervals[0]);

        for (int[] curr : intervals) {
            if (curr[start] <= prev[end]) { // overlap
                prev[end] = Math.max(curr[end], prev[end]);
            } else { // new interval
                prev = curr;
                result.add(curr);
            }
        }

        return result.toArray(new int[result.size()][]);

    }

    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();
        int[][] res = mi.merge(new int[][] {
                { 1, 3 },
                { 2, 6 },
                { 8, 10 },
                { 15, 18 }
        });
        System.out.println(Arrays.stream(res).map(i -> "[ " + i[0] + ", " + i[1] + " ] ").collect(Collectors.joining()));
        //Output: [[1,6],[8,10],[15,18]]
        //Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
    }
}
