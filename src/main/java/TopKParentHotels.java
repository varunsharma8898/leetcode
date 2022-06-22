import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKParentHotels {

    private int[][] getTopKParentHotels(int[][] arr, int k) {

        Map<Integer, Node> nodeMap = new HashMap<>();
        for (int[] entry : arr) {
            Node clone = new Node(entry[0], entry[1], entry[2]);
            nodeMap.put(entry[0], clone);
        }

        List<Node> parents = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.score - o2.score);

        for (Integer key : nodeMap.keySet()) {
            Node curr = nodeMap.get(key);
            Node node = findParent(curr, nodeMap);
            if (node == null) {
                parents.add(curr);
                pq.offer(curr);
                if (pq.size() > k) pq.poll();
            } else {
                node.score += curr.score;
            }
        }
//
//        System.out.println(parents);
//        System.out.println(pq);

        int[][] result = new int[2][2];
        int i = k-1;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            result[i--] = new int[] { node.parentId, node.score };
        }
        return result;
    }

    private Node findParent(Node node, Map<Integer, Node> nodeMap) {
        Node head = node;
        while (nodeMap.containsKey(head.parentId)) {
            head = nodeMap.get(head.parentId);
        }
        return head == node ? null : head;
    }

    class Node {
        int id;
        int parentId;
        int score;
        Node(int id, int parentId, int score) {
            this.id = id;
            this.parentId = parentId;
            this.score = score;
        }
    }

    public static void main(String[] args) {
        TopKParentHotels obj = new TopKParentHotels();
        int[][] result = obj.getTopKParentHotels(new int[][] {
                { 0, 1, 10 },
                { 1, 2, 20 },
                { 3, 4, 10 },
                { 7, 8, 5 }
        }, 2);

        System.out.println(result);
        // expected [[2, 30], [4,10]]
    }
}
