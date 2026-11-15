# LC 300 — Longest Increasing Subsequence

**Pattern:** DP (O(n²)); patience sorting optional  
**Difficulty:** Medium  
**Code:** [`LongestIncreasingSubsequence.java`](../../../src/main/java/LongestIncreasingSubsequence.java)

---

## Problem

Return the length of the longest strictly increasing subsequence of `nums` (not necessarily contiguous).

**Constraints / edges worth remembering**
- Single element → 1.
- All equal → 1.
- Subsequence, not subarray.

---

## Intuition

`dp[i]` = LIS length ending at index `i`. For each `i`, look at all `j < i` with `nums[j] < nums[i]` and take `max(dp[i], 1 + dp[j])`. Answer is max over `dp`.

---

## Approach

1. `dp[i] = 1` for all i; `max = 1`.
2. For `i = 1 .. n-1`, for `j = 0 .. i-1`, update when `nums[j] < nums[i]`.
3. Return `max`.

---

## Solution sketch

```java
Arrays.fill(dp, 1);
for (int i = 1; i < n; i++)
    for (int j = 0; j < i; j++)
        if (nums[j] < nums[i]) {
            dp[i] = Math.max(dp[i], 1 + dp[j]);
            max = Math.max(max, dp[i]);
        }
```

---

## Complexity

| | |
|---|---|
| **Time** | O(n²) |
| **Space** | O(n) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **O(n log n)** | Maintain `tails` array; binary search replace |
| **Russian Doll Envelopes** | Sort + LIS on one dimension |
| **Longest Increasing Path in Matrix** | DFS + memo on DAG of cells |
| **Number of LIS** | Track counts alongside lengths |

---

## Pitfalls

- Init `dp` and `max` to **1**, not 0.
- Strict `<` for “increasing” (problem statement).
