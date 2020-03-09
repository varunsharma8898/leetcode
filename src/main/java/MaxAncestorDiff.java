import org.junit.Assert;

public class MaxAncestorDiff {

    static class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int maxDiff = 0;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return maxDiff;
    }

    private void dfs(TreeNode node, int min, int max) {
        if (node != null) {
            min = Math.min(min, node.val);
            max = Math.max(max, node.val);
            maxDiff = Math.max(Math.abs(max - node.val), maxDiff);
            maxDiff = Math.max(Math.abs(min - node.val), maxDiff);
            dfs(node.left, min, max);
            dfs(node.right, min, max);
        }
    }

    public static void main(String[] args) {
        MaxAncestorDiff mad = new MaxAncestorDiff();

        TreeNode head = new TreeNode(8);
        head.left = new TreeNode(3);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(6);
        head.left.right.left = new TreeNode(4);
        head.left.right.right = new TreeNode(7);
        head.right = new TreeNode(10);
        head.right.right = new TreeNode(14);
        head.right.right.left = new TreeNode(13);

        int maxDiff = mad.maxAncestorDiff(head);

        Assert.assertEquals(7, maxDiff);
    }
}
