import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0, candidates, target, result, new ArrayList<>());
        return result;
    }

    private void helper(int start, int[] candidates, int target, List<List<Integer>> result, ArrayList<Integer> currentPath) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<>(currentPath));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int num = candidates[i];
            if (i > start && candidates[i] == candidates[i-1]) continue; // v-imp to skip duplicates
            currentPath.add(num);
            helper(i+1, candidates, target - num, result, currentPath); // v-imp to have i+1 as start
            currentPath.remove(currentPath.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum2 cs = new CombinationSum2();
        List<List<Integer>> arr = cs.combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8);
        System.out.println(arr);

        /**
         * Expected
         * [
         * [1,1,6],
         * [1,2,5],
         * [1,7],
         * [2,6]
         * ]
         *
         * */
    }

}
