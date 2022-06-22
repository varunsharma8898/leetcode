import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

public class CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(1, k, n, result, new ArrayList<>());
        return result;
    }

    private void helper(int start, int end, int target, List<List<Integer>> result, ArrayList<Integer> currentPath) {
        if (target < 0 || currentPath.size() > end) return;
        if (target == 0 && currentPath.size() == end) {
            result.add(new ArrayList<>(currentPath));
            return;
        }

        for (int i = start; i < 10; i++) {
            currentPath.add(i);
            helper(i+1, end, target - i, result, currentPath);
            currentPath.remove(currentPath.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum3 cs3 = new CombinationSum3();
        Assert.assertEquals("[[1, 2, 4]]", cs3.combinationSum3(3, 7).toString());
    }
}
