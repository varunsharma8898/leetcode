# LC 19 — Remove Nth Node From End of List

**Pattern:** Two pointers  
**Difficulty:** Medium  
**Code:** [`RemoveNthNodeFromEnd.java`](../../../src/main/java/RemoveNthNodeFromEnd.java)

---

## Problem

Remove the nth node from the end; return head.

**Constraints / edges worth remembering**
- Dummy handles removing the head.
- Gap between fast and slow is n+1 steps from dummy.

---

## Intuition

Fast leads by n+1 from dummy so slow lands on the node before the removal target.

---

## Approach

Dummy→head; advance fast n+1; move both until fast null; `slow.next = slow.next.next`.

---

## Solution sketch

```java
for (i = 1; i <= n + 1; i++) fast = fast.next;
while (fast != null) { slow = slow.next; fast = fast.next; }
slow.next = slow.next.next;
```

---

## Complexity

| | |
|---|---|
| **Time** | O(L) |
| **Space** | O(1) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Delete Middle Node** | Fast/slow midpoint |
| **Swapping Nodes** | Find kth from start and end |

---

## Pitfalls

- Use dummy — critical when n = length.
- Lead by n+1 from dummy, not n from head (off-by-one trap).
