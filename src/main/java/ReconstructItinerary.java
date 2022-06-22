import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary {

    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> ans = new LinkedList<>();

        Map<String, PriorityQueue<String>> adjList = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (!adjList.containsKey(from)) {
                PriorityQueue<String> pq = new PriorityQueue<>();
                adjList.put(from, pq);
            }
            adjList.get(from).offer(to);
        }

        // use dfs to find itinerary
        LinkedList<String> stack = new LinkedList<>();
        stack.addLast("JFK");
        while (!stack.isEmpty()) {
            String from = stack.peek();
            if (adjList.containsKey(from) && !adjList.get(from).isEmpty()) {
                stack.push(adjList.get(from).poll());
            } else {
                ans.addFirst(stack.pop());         // v-imp = pop
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        ReconstructItinerary ri = new ReconstructItinerary();

        /**
         *
         * Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
         * Output: ["JFK","MUC","LHR","SFO","SJC"]
         *
         * */

        List<List<String>> input = new ArrayList<>();
        input.add(Arrays.asList("MUC","LHR"));
        input.add(Arrays.asList("JFK","MUC"));
        input.add(Arrays.asList("SFO","SJC"));
        input.add(Arrays.asList("LHR","SFO"));

        List<String> itinerary = ri.findItinerary(input);

        System.out.println(itinerary);
    }
}
