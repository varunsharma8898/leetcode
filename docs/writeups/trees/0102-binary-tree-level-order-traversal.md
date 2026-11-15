# LC 102 — Binary Tree Level Order Traversal

**Pattern:** Tree BFS  
**Difficulty:** Medium  
**Code:** [`BinaryTreeLevelOrderTraversal.java`](../../../src/main/java/BinaryTreeLevelOrderTraversal.java)

---

## Problem

Return the level-order traversal of a binary tree (left to right, level by level) as a list of lists.

**Constraints / edges worth remembering**
- `root == null` → empty list.
- Capture `queue.size()` before the inner loop — that’s the level width.

---

## Intuition

Standard BFS. Process exactly the nodes currently in the queue as one level; enqueue their children for the next level.

---

## Approach

1. Offer root into a queue.
2. While queue not empty: `len = q.size()`, build `level` list of `len` nodes, enqueue children.
3. Append `level` to result.

---

## Solution sketch

```java
q.offer(root);
while (!q.isEmpty()) {
    int len = q.size();
    List<Integer> level = new ArrayList<>();
    for (int i = 0; i < len; i++) {
        TreeNode node = q.poll();
        level.add(node.val);
        if (node.left != null) q.offer(node.left);
        if (node.right != null) q.offer(node.right);
    }
    result.add(level);
}
```

---

## Complexity

| | |
|---|---|
| **Time** | O(n) |
| **Space** | O(n) — queue + output |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Level Order II (bottom-up)** | Same BFS; `add(0, level)` or reverse at end |
| **Zigzag** | Alternate direction per level (deque or reverse odd levels) |
| **Right side view** | Only last node of each level |
| **Average of levels** | Sum / count per level |

---

## Pitfalls

- Must snapshot `len = q.size()`; using `q.size()` changing mid-loop mixes levels.
- Null root early return.
