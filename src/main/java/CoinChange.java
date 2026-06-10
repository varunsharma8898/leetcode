import java.util.Arrays;

import org.junit.Assert;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];     // v-imp - amount+1 and not len+1
        Arrays.fill(dp, amount + 1);   // fill with amount+1
        dp[0] = 0;                          // v-imp to fill 0 element
        for (int curr = 1; curr <= amount; curr++) {
            for (int coin : coins) {
                if (coin <= curr) {
                    dp[curr] = Math.min(dp[curr], 1 + dp[curr - coin]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];  // v-imp
    }


    public int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int curr = 1; curr <= amount; curr++) {
            for (int coin : coins) {
                if (coin <= curr) {
                    dp[curr] = Math.min(dp[curr], 1 + dp[curr - coin]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];

    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        Assert.assertEquals(3, cc.coinChange(new int[] { 1, 2, 5 }, 11));
        Assert.assertEquals(-1, cc.coinChange(new int[] { 2 }, 3));
        Assert.assertEquals(0, cc.coinChange(new int[] { 1 }, 0));
    }
}
