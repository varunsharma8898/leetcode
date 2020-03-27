import org.junit.Assert;

public class BestTimeToBuySellStock {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxProfit = 0, maxCurr = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCurr += prices[i] - prices[i-1];  // most imp line, see comments below
            maxCurr = Math.max(0, maxCurr);
            maxProfit = Math.max(maxCurr, maxProfit);
        }

        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int profit = 0;
        int lowPrice = prices[0];
        for (int price : prices) {
            if (price < lowPrice) {
                lowPrice = price;
            } else {
                profit = Math.max(price - lowPrice, profit);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        BestTimeToBuySellStock b = new BestTimeToBuySellStock();
        Assert.assertEquals(5, b.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
        Assert.assertEquals(0, b.maxProfit(new int[] { 7, 6, 4, 3, 1 }));
        Assert.assertEquals(0, b.maxProfit(new int[] { 1, 1 }));
        Assert.assertEquals(1, b.maxProfit(new int[] { 1, 2 }));
        Assert.assertEquals(0, b.maxProfit(null));
        Assert.assertEquals(3, b.maxProfit(new int[] { 2, 1, 4 }));

        Assert.assertEquals(5, b.maxProfit2(new int[] { 7, 1, 5, 3, 6, 4 }));
        Assert.assertEquals(0, b.maxProfit2(new int[] { 7, 6, 4, 3, 1 }));
        Assert.assertEquals(0, b.maxProfit2(new int[] { 1, 1 }));
        Assert.assertEquals(1, b.maxProfit2(new int[] { 1, 2 }));
        Assert.assertEquals(0, b.maxProfit2(null));
        Assert.assertEquals(3, b.maxProfit2(new int[] { 2, 1, 4 }));
    }

    /**
     * array = a1, a2, a3, a4
     * diffs = b1, b2, b3, b4
     *
     * diffs calc:
     *  b1 = a1
     *  b2 = a2 - a1
     *  b3 = a3 - a2
     *  b4 = a4 - a3
     *
     * Adding these all to maxCurr
     * maxCurr = b1 + b2 + b3 + b4
     *   should result into
     *   = a4 - a1
     *
     * This problem boils down to max subarray problem.
     * So, Kadane's algo is the best solution here.
     *
     * */
}
