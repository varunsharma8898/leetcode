import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Map<String, Double>> adjList = new HashMap<>();
        int i = 0;
        for (List<String> eq : equations) {
            String from = eq.get(0);
            String to = eq.get(1);
            Double val = values[i++];
            if (!adjList.containsKey(from)) {
                adjList.put(from, new HashMap<>());
            }

            adjList.get(from).put(to, val);

            if (!adjList.containsKey(to)) {
                adjList.put(to, new HashMap<>());
            }

            adjList.get(to).put(from, 1.0 / val);
        }

        double[] result = new double[queries.size()];
        i = 0;
        for (List<String> q : queries) {
            result[i++] = findValue(q, adjList);
        }
        return result;
    }

    private double findValue(List<String> query, Map<String, Map<String, Double>> adjList) {

        Queue<Node> q = new LinkedList<>();
        String start = query.get(0);
        String end = query.get(1);

        if (!adjList.containsKey(start) || !adjList.containsKey(end)) {
            return -1.0;
        }

        q.offer(new Node(start, 1.0));

        Set<String> visited = new HashSet<>();

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.from.equals(end)) {
                return node.val;
            }
            visited.add(node.from);
            Map<String, Double> neighbours = adjList.get(node.from);
            for (String neighbour : neighbours.keySet()) {
                if (visited.contains(neighbour)) {
                    continue;
                }
                if (neighbour.equals(end)) {
                    return node.val * neighbours.get(neighbour);
                }
                q.offer(new Node(neighbour, node.val * neighbours.get(neighbour)));
            }
        }

        return -1.0;
    }

    static class Node {

        String from;

        Double val;

        Node(String from, Double val) {
            this.from = from;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        EvaluateDivision ed = new EvaluateDivision();

        List<List<String>> eqs = new ArrayList<>();
        eqs.add(new ArrayList<>(Arrays.asList("a", "b")));
        eqs.add(new ArrayList<>(Arrays.asList("b", "c")));

        double[] vals = new double[] { 2.0, 3.0 };

        List<List<String>> qrs = new ArrayList<>();
        qrs.add(new ArrayList<>(Arrays.asList("a", "c")));
        qrs.add(new ArrayList<>(Arrays.asList("b", "a")));
        qrs.add(new ArrayList<>(Arrays.asList("a", "e")));
        qrs.add(new ArrayList<>(Arrays.asList("a", "a")));
        qrs.add(new ArrayList<>(Arrays.asList("x", "x")));

        double[] res = ed.calcEquation(eqs, vals, qrs);

        System.out.println("Expected = [6.00000,0.50000,-1.00000,1.00000,-1.00000]");
        System.out.println("Result = " + Arrays.toString(res));

//        Assert.assertArrayEquals(new double[] { 6.00000, 0.50000, -1.00000, 1.00000, -1.00000 },
//                ed.calcEquation(eqs, vals, qrs));
    }

    /**
     * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
     * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
     * Explanation:
     * */
}
