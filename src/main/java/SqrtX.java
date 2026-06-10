import org.junit.Assert;

public class SqrtX {

    private int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1)) {
                    return mid;
                }
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        SqrtX sq = new SqrtX();
        Assert.assertEquals(2, sq.mySqrt(4));
        Assert.assertEquals(2, sq.mySqrt(8));
    }

}
