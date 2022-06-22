import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {

    private static final String SEPARATOR = ",";

    private static final String NULL_VAL = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL_VAL).append(SEPARATOR);
        } else {
            sb.append(root.val).append(SEPARATOR);
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(SEPARATOR)));

        return buildTree(q);
    }

    private TreeNode buildTree(Queue<String> q) {
        String entry = q.poll();
        if (entry.equals(NULL_VAL)) {
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.parseInt(entry));
            root.left = buildTree(q);
            root.right = buildTree(q);
            return root;
        }
    }

    public static void main(String[] args) {
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
