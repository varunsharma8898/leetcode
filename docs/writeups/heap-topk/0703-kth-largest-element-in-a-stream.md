# LC 703 — Kth Largest Element in a Stream

**Pattern:** Min-heap of size k  
**Difficulty:** Easy  
**Code:** [`KthLargestInAStream.java`](../../../src/main/java/KthLargestInAStream.java)

---

## Problem

Design a class that, given stream adds, returns the kth largest element after each add.

**Constraints / edges worth remembering**
- Min-heap of size k; peek is kth largest.
- Constructor should use `add()` so capacity is enforced.

---

## Intuition

Keep the k largest seen; the smallest among them (heap peek) is the answer.

---

## Approach

Min-heap; offer; if size > k poll; return peek.

---

## Solution sketch

```java
pq.offer(val); if (pq.size() > capacity) pq.poll(); return pq.peek();
```

---

## Complexity

| | |
|---|---|
| **Time** | O(log k) per add |
| **Space** | O(k) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Kth Largest in Array** | Quickselect or heap once |
| **Top K Frequent** | Heap with custom comparator |

---

## Pitfalls

- Use add() in constructor, not raw offer without trimming.
- Min-heap, not max-heap.
