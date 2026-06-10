import org.junit.Assert;

public class BestTimeToBuySellStockTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int buy = -prices[0];
        int sell = 0;

        for (int price : prices) {
            buy = Math.max(buy, sell - price);
            sell = Math.max(sell, buy + price - fee);
        }
        return sell;
    }

    public static void main(String[] args) {
        BestTimeToBuySellStockTransactionFee obj = new BestTimeToBuySellStockTransactionFee();
        Assert.assertEquals(6, obj.maxProfit(new int[] { 1, 3, 7, 5, 10, 3 }, 3));
        Assert.assertEquals(8, obj.maxProfit(new int[] { 1, 3, 2, 8, 4, 9 }, 2));
    }
}
