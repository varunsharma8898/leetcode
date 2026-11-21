# LC 21 — Merge Two Sorted Lists

**Pattern:** Linked list merge  
**Difficulty:** Easy  
**Code:** [`MergeSortedLinkedLists.java`](../../../src/main/java/MergeSortedLinkedLists.java)

---

## Problem

Merge two sorted lists into one sorted list; return head.

**Constraints / edges worth remembering**
- Either list null → return the other.
- Reuse existing nodes.

---

## Intuition

Dummy head; always attach the smaller of the two fronts; splice remainder when one empties.

---

## Approach

While both non-null, take min; then `curr.next = leftover`.

---

## Solution sketch

```java
if (list1.val > list2.val) attach list2; else attach list1;
curr.next = (list1 == null) ? list2 : list1;
```

---

## Complexity

| | |
|---|---|
| **Time** | O(m + n) |
| **Space** | O(1) extra |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Merge k Sorted Lists** | Heap or divide-and-conquer merge |
| **Merge Sorted Arrays** | Same idea from the back |

---

## Pitfalls

- Dummy simplifies head handling.
- Advance the list you took from.
