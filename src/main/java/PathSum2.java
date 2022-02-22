import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

    /******************** new *******************/

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, target, result, new ArrayList<Integer>());
        return result;
    }
    private void helper(TreeNode root, int target, List<List<Integer>> result, List<Integer> currentPath) {

        if (root == null) return;
        int curr = target-root.val;

        // if (curr < 0) return;
        if (root.left == null && root.right == null) {
            if (curr == 0) {
                currentPath.add(root.val);
                result.add(new ArrayList<>(currentPath));
                currentPath.remove(currentPath.size() - 1);
            }
            return;
        }

        currentPath.add(root.val);
        helper(root.left, curr, result, currentPath);
        helper(root.right, curr, result, currentPath);
        currentPath.remove(currentPath.size() - 1);

    }

    /******************** old *******************/

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum_old(TreeNode root, int sum) {
        int[] path = new int[1000];
        traverseDown(root, sum, 0, path, 0);
        return res;
    }

    private void traverseDown(TreeNode node, int sum, int val, int[] path, int index) {
        if (node == null) {
            return;
        }
        val += node.val;
        path[index] = node.val;
        index++;
        if (node.left == null && node.right == null) {
            if (val == sum) {
                List<Integer> test = new ArrayList<>();
                for (int i = 0; i < index; i++) {
                    test.add(path[i]);
                }
                res.add(test);
            }
            return;
        }
        traverseDown(node.left, sum, val, path, index);
        traverseDown(node.right, sum, val, path, index);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        PathSum2 obj = new PathSum2();
    }
}
