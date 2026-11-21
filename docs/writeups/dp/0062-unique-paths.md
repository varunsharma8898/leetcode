# LC 62 — Unique Paths

**Pattern:** DP / memoization  
**Difficulty:** Medium  
**Code:** [`UniquePaths.java`](../../../src/main/java/UniquePaths.java)

---

## Problem

Robot on an `m x n` grid starts top-left, moves only right or down. Return number of paths to bottom-right.

**Constraints / edges worth remembering**
- 1x1 grid → 1.
- Paths = C(m+n-2, m-1) mathematically.

---

## Intuition

Each cell’s paths = paths from above + from left. Memoized recursion or bottom-up DP.

---

## Approach

1. Memo: `helper(m,n) = helper(m-1,n)+helper(m,n-1)` with base `(1,1)=1`.
2. DP: seed `dp[1][1]=1`; push values right/down.

---

## Solution sketch

```java
return helper(m-1,n)+helper(m,n-1); // memoized
// or dp[i][j] = dp[i-1][j] + dp[i][j-1]
```

---

## Complexity

| | |
|---|---|
| **Time** | O(m · n) |
| **Space** | O(m · n) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Unique Paths II** | Skip obstacles; treat blocked as 0 |
| **Min Path Sum** | Same grid DP with mins/sums |

---

## Pitfalls

- Base cases: m==0 or n==0 → 0; both 1 → 1.
- Combinatorial formula is fine if overflow handled.
