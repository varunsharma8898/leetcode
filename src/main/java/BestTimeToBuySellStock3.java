import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.Assert;

public class BestTimeToBuySellStock3 {

    public int maxProfit_(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int oneBuyPrice = Integer.MAX_VALUE, twoBuyPrice = Integer.MAX_VALUE;
        int oneBuyOneSell = 0, twoBuyTwoSell = 0;

        for (int price : prices) {
            oneBuyPrice = Math.min(oneBuyPrice, price);
            oneBuyOneSell = Math.max(oneBuyOneSell, price - oneBuyPrice);
            twoBuyPrice = Math.min(twoBuyPrice, price - oneBuyOneSell);
            twoBuyTwoSell = Math.max(twoBuyTwoSell, price - twoBuyPrice);
        }
        return twoBuyTwoSell;
    }


    private int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int onebuy = Integer.MAX_VALUE, twobuy = Integer.MAX_VALUE;
        int onesell = 0, twosell = 0;
        for (int price : prices) {
            onebuy = Math.min(onebuy, price);
            onesell = Math.max(onesell, price - onebuy);
            twobuy = Math.min(twobuy, price - onesell);
            twosell = Math.max(twosell, price - twobuy);
        }
        return twosell;
    }

    public static void main(String[] args) {
        BestTimeToBuySellStock3 b = new BestTimeToBuySellStock3();
        Assert.assertEquals(6, b.maxProfit(new int[] { 3, 3, 5, 0, 0, 3, 1, 4 }));
        Assert.assertEquals(4, b.maxProfit(new int[] { 1, 2, 3, 4, 5 }));
        Assert.assertEquals(0, b.maxProfit(new int[] { 7, 6, 4, 3, 1 }));
        Assert.assertEquals(1, b.maxProfit(new int[] { 1, 2 }));
        Assert.assertEquals(0, b.maxProfit(null));
        Assert.assertEquals(3, b.maxProfit(new int[] { 2, 1, 4 }));
        Assert.assertEquals(13, b.maxProfit(new int[] { 1, 2, 4, 2, 5, 7, 2, 4, 9, 0 }));
    }
}
