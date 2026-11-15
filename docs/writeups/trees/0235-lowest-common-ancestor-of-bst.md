# LC 235 — Lowest Common Ancestor of a Binary Search Tree

**Pattern:** Trees / BST property  
**Difficulty:** Medium  
**Code:** [`LowestCommonAncestor.java`](../../../src/main/java/LowestCommonAncestor.java)

---

## Problem

Given a BST and nodes `p`, `q`, return their lowest common ancestor. Both nodes exist in the tree.

**Constraints / edges worth remembering**
- This is a **BST**, not a general binary tree (LC 236).
- A node can be an ancestor of itself.

---

## Intuition

If both `p` and `q` are &gt; root, LCA is in the right subtree; both &lt; root → left; otherwise root splits them (or equals one) → root is LCA.

---

## Approach

1. If `root.val < p.val && root.val < q.val` → go right.
2. Else if both greater → go left.
3. Else return root.

---

## Solution sketch

```java
if (root.val < p.val && root.val < q.val)
    return lowestCommonAncestor(root.right, p, q);
if (root.val > p.val && root.val > q.val)
    return lowestCommonAncestor(root.left, p, q);
return root;
```

---

## Complexity

| | |
|---|---|
| **Time** | O(h) — height of tree |
| **Space** | O(h) recursion (or O(1) iterative) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **LCA of Binary Tree (LC 236)** | Post-order: if left and right both nonempty, root is LCA |
| **Iterative BST** | Same comparisons in a `while` loop |

---

## Pitfalls

- Don’t apply BST logic to LC 236.
- No need to assume `p.val < q.val` — the both-less / both-greater checks handle either order.
