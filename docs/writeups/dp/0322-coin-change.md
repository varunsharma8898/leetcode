# LC 322 — Coin Change

**Pattern:** DP — unbounded knapsack / min coins  
**Difficulty:** Medium  
**Code:** [`CoinChange.java`](../../../src/main/java/CoinChange.java)

---

## Problem

Given coin denominations `coins` and a total `amount`, return the fewest number of coins that sum to `amount`. Return `-1` if impossible. Unlimited supply of each coin.

**Constraints / edges worth remembering**
- `amount == 0` → `0`.
- Impossible amounts → `-1` (e.g. coins `[2]`, amount `3`).

---

## Intuition

`dp[x]` = min coins to make amount `x`. Transition: for each coin `c ≤ x`, try `1 + dp[x - c]`. This is unbounded knapsack because each coin can be reused.

---

## Approach

1. Allocate `dp` of size `amount + 1` (not `coins.length + 1`).
2. Fill with a sentinel larger than any answer (`amount + 1` works).
3. `dp[0] = 0`.
4. For `curr = 1 .. amount`, for each `coin`, if `coin ≤ curr` take `min(dp[curr], 1 + dp[curr - coin])`.
5. If `dp[amount] > amount`, return `-1`, else return `dp[amount]`.

---

## Solution sketch

```java
int[] dp = new int[amount + 1];
Arrays.fill(dp, amount + 1);
dp[0] = 0;
for (int curr = 1; curr <= amount; curr++) {
    for (int coin : coins) {
        if (coin <= curr)
            dp[curr] = Math.min(dp[curr], 1 + dp[curr - coin]);
    }
}
return dp[amount] > amount ? -1 : dp[amount];
```

---

## Complexity

| | |
|---|---|
| **Time** | O(amount × |coins|) |
| **Space** | O(amount) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Coin Change II (LC 518)** | Count combinations: `dp[x] += dp[x - coin]`; outer loop coins to avoid permutations |
| **Perfect Squares (LC 279)** | Same DP; “coins” are `1², 2², …` |
| **Min cost / Climbing Stairs** | Same 1D min-transition pattern |
| **Greedy** | Only correct for canonical coin systems (e.g. US coins); not general |

---

## Pitfalls

- Array size is `amount + 1`, not `n + 1`.
- Must set `dp[0] = 0` or every transition is wrong.
- Sentinel `amount + 1` (or `INF`) so unfinished cells stay detectable.
- Return `-1` when final value is still the sentinel.
