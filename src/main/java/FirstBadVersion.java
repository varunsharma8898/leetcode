import org.junit.Assert;

public class FirstBadVersion {

    private int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        FirstBadVersion fbv = new FirstBadVersion();
        Assert.assertEquals(4, fbv.firstBadVersion(5));
    }

    private boolean isBadVersion(int version) {
        return version == 4;
    }
}
