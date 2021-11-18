import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

    // BFS
    public Node cloneGraph(Node root) {
        if (root == null) return null;

        Node clone = new Node(root.val);
        Map<Node, Node> nodeMap = new HashMap<>();
        nodeMap.put(root, clone);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for (Node neighbor : curr.neighbors) {
                if (!nodeMap.containsKey(neighbor)) {
                    nodeMap.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                nodeMap.get(curr).neighbors.add(nodeMap.get(neighbor));
            }
        }

        return clone;
    }

    public Node cloneGraphDFS(Node root) {
        Map<Node, Node> map = new HashMap<>();
        return cloneDfs(root, map);
    }

    private Node cloneDfs(Node node, Map<Node, Node> map) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        Node clone = new Node(node.val);
        map.put(node, clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneDfs(neighbor, map));
        }
        return clone;
    }

    class Node {
        int val;
        List<Node> neighbors;
        Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
        Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
