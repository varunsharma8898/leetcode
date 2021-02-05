import java.util.LinkedList;

import org.junit.Assert;

public class CompleteBinaryTreeInserter {

    /**
     * Complete binary tree:
     * A complete binary tree is a binary tree in which every level,
     * except possibly the last, is completely filled, and all nodes are as far left as possible.
     * A CBT is given at the time of object initialization. You just have to write code to insert node.
     *
     * NOTE: not to be confused with BST - where node.left.val < node.val and node.right.val >= node.val
     */


    private TreeNode root;
    private LinkedList<TreeNode> queue;

    public CompleteBinaryTreeInserter(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.peek();
            if (node.right != null) {  // both left and right children are present, so push them both and pop this parent node out
                queue.offer(node.left);
                queue.offer(node.right);
                queue.poll();
            } else {
                if (node.left != null) queue.offer(node.left);
                break;                 // very important to break, or it will be a forever loop
            }
        }
    }

    public int insert(int v) {
        TreeNode node = queue.peek();
        if (node.left == null) {
            node.left = new TreeNode(v);
            queue.offer(node.left);
        } else {
            node.right = new TreeNode(v);
            queue.offer(node.right);
            queue.poll();
        }
        return node.val;
    }

    public TreeNode get_root() {
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        CompleteBinaryTreeInserter cbt = new CompleteBinaryTreeInserter(root);
        Assert.assertEquals(2, cbt.insert(4));
        Assert.assertEquals(2, cbt.insert(5));
        Assert.assertEquals(root, cbt.get_root());
    }

    static class TreeNode {
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
