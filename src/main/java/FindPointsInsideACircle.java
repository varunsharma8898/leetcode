import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import org.junit.Assert;

public class FindPointsInsideACircle {

    public int solution(String S, int[] X, int[] Y) {
        // find out radius of circle for each point and put in an array
        // sort the array based on radius
        // find first duplicate tag
        // all the elements before the first duplicate tag belong in a circle

        if (S == null || S.length() == 0) return 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.radius - o2.radius);
        for (int i = 0; i < S.length(); i++) {
            char tag = S.charAt(i);
            int radius = getRadius(X[i], Y[i]);
            pq.offer(new Node(tag, radius));
        }

        int count = 0;
        Map<Character, Node> nodeMap = new HashMap<>();
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            char tag = node.tag;
            if (nodeMap.containsKey(tag)) {
                int currentRadius = node.radius;
                if (nodeMap.get(tag).radius == node.radius) {
                    return count - 1;
                }
                return count;
            } else {
                nodeMap.put(tag, node);
                count++;
            }
        }

        return count;
    }

    class Node {
        int radius;
        char tag;
        Node(char tag, int radius) {
            this.tag = tag;
            this.radius = radius;
        }
    }

    // Pythagorus theorem: c2 = a2 + b2
    // I'm not taking a sqr-root here, not needed
    // but I'm still calling it a radius.
    private int getRadius(int x, int y) {
        return x * x + y * y;
    }

    public static void main(String[] args) {
        FindPointsInsideACircle obj = new FindPointsInsideACircle();
        Assert.assertEquals(3, obj.solution("ABDCA", new int[] {2, -1, -4, -3, 3},new int[] {2, -2, 4, 1, -3}));
        Assert.assertEquals(1, obj.solution("ABB", new int[] {1, -2, -2},new int[] {1, -2, 2}));
        Assert.assertEquals(0, obj.solution("CCD", new int[] {1, -1, 2},new int[] {1, -1, -2}));
        Assert.assertEquals(0, obj.solution("", new int[] {1, -1, 2},new int[] {1, -1, -2}));
    }

}
