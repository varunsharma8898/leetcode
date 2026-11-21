# LC 221 — Maximal Square

**Pattern:** DP  
**Difficulty:** Medium  
**Code:** [`MaximalSquare.java`](../../../src/main/java/MaximalSquare.java)

---

## Problem

Binary matrix of `'0'`/`'1'`. Return area of the largest square containing only 1s.

**Constraints / edges worth remembering**
- Return area = edge², not edge.
- Empty matrix → 0.

---

## Intuition

`dp[i][j]` = max square edge ending at cell (i-1,j-1). If cell is 1: `1 + min(left, up, diag)`.

---

## Approach

1. `dp` sized (m+1)×(n+1) with zero border.
2. On `'1'`, set min of three neighbors + 1; track max edge.
3. Return `maxEdge * maxEdge`.

---

## Solution sketch

```java
if (matrix[i-1][j-1] == '1')
  squares[i][j] = 1 + min(up, left, diag);
maxEdge = max(maxEdge, squares[i][j]);
return maxEdge * maxEdge;
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
| **Maximal Rectangle** | Histogram per row + LC 84 |
| **Edit Distance-like table** | Same 3-neighbor look |

---

## Pitfalls

- Indices use i-1/j-1 into matrix when dp is 1-indexed.
- Return area, not edge length.
