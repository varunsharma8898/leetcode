# LC 547 — Number of Provinces

**Pattern:** Graph DFS / Union-Find  
**Difficulty:** Medium  
**Code:** [`NumberOfProvinces.java`](../../../src/main/java/NumberOfProvinces.java)

---

## Problem

`n x n` adjacency matrix `isConnected` for cities. A province is a connected component. Return the number of provinces.

**Constraints / edges worth remembering**
- Diagonal is always 1 (self-connected).
- Undirected: `isConnected[i][j] == isConnected[j][i]`.

---

## Intuition

Same as counting connected components: DFS/BFS from each unvisited city, or Union-Find on edges.

---

## Approach

1. `visited[n]`.
2. For each city `i` not visited: `count++`, DFS mark all reachable via `grid[i][j]==1`.

---

## Solution sketch

```java
for (int i = 0; i < n; i++) {
    if (!visited[i]) { dfs(i); count++; }
}
// dfs: for j if connected and !visited[j], recurse
```

---

## Complexity

| | |
|---|---|
| **Time** | O(n²) — matrix scan |
| **Space** | O(n) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Number of Islands** | Grid DFS instead of adjacency matrix |
| **Accounts Merge** | Union-Find on emails |
| **Redundant Connection** | Union-Find detecting cycle |

---

## Pitfalls

- Skip `i == j` or it’s harmless if you mark visited first.
- Don’t forget to mark visited when entering DFS.
