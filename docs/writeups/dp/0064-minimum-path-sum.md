# LC 64 — Minimum Path Sum

**Pattern:** DP (in-place grid)  
**Difficulty:** Medium  
**Code:** [`MinPathSum.java`](../../../src/main/java/MinPathSum.java)

---

## Problem

Grid of non-negative numbers. Path from top-left to bottom-right moving only right/down. Minimize path sum.

**Constraints / edges worth remembering**
- Can mutate the grid.
- First row/col are prefix-only.

---

## Intuition

Running min: each cell += min(from above, from left) after filling borders.

---

## Approach

1. Prefix first column and first row.
2. For i,j ≥ 1: `grid[i][j] += min(grid[i-1][j], grid[i][j-1])`.
3. Return bottom-right.

---

## Solution sketch

```java
grid[row][0] += grid[row-1][0]; // first col
grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
```

---

## Complexity

| | |
|---|---|
| **Time** | O(m · n) |
| **Space** | O(1) extra if in-place |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Unique Paths** | Count instead of minimize |
| **Dungeon Game** | Work backward with HP constraints |

---

## Pitfalls

- Don’t forget border prefix passes.
- In-place destroys original grid — say so in interview.
