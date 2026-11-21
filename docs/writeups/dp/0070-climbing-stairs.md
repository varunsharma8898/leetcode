# LC 70 — Climbing Stairs

**Pattern:** DP — Fibonacci  
**Difficulty:** Easy  
**Code:** [`ClimbingStairs.java`](../../../src/main/java/ClimbingStairs.java)

---

## Problem

Climb `n` stairs taking 1 or 2 steps. Return number of distinct ways.

**Constraints / edges worth remembering**
- n=1 → 1; n=2 → 2.
- Order matters (1+2 vs 2+1).

---

## Intuition

Ways(n) = ways(n-1) + ways(n-2) — Fibonacci.

---

## Approach

dp[1]=1, dp[2]=2; for i=3..n: dp[i]=dp[i-1]+dp[i-2].

---

## Solution sketch

```java
dp[i] = dp[i-1] + dp[i-2];
```

---

## Complexity

| | |
|---|---|
| **Time** | O(n) |
| **Space** | O(n) or O(1) rolling |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Min Cost Climbing Stairs** | Same recurrence with costs |
| **Decode Ways** | Fibonacci with digit constraints |

---

## Pitfalls

- Off-by-one on base cases.
- Can roll two variables for O(1) space.
