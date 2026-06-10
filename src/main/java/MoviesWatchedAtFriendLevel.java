import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MoviesWatchedAtFriendLevel {


    public List<String> moviesWatchedByFriendAtLevel(List<List<String>> watchedMovies, int[][] friends, int id, int level) {
        int n = friends.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);

        int currentLevel = 0;
        visited[id] = true; // visited of id not 0

        while (!queue.isEmpty() && currentLevel < level) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int personId = queue.poll();
                for (int friendId : friends[personId]) {
                    if (!visited[friendId]) {
                        visited[friendId] = true;
                        queue.offer(friendId);
                    }
                }
            }
            currentLevel++;
        }


        Map<String, Integer> freq = new HashMap<>();
        while (!queue.isEmpty()) {
            int personId = queue.poll();
            for (String movie : watchedMovies.get(personId)) {
                freq.put(movie, freq.getOrDefault(movie, 0) + 1);
            }
        }

        List<String> result = new ArrayList<>(freq.keySet());
        result.sort((a, b) -> {
            int cmp = Integer.compare(freq.get(a), freq.get(b));
            if (cmp != 0) return cmp;
            return a.compareTo(b);
        });

        return result;
    }

    public static void main(String[] args) {
        List<List<String>> watchedMovies = Arrays.asList(
                Arrays.asList("Spider Man"),
                Arrays.asList("Iron Man", "Hulk"),
                Arrays.asList("Doctor Strange", "Hulk", "Black Panther", "Black Widow"),
                Arrays.asList("Ant Man", "Iron Man", "Infinity War"),
                Arrays.asList("End Game", "Infinit War", "Hulk", "Spider Man", "Captain Marvel")
        );

        int[][] friends = {
                {3, 2, 1, 4},
                {0, 4},
                {4, 0},
                {0, 4},
                {2, 3, 1, 0}
        };

        MoviesWatchedAtFriendLevel obj = new MoviesWatchedAtFriendLevel();
        System.out.println(obj.moviesWatchedByFriendAtLevel(watchedMovies, friends, 3, 2));
    }

}
