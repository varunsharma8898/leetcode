# LC 103 — Binary Tree Zigzag Level Order Traversal

**Pattern:** Tree BFS  
**Difficulty:** Medium  
**Code:** [`BinaryTreeZigzagLevelOrderTraversal.java`](../../../src/main/java/BinaryTreeZigzagLevelOrderTraversal.java)

---

## Problem

Level-order traversal, but alternate left→right and right→left each level.

**Constraints / edges worth remembering**
- Null root → empty.
- Toggle a boolean each level; use deque addFirst/addLast.

---

## Intuition

Standard BFS; on zigzag levels insert at front of the level list.

---

## Approach

Queue BFS; `zigzag` flag; if true `addFirst`, else `addLast`; flip flag after level.

---

## Solution sketch

```java
if (zigzag) level.addFirst(node.val); else level.addLast(node.val);
zigzag = !zigzag;
```

---

## Complexity

| | |
|---|---|
| **Time** | O(n) |
| **Space** | O(n) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Level Order** | Always addLast |
| **Right Side View** | Last node per level |

---

## Pitfalls

- Still enqueue children left-then-right; only the output list direction flips.
- Snapshot `len = q.size()` per level.
