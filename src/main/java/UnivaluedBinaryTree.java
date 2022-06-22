public class UnivaluedBinaryTree {

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

    public boolean isUnivalTree(TreeNode root) {
        return helper(root, root.val);
    }

    private boolean helper(TreeNode node, int val) {
        if (node == null) return true;       // imp, coz there can be null nodes in the tree
        if (node.val != val) return false;
        return helper(node.left, val) && helper(node.right, val);
    }
}
