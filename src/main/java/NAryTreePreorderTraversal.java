import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NAryTreePreorderTraversal {

    static class Node {
        public int val;
        public List<Node> children;
        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    // Non-recursive
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            if (node.children != null) {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                }
            }
        }
        return res;
    }

    // DFS
    public List<Integer> preorderRecursive(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            res.add(root.val);
            if (root.children != null) {
                for (Node node : root.children) {
                    res.addAll(preorderRecursive(node));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NAryTreePreorderTraversal obj = new NAryTreePreorderTraversal();
        Node node = getTestData();
        System.out.println(obj.preorderRecursive(node));
        System.out.println(obj.preorder(node));
    }

    private static Node getTestData() {
        Node root = new Node(1);
        List<Node> children = new ArrayList<>();
        for (int i : new int[] {2, 3, 4, 5}) {
            Node node = new Node(i);
            if (i == 3) {
                List<Node> childrenOf3 = new ArrayList<>();
                childrenOf3.add(new Node(6));
                childrenOf3.add(new Node(7));
                node.children = childrenOf3;
            } else if (i == 4) {
                List<Node> childrenOf4 = new ArrayList<>();
                childrenOf4.add(new Node(8));
                childrenOf4.add(new Node(9));
                node.children = childrenOf4;
            }
            children.add(node);
        }
        root.children = children;
        return root;
    }
}
