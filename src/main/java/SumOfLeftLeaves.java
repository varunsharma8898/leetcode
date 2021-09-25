import org.junit.Assert;

public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }

    private int helper(TreeNode node, boolean left) {
        if (node == null) {
            return 0;
        }
        int suma = helper(node.left, true) + helper(node.right, false);
        if (left && node.left == null && node.right == null) {
            suma += node.val;
        }
        return suma;
    }

    public static void main(String[] args) {
        SumOfLeftLeaves ps = new SumOfLeftLeaves();
        Assert.assertEquals(3, ps.sumOfLeftLeaves(
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
                )
        ));
    }

    /**
     * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
     * <p>
     * 10
     * /  \
     * 5   -3
     * / \    \
     * 3   2   11
     * / \   \
     * 3  -2   1
     * <p>
     * <p>
     * Return 3. The paths that sum to 8 are:
     * 1.  5 -> 3
     * 2.  5 -> 2 -> 1
     * 3. -3 -> 11
     */

    public static class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode() {
        }

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
