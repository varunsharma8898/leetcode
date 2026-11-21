# LC 79 — Word Search

**Pattern:** Backtracking on grid  
**Difficulty:** Medium  
**Code:** [`WordSearch.java`](../../../src/main/java/WordSearch.java)

---

## Problem

2D board of letters. Return whether `word` exists via adjacent (4-dir) cells; no cell reused in one path.

**Constraints / edges worth remembering**
- Start DFS from every cell matching word[0].
- Mark visited and backtrack.

---

## Intuition

DFS along the word index; mark `*` (or similar), explore 4 dirs, restore on return.

---

## Approach

1. For each cell matching first char, DFS.
2. Base: index==len → true.
3. Bounds / mismatch / visited → false.
4. Mark, recurse, unmark.

---

## Solution sketch

```java
board[i][j] = '*';
boolean ok = dfs(...index+1) in 4 dirs;
board[i][j] = c; // restore
```

---

## Complexity

| | |
|---|---|
| **Time** | O(m · n · 3^L) typical |
| **Space** | O(L) recursion (+ board marks) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Word Search II** | Trie of words + shared DFS |
| **Unique Paths III** | DFS counting full covers |

---

## Pitfalls

- Restore the cell after DFS (backtrack).
- Check `index == word.length()` before bounds on next hop.
