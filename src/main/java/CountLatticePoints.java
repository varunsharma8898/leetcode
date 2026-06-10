import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;

public class CountLatticePoints {

    private int countLatticePoints(int[][] circles) {
        // can use Set<String> or Set<int[]> also, doing this to avoid TLE
        Set<Integer> set = new HashSet<>();
        for (int[] circle : circles) {
            int x = circle[0], y = circle[1], r = circle[2];
            for (int i = x-r; i <= x+r; i++) {
                for (int j = y-r; j <= y+r; j++) {
                    if ((x - i) * (x - i) + (y - j) * (y - j) <= r * r) {
                        set.add(i * 1000 + j);
                    }
                }
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        CountLatticePoints clp = new CountLatticePoints();
        Assert.assertEquals(5, clp.countLatticePoints(new int[][] { { 2, 2, 1 } }));
        Assert.assertEquals(16, clp.countLatticePoints(new int[][] { { 2, 2, 2 }, { 3, 4, 1 } }));
    }
}
