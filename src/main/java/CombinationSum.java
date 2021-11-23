import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0, candidates, target, result, new ArrayList<>());
        return result;
    }

    private void helper(int start, int[] candidates, int target, List<List<Integer>> result, ArrayList<Integer> currentPath) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(currentPath)); // v imp to use ** new ArrayList() ** here
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int num = candidates[i];
            currentPath.add(num);
            helper(i, candidates, target - num, result, currentPath);
            currentPath.remove(currentPath.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        List<List<Integer>> arr = cs.combinationSum(new int[] { 2, 3, 6, 7 }, 7);
        System.out.println(arr);

        /**
         * Expected:
         * [[2, 2, 3], [7]]
         * */
    }
}
