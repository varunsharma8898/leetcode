# LC 138 — Copy List with Random Pointer

**Pattern:** Linked list clone  
**Difficulty:** Medium  
**Code:** [`CloneRandomLinkedList.java`](../../../src/main/java/CloneRandomLinkedList.java)

---

## Problem

Deep-copy a list where each node has `next` and `random` (possibly null / any node).

**Constraints / edges worth remembering**
- `random` can point backward, forward, self, or null.
- O(1) extra space version interleaves clones.

---

## Intuition

**Interleave method:** weave clone nodes next to originals (`A→A'→B→B'`), set `A'.random = A.random.next`, then unweave into two lists.

HashMap original→clone is the simpler O(n) space approach.

---

## Approach

1. Insert clone after each node.
2. Assign clone randoms via `iter.random.next`.
3. Split lists; restore original `next` pointers.

---

## Solution sketch

```java
// weave clones
clone.next = node.next; node.next = clone;
// random: iter.next.random = iter.random.next
// unweave original vs copy using dummy head
```

---

## Complexity

| | |
|---|---|
| **Time** | O(n) |
| **Space** | O(1) extra (besides output) for interleave; O(n) with map |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Clone Graph** | Map + BFS/DFS |
| **Map approach** | First pass create nodes; second wire next/random |

---

## Pitfalls

- When setting random, null-check `iter.random`.
- Unweave carefully so original list is restored.
- Your weave loop must advance with `node = clone.next` (skip the clone) — verify pointer updates.
