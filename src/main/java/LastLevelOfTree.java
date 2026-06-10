import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.junit.Assert;

public class LastLevelOfTree {

    // BFS - level order traversal
    private List<Integer> getLastLevelOfTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Integer> items = null;
        while (!q.isEmpty()) {
            int len = q.size();
            items = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode item = q.poll();
                items.add(item.val);
                if (item.left != null) q.offer(item.left);
                if (item.right != null) q.offer(item.right);
            }
//            if (q.size() == 0) return items;
        }
        return items;
    }


    // DFS - depth first search approach - not ideal for this type of problems
    int max = 0;
    private List<Integer> getLastLevelOfTreeDfs(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        max = 0;
        helper(root, map, 0);
        return map.get(max);
    }
    private void helper(TreeNode node, Map<Integer, List<Integer>> map, int level) {
        map.putIfAbsent(level, new ArrayList<>());
        map.get(level).add(node.val);
        max = Math.max(max, level);
        if (node.left != null) {
            helper(node.left, map, level + 1);
        }
        if (node.right != null) {
            helper(node.right, map, level + 1);
        }
    }

    public static void main(String[] args) {
        LastLevelOfTree obj = new LastLevelOfTree();
        Assert.assertEquals("[1, 3, 6, 7]", obj.getLastLevelOfTree(getTestData1()).toString());
        Assert.assertEquals("[6, 7]", obj.getLastLevelOfTree(getTestData2()).toString());
        Assert.assertEquals("[1, 3]", obj.getLastLevelOfTree(getTestData3()).toString());
        Assert.assertEquals("[1, 6, 7]", obj.getLastLevelOfTree(getTestData4()).toString());

        Assert.assertEquals("[1, 3, 6, 7]", obj.getLastLevelOfTreeDfs(getTestData1()).toString());
        Assert.assertEquals("[6, 7]", obj.getLastLevelOfTreeDfs(getTestData2()).toString());
        Assert.assertEquals("[1, 3]", obj.getLastLevelOfTreeDfs(getTestData3()).toString());
        Assert.assertEquals("[1, 6, 7]", obj.getLastLevelOfTreeDfs(getTestData4()).toString());
    }

    private static TreeNode getTestData1() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        return root;
    }

    private static TreeNode getTestData2() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        return root;
    }

    private static TreeNode getTestData3() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        return root;
    }

    private static TreeNode getTestData4() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

}
/**
 * Print last level of a tree
 *
 *      5
 *    /   \
 *   2     8
 *  / \   / \
 * 1   3 6   7
 *
 * Output: 1 3 6 7
 *
 *
 *      5
 *    /   \
 *   2     8
 *  / \
 * 1   3
 *
 * Output: 1 3
 *
 *
 *      5
 *    /   \
 *   2     8
 *        / \
 *       6   7
 *
 * Output: 6 7
 *
 *
 * 2 approaches: BFS (easy), DFS (moderate)
 * */
