public class PathSum1 {

    public boolean hasPathSum(TreeNode root, int sum) {
        return traverseDown(root, sum, 0);
    }

    private boolean traverseDown(TreeNode node, int sum, int val) {
        if (node == null) {
            return false;
        }

        val += node.val;
        if (node.left == null && node.right == null) {
            return sum == val ? true : false;
        }
        boolean left = traverseDown(node.left, sum, val);
        boolean right = traverseDown(node.right, sum, val);
        return left || right;
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
}
