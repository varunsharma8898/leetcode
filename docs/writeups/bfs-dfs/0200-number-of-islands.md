# LC 200 — Number of Islands

**Pattern:** DFS / BFS flood fill  
**Difficulty:** Medium  
**Code:** [`NumberOfIslands.java`](../../../src/main/java/NumberOfIslands.java) · also [`NumberOfIslandsByUnionFind.java`](../../../src/main/java/NumberOfIslandsByUnionFind.java)

---

## Problem

`m x n` grid of `'1'` (land) and `'0'` (water). An island is 4-connected land. Return the number of islands.

**Constraints / edges worth remembering**
- Empty grid → 0.
- Diagonals do **not** connect.
- You may mutate the grid (mark visited as water).

---

## Intuition

Each unvisited land cell starts a new island. DFS/BFS marks the whole connected component so you don’t recount it.

---

## Approach

1. Scan every cell.
2. On `'1'`: `count++`, then DFS that marks the component as `'0'`.
3. DFS recurses up/down/left/right with bounds + water checks.

---

## Solution sketch

```java
if (grid[i][j] == '1') { count++; dfs(grid, i, j); }
// dfs: out of bounds or '0' → return; set '0'; recurse 4 dirs
```

---

## Complexity

| | |
|---|---|
| **Time** | O(m · n) |
| **Space** | O(m · n) worst-case recursion stack; BFS uses O(m · n) queue |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Max Area of Island** | Return size of largest component instead of count |
| **Union-Find** | Union adjacent lands; answer = #roots of land cells |
| **Surrounded Regions / Pacific Atlantic** | Multi-source DFS/BFS from borders |
| **Number of Provinces** | Same idea on an adjacency matrix |

---

## Pitfalls

- Mark visited **before** or at the start of recursion to avoid stack blow-ups / revisits.
- Only 4 directions unless the problem says 8.
