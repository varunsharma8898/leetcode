public class PopulateNextRightNode {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
        public Node() {}
        public Node(int _val) { val = _val; }
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) return root;
        helper(root.left, root.right);
        return root;
    }

    private void helper(Node node1, Node node2) {
        if (node1 == null) return;
        node1.next = node2;
        helper(node1.left, node1.right);
        helper(node1.right, node2.left);
        helper(node2.left, node2.right);
    }

    public static void main(String[] args) {
        PopulateNextRightNode obj = new PopulateNextRightNode();
        Node root = new Node(1,
                new Node(2, new Node(4), new Node(5), null),
                new Node(3, new Node(6), new Node(7), null),
                null);

    }
}
