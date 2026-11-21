# LC 130 — Surrounded Regions

**Pattern:** Border DFS / BFS  
**Difficulty:** Medium  
**Code:** [`SurroundedRegions.java`](../../../src/main/java/SurroundedRegions.java)

---

## Problem

Board of `'X'` and `'O'`. Capture all regions of `'O'` that are **fully surrounded** by `'X'` (flip to `'X'`). `'O'`s connected to the border are safe.

**Constraints / edges worth remembering**
- Tiny boards (&lt; 2 rows/cols) — nothing to capture.
- Any `'O'` touching the border (via 4-connectivity) survives.

---

## Intuition

Flip the **unsurrounded** ones first: DFS from every border `'O'` and mark them (e.g. `'*'`). Then flip remaining `'O'` → `'X'`, and restore `'*'` → `'O'`.

---

## Approach

1. DFS/BFS from all border `'O'` cells; mark as `'*'`.
2. Scan board: `'O'` → `'X'`; `'*'` → `'O'`.

---

## Solution sketch

```java
// mark border-connected O as '*'
for each border cell if O: dfs mark *
for all cells:
  if O → X
  if * → O
```

---

## Complexity

| | |
|---|---|
| **Time** | O(m · n) |
| **Space** | O(m · n) recursion worst case |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Number of Islands** | Count components of land |
| **Pacific Atlantic** | Two border multi-source DFS |
| **Union-Find** | Union O’s; anything united with border sentinel is safe |

---

## Pitfalls

- Don’t flip interior first — you’ll destroy connectivity info.
- Only 4 directions.
