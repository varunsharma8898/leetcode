import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // v-imp to note the comparator logic
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> a.freq == b.freq ? b.word.compareTo(a.word) : a.freq - b.freq
        );

        for (String word : freqMap.keySet()) {
            pq.offer(new Node(word, freqMap.get(word)));
            if (pq.size() > k) pq.poll();
        }

        LinkedList<String> list = new LinkedList<>();
        while (!pq.isEmpty()) {
            list.addFirst(pq.poll().word);     /// imp to add to the first
        }
        return list;
    }

    class Node {
        int freq;
        String word;
        Node(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }

    public static void main(String[] args) {
        TopKFrequentWords obj = new TopKFrequentWords();
        System.out.println(obj.topKFrequent(new String[] { "i", "love", "leetcode", "i", "love", "coding" }, 2));
        // Expected Output: ["i","love"]

        System.out.println(obj.topKFrequent(new String[] {"the","day","is","sunny","the","the","the","sunny","is","is" }, 4));
        // Expected Output: ["the","is","sunny","day"]
    }
}
