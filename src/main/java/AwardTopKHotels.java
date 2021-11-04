import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class AwardTopKHotels {
    public static final int TEST = 24 * 60 * 60 * 1000;


    public List<Integer> getTopKHotelsByReviews(
            String positivesStr, String negativesStr,
            List<Integer> hotelIds,
            List<String> reviews,
            int k
    ) {


        Set<String> positives = new HashSet<>();
        for (String s : positivesStr.split(" ")) {
            // TODO: remove punctuation marks
            positives.add(s);
        }
        Set<String> negatives = new HashSet<>();
        for (String s : negativesStr.split(" ")) {
            // TODO: remove punctuation marks
            negatives.add(s);
        }

        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.score - o2.score);
        for (int i = 0; i < hotelIds.size(); i++) {
            int hotel = hotelIds.get(i);
            String review = reviews.get(i);
            int score = calculateScore(review, positives, negatives);


            q.offer(new Node(hotel, score));
            if (q.size() > k) q.poll();
        }

        List<Integer> topHotels = new ArrayList<>();
        while (!q.isEmpty()) {
            Node node = q.poll();
            System.out.println(node);
            topHotels.add(node.id);
        }

        return topHotels;
    }

    private int calculateScore(String review, Set<String> pos, Set<String> neg) {
        int score = 0;
        for (String s : review.split(" ")) {
            // TODO: remove punctuation marks
            if (pos.contains(s)) score += 3;
            if (neg.contains(s)) score -= 1;
        }
        return score;
    }

    class Node {
        int id, score;
        Node (int id, int score) {
            this.id =  id;
            this.score = score;
        }
        public String toString() {
            return "Node - id = " + id + " score = " + score;
        }
    }

    public static void main(String[] args) {

        System.out.println("test  = "  + TEST);


        AwardTopKHotels a = new AwardTopKHotels();
        System.out.println(a.getTopKHotelsByReviews("good best", "bad not", new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)), new ArrayList<>( Arrays.asList(
                "best hotel good",
                "good one",
                "bad one",
                "very bad not recommended",
                "bad bad bad"
        )), 2));
    }
}
