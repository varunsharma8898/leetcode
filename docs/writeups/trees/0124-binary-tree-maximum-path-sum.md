# LC 124 — Binary Tree Maximum Path Sum

**Pattern:** Tree DFS (gain vs path)  
**Difficulty:** Hard  
**Code:** [`BinaryTreeMaxPathSum.java`](../../../src/main/java/BinaryTreeMaxPathSum.java)

---

## Problem

A path is any node sequence with at most one node connecting two sides (no revisiting). Return the maximum sum of node values along any path (may be a single node).

**Constraints / edges worth remembering**
- Nodes can be negative — answer can be negative.
- Path can bend through a node using both children; return value to parent can use only one child.

---

## Intuition

At each node, the best **path through this node** is `node + max(0,leftGain) + max(0,rightGain)` — update a global max. The value returned upward is `node + max(0, best single child)` because a parent cannot use both branches.

---

## Approach

1. Global `max = MIN_VALUE`.
2. DFS returns gain to parent.
3. Clamp child gains with `max(0, …)`.
4. Update global with both children; return one-child gain.

---

## Solution sketch

```java
int left = Math.max(0, sum(node.left));
int right = Math.max(0, sum(node.right));
max = Math.max(max, left + right + node.val);
return Math.max(left, right) + node.val;
```

---

## Complexity

| | |
|---|---|
| **Time** | O(n) |
| **Space** | O(h) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Diameter of Binary Tree** | Same structure; track edges / lengths instead of values |
| **Path Sum II/III** | Different goals (root-to-leaf list / count any path) |

---

## Pitfalls

- Init global to `Integer.MIN_VALUE`, not 0 (all-negative trees).
- Returning both children to parent is wrong — only one branch continues up.
