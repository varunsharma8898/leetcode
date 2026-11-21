# LC 329 — Longest Increasing Path in a Matrix

**Pattern:** DFS + memoization  
**Difficulty:** Hard  
**Code:** [`LongestIncreasingPath.java`](../../../src/main/java/LongestIncreasingPath.java)

---

## Problem

In a matrix of integers, move 4-directionally to a **strictly larger** neighbor. Return the length of the longest increasing path.

**Constraints / edges worth remembering**
- Path length counts cells (single cell → 1).
- No cycles because moves must increase.

---

## Intuition

From each cell, DFS to longer paths through larger neighbors. Cache the best length starting at each cell so each cell is solved once. The matrix forms a DAG under the increasing constraint.

---

## Approach

1. `cache[i][j]` = longest path starting at `(i,j)`.
2. DFS with `prev` value; prune if out of bounds or `matrix[i][j] <= prev`.
3. Answer = max over all starting cells.

---

## Solution sketch

```java
if (cache[i][j] != 0) return cache[i][j];
res = 1 + max(dfs four dirs with prev = matrix[i][j]);
cache[i][j] = res;
```

---

## Complexity

| | |
|---|---|
| **Time** | O(m · n) with memo |
| **Space** | O(m · n) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **LIS in array** | 1D DP / patience sorting |
| **Topo DP** | Process cells in increasing order of value |

---

## Pitfalls

- Strict `<` / `<= prev` prune — equals cannot continue.
- Init cache with 0 meaning “uncomputed”; path length is at least 1 when computed.
