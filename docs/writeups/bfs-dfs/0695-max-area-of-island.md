# LC 695 — Max Area of Island

**Pattern:** DFS flood fill  
**Difficulty:** Medium  
**Code:** [`MaxAreaOfIsland.java`](../../../src/main/java/MaxAreaOfIsland.java)

---

## Problem

Grid of 0 water / 1 land. Island area = connected 1s (4-dir). Return max area (0 if none).

**Constraints / edges worth remembering**
- Mutate land to 0 when visiting.
- Same skeleton as Number of Islands.

---

## Intuition

On each land cell, DFS returns component size; track max.

---

## Approach

Scan grid; on 1, `max = max(max, dfs)`; dfs marks 0 and returns 1 + 4-dir sums.

---

## Solution sketch

```java
grid[i][j]=0; return 1 + dfs(up)+dfs(down)+dfs(left)+dfs(right);
```

---

## Complexity

| | |
|---|---|
| **Time** | O(m · n) |
| **Space** | O(m · n) recursion worst |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Number of Islands** | Count components |
| **Island Perimeter** | Count edges instead of area |

---

## Pitfalls

- Return 0 from out-of-bounds / water.
- Don’t forget to update maxArea on each component.
