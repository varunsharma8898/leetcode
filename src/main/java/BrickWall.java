import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

public class BrickWall {

    public int leastBricks(List<List<Integer>> wall) {

        int maxcount = 0;
        Map<Integer, Integer> boundaryMap = new HashMap<>();
        for (int i = 0; i < wall.size(); i++) {
            int sum = 0;
            for (int j = 0; j < wall.get(i).size() - 1; j++) {
                sum += wall.get(i).get(j);
                int count = 1 + boundaryMap.getOrDefault(sum, 0);
                boundaryMap.put(sum, count);
                maxcount = Math.max(count, maxcount);
            }
        }
        return wall.size() - maxcount;
    }

    public static void main(String[] args) {
        BrickWall bw = new BrickWall();
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(1, 2, 2, 1));
        input.add(Arrays.asList(3, 1, 2));
        input.add(Arrays.asList(1, 3, 2));
        input.add(Arrays.asList(2, 4));
        input.add(Arrays.asList(3, 1, 2));
        input.add(Arrays.asList(1, 3, 1, 1));

        Assert.assertEquals(2, bw.leastBricks(input));
    }
}
