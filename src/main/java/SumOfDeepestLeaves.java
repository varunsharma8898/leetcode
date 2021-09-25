import java.util.LinkedList;
import java.util.Queue;

import org.junit.Assert;

public class SumOfDeepestLeaves {

    public int deepestLeavesSum(TreeNode root) {
        int maxHeight = getMaxTreeHeight(root);
        return getSumOfDeepestLeavesDFS(root, 1, maxHeight);
    }

    private int getSumOfDeepestLeavesDFS(TreeNode root, int height, int maxHeight) {

        if (root == null) {
            return 0;
        }
        if (height == maxHeight) {
            return root.val;
        }

        return getSumOfDeepestLeavesDFS(root.left, height + 1, maxHeight)
                + getSumOfDeepestLeavesDFS(root.right, height + 1, maxHeight);
    }

    private int getMaxTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + Math.max(getMaxTreeHeight(root.left), getMaxTreeHeight(root.right));
    }


    public int deepestLeavesSumBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            sum = 0;                                     // reset sum for each level
            int qlength = queue.size();                  // get number of nodes for each level
            for (int i = 0; i < qlength; i++) {          // only process nodes in the current level
                TreeNode node = queue.poll();
                sum += node.val;                         // sum of nodes at current level only, will be reset in next level
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return sum;
    }



    public static void main(String[] args) {
        SumOfDeepestLeaves obj = new SumOfDeepestLeaves();
        TreeNode node = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(7),
                                null),
                        new TreeNode(5)),
                new TreeNode(3,
                        null,
                        new TreeNode(6,
                                null,
                                new TreeNode(8))));

        Assert.assertEquals(15, obj.deepestLeavesSum(node));
        Assert.assertEquals(15, obj.deepestLeavesSumBFS(node));
    }

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
