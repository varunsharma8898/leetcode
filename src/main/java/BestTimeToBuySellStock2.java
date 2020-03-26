import org.junit.Assert;

public class BestTimeToBuySellStock2 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int total = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i+1] > prices[i]) {
                total += prices[i+1] - prices[i];
            }
        }
        return total;
    }

    public int maxProfitBruteForce(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;
        int otherMax = 0;
        for (int i = 1; i < prices.length; i++) {
            int currMax = prices[i] - prices[i - 1];
            if (currMax > 0) {
                otherMax += currMax;
                otherMax = Math.max(currMax, otherMax);
            } else {
                maxProfit += otherMax;
                otherMax = 0;
            }
        }
        if (otherMax > 0) {
            maxProfit += otherMax;
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuySellStock2 b = new BestTimeToBuySellStock2();
        Assert.assertEquals(7, b.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
        Assert.assertEquals(4, b.maxProfit(new int[] { 1, 2, 3, 4, 5 }));
        Assert.assertEquals(0, b.maxProfit(new int[] { 7, 6, 4, 3, 1 }));
        Assert.assertEquals(1, b.maxProfit(new int[] { 1, 2 }));
        Assert.assertEquals(0, b.maxProfit(null));
        Assert.assertEquals(3, b.maxProfit(new int[] { 2, 1, 4 }));

        Assert.assertEquals(7, b.maxProfitBruteForce(new int[] { 7, 1, 5, 3, 6, 4 }));
        Assert.assertEquals(4, b.maxProfitBruteForce(new int[] { 1, 2, 3, 4, 5 }));
        Assert.assertEquals(0, b.maxProfitBruteForce(new int[] { 7, 6, 4, 3, 1 }));
        Assert.assertEquals(1, b.maxProfitBruteForce(new int[] { 1, 2 }));
        Assert.assertEquals(0, b.maxProfitBruteForce(null));
        Assert.assertEquals(3, b.maxProfitBruteForce(new int[] { 2, 1, 4 }));
    }
}
