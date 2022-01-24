import java.util.HashMap;
import java.util.Map;

public class HouseRobber3 {

    Map<TreeNode, Integer> map;
    public int rob(TreeNode root) {
        if (root == null) return 0;
        map = new HashMap<>();

        return robImpl(root);
    }

    private int robImpl(TreeNode root) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);

        int count = Math.max(robInclude(root), robExclude(root));
        map.put(root, count);
        return count;
    }

    private int robInclude(TreeNode root) {
        if (root == null) return 0;
        return robExclude(root.left) + robExclude(root.right) + root.val;
    }

    private int robExclude(TreeNode root) {
        if (root == null) return 0;
        return robImpl(root.left) + robImpl(root.right); // imp - calling robImpl() to find out val
    }

    public class TreeNode {
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
