# LC 297 — Serialize and Deserialize Binary Tree

**Pattern:** Trees — preorder + null markers  
**Difficulty:** Hard  
**Code:** [`SerializeDeserializeBinaryTree.java`](../../../src/main/java/SerializeDeserializeBinaryTree.java)

---

## Problem

Design algorithms to serialize a binary tree to a string and deserialize it back to the same structure.

**Constraints / edges worth remembering**
- Must encode null children so structure is recoverable.
- Empty tree → only null marker(s).

---

## Intuition

Preorder DFS: write `val,` or `X,` for null. Deserialize by consuming tokens in the same order from a queue — recursive build mirrors the write order.

---

## Approach

1. **Serialize:** preorder; append value or `X` plus separator.
2. **Deserialize:** split on separator into queue; recursive `buildTree` polls one token — if `X` return null, else create node and build left then right.

---

## Solution sketch

```java
// serialize preorder with X for null
// deserialize:
String t = q.poll();
if (t.equals("X")) return null;
TreeNode root = new TreeNode(Integer.parseInt(t));
root.left = buildTree(q);
root.right = buildTree(q);
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
| **BFS level-order codec** | Queue serialize like LeetCode’s judge display |
| **N-ary serialize** | Need child counts or delimiters |
| **BST serialize** | Can omit nulls with structure implied by order (different problem) |

---

## Pitfalls

- Null markers are mandatory for general binary trees.
- Consume tokens in the exact serialize order.
