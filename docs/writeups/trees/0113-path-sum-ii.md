# LC 113 — Path Sum II

**Pattern:** DFS backtracking  
**Difficulty:** Medium  
**Code:** [`PathSum2.java`](../../../src/main/java/PathSum2.java)

---

## Problem

Return all root-to-leaf paths where node values sum to `targetSum`.

**Constraints / edges worth remembering**
- Leaf = both children null.
- Copy path when recording; backtrack pop.

---

## Intuition

DFS with remaining target; at leaf if remain==0 after subtracting, record path copy.

---

## Approach

Add node to path; recurse left/right with `target - val`; pop. Special-case leaf check before pushing in your version — either style works if consistent.

---

## Solution sketch

```java
if (leaf && target - root.val == 0) record copy;
else { path.add; dfs(left); dfs(right); path.removeLast(); }
```

---

## Complexity

| | |
|---|---|
| **Time** | O(n²) worst (copying paths) / O(n) explore |
| **Space** | O(h) recursion + output |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Path Sum I** | Boolean only |
| **Path Sum III** | Any downward path; prefix sums |

---

## Pitfalls

- Must copy the list — don’t store the live path reference.
- Don’t prune on negative remain if node values can be negative (LC allows negatives in some variants; classic 113 is usually any ints).
