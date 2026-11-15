# LC 206 — Reverse Linked List

**Pattern:** Linked list  
**Difficulty:** Easy  
**Code:** [`ReverseLinkedList.java`](../../../src/main/java/ReverseLinkedList.java)

---

## Problem

Reverse a singly linked list and return the new head.

**Constraints / edges worth remembering**
- Empty list / single node.
- Iterative vs recursive both fair game.

---

## Intuition

Walk the list, flipping each `next` pointer to the previous node. Keep three references: `prev`, `curr`, `next`.

---

## Approach

1. `prev = null`, `curr = head`.
2. While `curr != null`: save `next`, set `curr.next = prev`, advance `prev = curr`, `curr = next`.
3. Return `prev`.

---

## Solution sketch

```java
ListNode prev = null, curr = head, next;
while (curr != null) {
    next = curr.next;
    curr.next = prev;
    prev = curr;
    curr = next;
}
return prev;
```

---

## Complexity

| | |
|---|---|
| **Time** | O(n) |
| **Space** | O(1) iterative |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Reverse Linked List II** | Reverse only sublist `[left, right]` |
| **Reverse Nodes in k-Group** | Reverse every k nodes; recurse/iterate on remainder |
| **Palindrome Linked List** | Reverse second half, compare |

---

## Pitfalls

- Save `next` before overwriting `curr.next`.
- New head is `prev`, not the original head.
