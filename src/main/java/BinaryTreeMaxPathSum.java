import org.junit.Assert;

public class BinaryTreeMaxPathSum {
    int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        sum(root);
        return max;
    }

    private int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSum = Math.max(0, sum(node.left));    // notice we're using max(0, dfs()) here
        int rightSum = Math.max(0, sum(node.right));  // notice we're using max(0, dfs()) here

        max = Math.max(max, leftSum + rightSum + node.val);  // max will have left + right + root
        return Math.max(leftSum, rightSum) + node.val;       // while returning we can take only one branch, either left or right
    }

    public static void main(String[] args) {
        BinaryTreeMaxPathSum obj = new BinaryTreeMaxPathSum();
        TreeNode node = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        Assert.assertEquals(6, obj.maxPathSum(node));

        TreeNode node1 = new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        Assert.assertEquals(42, obj.maxPathSum(node1));

        TreeNode node2 = new TreeNode(-3);
        Assert.assertEquals(-3, obj.maxPathSum(node2));
    }

    /***
     * Input: [1,2,3]
     *
     *        1
     *       / \
     *      2   3
     *
     * Output: 6
     *
     *
     * Input: [-10,9,20,null,null,15,7]
     *
     *    -10
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * Output: 42
     *
     * */

    public static class TreeNode {
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
}
