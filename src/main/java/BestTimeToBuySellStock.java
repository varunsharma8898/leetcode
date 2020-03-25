import org.junit.Assert;

public class BestTimeToBuySellStock {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxProfit = 0, maxCurr = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCurr += prices[i] - prices[i-1];
            maxCurr = Math.max(0, maxCurr);
            maxProfit = Math.max(maxCurr, maxProfit);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuySellStock b = new BestTimeToBuySellStock();
        Assert.assertEquals(5, b.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
        Assert.assertEquals(0, b.maxProfit(new int[] { 7, 6, 4, 3, 1 }));
        Assert.assertEquals(0, b.maxProfit(new int[] { 1, 1 }));
        Assert.assertEquals(1, b.maxProfit(new int[] { 1, 2 }));
        Assert.assertEquals(0, b.maxProfit(null));
        Assert.assertEquals(3, b.maxProfit(new int[] { 2, 1, 4 }));
    }
}
