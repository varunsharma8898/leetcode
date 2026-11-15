# LC 994 — Rotting Oranges

**Pattern:** Multi-source BFS (your code: multi-source DFS with day stamps)  
**Difficulty:** Medium  
**Code:** [`RottingOranges.java`](../../../src/main/java/RottingOranges.java)

---

## Problem

Grid cells: `0` empty, `1` fresh, `2` rotten. Each minute, fresh oranges 4-adjacent to rotten become rotten. Return minutes until all fresh are rotten, or `-1` if impossible.

**Constraints / edges worth remembering**
- No fresh oranges at start → `0`.
- Isolated fresh orange → `-1`.

---

## Intuition

Infection spreads in layers from all initially rotten oranges — classic multi-source BFS. Your solution stamps each cell with the earliest “day” reachable via DFS from every rotten source, keeping the minimum day when paths compete.

---

## Approach (your DFS stamp version)

1. For every cell with `2`, DFS with `day` starting at 2; write `day` into cells; skip if a better (smaller) day already set.
2. Scan grid: any remaining `1` → `-1`; else answer = `maxStamp - 2` (or 0 if max ≤ 2).

Interview default is BFS queue of all initial rotten cells, minute by minute.

---

## Solution sketch

```java
// stamp version
if (grid[i][j] == 2) dfs(grid, i, j, 2);
// dfs skips 0 and cells with 1 < stamp < day; sets grid[i][j] = day; recurse day+1
// final: if any 1 left → -1; else max>2 ? max-2 : 0
```

---

## Complexity

| | |
|---|---|
| **Time** | O(m · n) typical BFS; DFS-from-each-rotten can revisit cells but stays O(m · n) with the “better day” prune |
| **Space** | O(m · n) recursion / queue |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Multi-source BFS** | Queue all rotten; process level-by-level; count minutes |
| **Walls and Gates / Pacific Atlantic** | Same multi-source distance idea |

---

## Pitfalls

- Return `0` when there were never any fresh oranges (not `-1`).
- Day stamp encoding: answer is `max - 2` because initial rotten are stamped `2`.
- Condition `grid[i][j] > 1 && grid[i][j] < day` prevents overwriting with a worse path.
