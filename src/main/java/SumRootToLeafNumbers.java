import org.junit.Assert;

public class SumRootToLeafNumbers {

    int sum = 0;

    public int sumNumbers(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sum;
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        sb.append(root.val + "");
        if (root.left == null && root.right == null) {
            sum += Integer.parseInt(sb.toString());
        }
        dfs(root.left, new StringBuilder(sb.toString()));
        dfs(root.right, new StringBuilder(sb.toString()));
    }

    public static void main(String[] args) {
        SumRootToLeafNumbers obj = new SumRootToLeafNumbers();
        TreeNode node = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        Assert.assertEquals(25, obj.sumNumbers(node));
    }

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
