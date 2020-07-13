public class SmallestStringFromLeafNode {

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

    String minStr = "~";
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return minStr;
    }

    private void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append((char) (node.val + 'a'));
        if (node.left == null && node.right == null) {
            String val = sb.reverse().toString();
            if (val.compareTo(minStr) < 0) minStr = val;
            sb.reverse();
        }
        dfs(node.left, sb);
        dfs(node.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

}
