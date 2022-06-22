import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.junit.Assert;

import com.sun.tools.javac.util.Pair;

public class CurrencyConversion {

    public static double getRatio(String start, String end, List<Node> data) {
        Map<String, Map<String, Double>> adjList = new HashMap<>();

        for (Node node : data) {
            if (!adjList.containsKey(node.start)) adjList.put(node.start, new HashMap<>());
            adjList.get(node.start).put(node.end, node.ratio);

            if (!adjList.containsKey(node.end)) adjList.put(node.end, new HashMap<>());
            adjList.get(node.end).put(node.start, 1.0 / node.ratio);
        }

        Queue<MyPair> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(new MyPair(start, 1.0));

        while (!q.isEmpty()) {
            MyPair pair = q.poll();
            if (pair.currency.equals(end)) return pair.ratio;

            visited.add(pair.currency);
            Map<String, Double> neighbours = adjList.get(pair.currency);
            for (String neighbour : neighbours.keySet()) {
                if (visited.contains(neighbour)) continue;

                if (neighbour.equals(end)) return pair.ratio * neighbours.get(neighbour);

                q.offer(new MyPair(neighbour, pair.ratio * neighbours.get(neighbour)));
            }
        }

        return -1.0;
    }
    static class MyPair {
        String currency;
        Double ratio;
        MyPair(String currency, Double ratio) {
            this.currency = currency;
            this.ratio = ratio;
        }
    }

    public static void main(String[] args) {
        List<Node> data = new ArrayList<Node>();
        data.add(new Node("USD", "JPY", 110));
        data.add(new Node("USD", "AUD", 1.45));
        data.add(new Node("JPY", "GBP", 0.0070));
        Assert.assertEquals(1.89, getRatio("GBP", "AUD", data), 0.01);
//        System.out.println(getRatio("GBP", "AUD", data));
    }

    static class Node {
        String start;
        String end;
        double ratio;
        public Node(String s, String e, double r) {
            this.start = s;
            this.end = e;
            this.ratio = r;
        }
    }


    public static double getRatio_original(String start, String end, List<Node> data) {
        Map<String, Map<String, Double>> adjList = new HashMap<>();
        for (Node node : data) {
            if (!adjList.containsKey(node.start)) adjList.put(node.start, new HashMap<>());
            adjList.get(node.start).put(node.end, node.ratio);

            if (!adjList.containsKey(node.end)) adjList.put(node.end, new HashMap<>());
            adjList.get(node.end).put(node.start, 1.0 / node.ratio);
        }


        Queue<Pair<String, Double>> q = new LinkedList<>();
        q.offer(new Pair<>(start, 1.0));
        Set<String> visited = new HashSet<>();

        while(!q.isEmpty()) {
            Pair<String, Double> pair = q.poll();

            if (pair.fst.equals(end)) return pair.snd;

            visited.add(pair.fst);
            Map<String, Double> neighbours = adjList.get(pair.fst);

            for (String neighbour : neighbours.keySet()) {
                if (visited.contains(neighbour)) continue;
                if (neighbour.equals(end)) {
                    return neighbours.get(neighbour) * pair.snd;
                }

                q.offer(new Pair(neighbour, neighbours.get(neighbour) * pair.snd));
            }
        }
        return -1.0;
    }
}
