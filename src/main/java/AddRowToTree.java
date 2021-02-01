import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AddRowToTree {

    static class TreeNode {
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

    public TreeNode addOneRow(TreeNode root, int v, int d) {

        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        queue1.addLast(root);
        int i = 1;
        while (!queue1.isEmpty() && i < d) {
            TreeNode node = queue1.pop();
            queue2.addLast(node.left);
            queue2.addLast(node.right);
            if (queue1.isEmpty()) {
                queue1.addAll(queue2);
                queue2.clear();
                i++;
            }
        }
        if (i == d) {
            while (!queue1.isEmpty()) {
                TreeNode node = queue1.pop();

            }
        }
        return root;
    }



    public static void main(String[] args) {
        AddRowToTree obj = new AddRowToTree();

        TreeNode root = new TreeNode(4,
                new TreeNode(2, new TreeNode(3), new TreeNode(1)),
                new TreeNode(6, new TreeNode(5), null));


        obj.printPretty(root, "");

    }


    private void printPretty(TreeNode focusNode, String prefix) {
        if (focusNode != null) {
            System.out.println(prefix + "├── " + focusNode.val);
            printPretty(focusNode.left, prefix + "│  (L) ");
            printPretty(focusNode.right, prefix + "│  (R) ");
        }
    }

/**
 *
 *        4
 *      /   \
 *     2     6
 *    / \   /
 *   3   1 5
 *
 * */

}
