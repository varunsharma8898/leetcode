import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

public class TribonacciNumbers {

    public int tribonacci(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        res.add(1);
        res.add(1);
        for (int i = 3; i <= n; i++) {
            int size = res.size();
            int sum = res.get(size - 3) + res.get(size - 2) + res.get(size - 1);
            res.add(i, sum);
        }
        return res.get(n);
    }

    public int tribonacciDP(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;
        int[] arr = {0, 1, 1};
        for (int i = 3; i <= n; i++) {
            arr[i % 3] = arr[(i-1) % 3] + arr[(i-2) % 3] + arr[(i-3) % 3];
        }
        return arr[n % 3];
    }

    public static void main(String[] args) {
        TribonacciNumbers tn = new TribonacciNumbers();
        Assert.assertEquals(4, tn.tribonacci(4));
        Assert.assertEquals(1389537, tn.tribonacci(25));
        Assert.assertEquals(4, tn.tribonacciDP(4));
        Assert.assertEquals(1389537, tn.tribonacciDP(25));
    }

}
