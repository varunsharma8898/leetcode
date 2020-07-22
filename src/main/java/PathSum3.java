import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

public class PathSum3 {

    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1); // very important
        return helper(root, 0, sum, map);
    }

    private int helper(TreeNode node, int sum, int target, Map<Integer, Integer> map) {
        if (node == null) {
            return 0;
        }

        sum += node.val;
        int numPathToCurr = map.getOrDefault(sum - target, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        int count = numPathToCurr + helper(node.left, sum, target, map)
                + helper(node.right, sum, target, map);

        map.put(sum, map.get(sum) - 1);
        return count;
    }

    public static void main(String[] args) {
        PathSum3 ps = new PathSum3();
        Assert.assertEquals(3, ps.pathSum(
                new TreeNode(
                        10,
                        new TreeNode(
                                5,
                                new TreeNode(
                                        3,
                                        new TreeNode(3),
                                        new TreeNode(-2)),
                                new TreeNode(2, null, new TreeNode(1))),
                        new TreeNode(
                                -3,
                                null,
                                new TreeNode(11))
                ), 8
        ));
    }

    /**
     * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
     *
     *         10
     *        /  \
     *       5   -3
     *      / \    \
     *    3   2   11
     *   / \   \
     *  3  -2   1
     *
     *
     * Return 3. The paths that sum to 8 are:
     * 1.  5 -> 3
     * 2.  5 -> 2 -> 1
     * 3. -3 -> 11
     */

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
