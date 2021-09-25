import org.junit.Assert;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // given binary search tree
        if (root.val < p.val && root.val < q.val ) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        LowestCommonAncestor lca = new LowestCommonAncestor();

        TreeNode node1 = getTestData1();
        Assert.assertEquals(node1, lca.lowestCommonAncestor(node1, node1.left, node1.right));
        Assert.assertEquals(node1.left, lca.lowestCommonAncestor(node1, node1.left, node1.left.right));
    }

    private static TreeNode getTestData1() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        return root;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
