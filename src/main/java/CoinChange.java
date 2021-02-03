import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int currValue = 1; currValue <= amount; currValue++) {
            for (int coin : coins) {
                if (coin <= currValue) {
                    dp[currValue] = Math.min(dp[currValue], 1 + dp[currValue - coin]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {

    }
}
