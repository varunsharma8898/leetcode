# LC 25 — Reverse Nodes in k-Group

**Pattern:** Linked list  
**Difficulty:** Hard  
**Code:** [`ReverseNodesInKGroups.java`](../../../src/main/java/ReverseNodesInKGroups.java)

---

## Problem

Reverse the list in groups of `k` nodes. Leftover &lt; k nodes at the end stay as-is. Constant extra space.

**Constraints / edges worth remembering**
- `k == 1` → unchanged.
- Incomplete final group is not reversed.

---

## Intuition

Use a dummy. Walk counting nodes; every time count hits a multiple of k, reverse the sublist between `begin` and `curr.next`, then set `begin` to the new tail of that segment.

---

## Approach

1. Dummy → head; `begin = dummy`.
2. Count with `curr`; when `i % k == 0`, `begin = reverse(begin, curr.next)`.
3. `reverse(begin, end)` reverses `(begin, end)` exclusive of end; returns new tail (`last`) to become next `begin`.

---

## Solution sketch

```java
if (i % k == 0) {
    begin = reverse(begin, curr.next);
    curr = begin.next;
}
// reverse: standard pointer flip until curr == end;
// begin.next = prev; last.next = end; return last;
```

---

## Complexity

| | |
|---|---|
| **Time** | O(n) |
| **Space** | O(1) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Swap Nodes in Pairs** | k = 2 special case |
| **Reverse Linked List II** | One sublist `[left, right]` |

---

## Pitfalls

- `reverse` must return the node that becomes the next group’s `begin`.
- Don’t reverse a partial trailing group — your count method naturally waits for full groups.
