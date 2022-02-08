import org.junit.Assert;

public class MinMovesToTarget {

    public int minMoves(int target, int maxDoubles) {
        int moves = 0;
        while (target > 1) {
            if (target % 2 != 0) {
                target -= 1;
                moves++;
            } else {
                if (maxDoubles > 0) {
                    target /= 2;
                    moves++;
                    maxDoubles--;
                } else {
                    moves += target - 1;
                    target = 1;
                }
            }
        }
        return moves;
    }

    public static void main(String[] args) {
        MinMovesToTarget m = new MinMovesToTarget();
//        Assert.assertEquals(4, m.minMoves(5, 0));
//        Assert.assertEquals(7, m.minMoves(19, 2));
//        Assert.assertEquals(4, m.minMoves(10, 4));
        Assert.assertEquals(382069130, m.minMoves(764138259, 1));
    }
}
