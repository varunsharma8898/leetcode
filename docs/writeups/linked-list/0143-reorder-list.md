# LC 143 — Reorder List

**Pattern:** Split + reverse + merge  
**Difficulty:** Medium  
**Code:** [`ReorderList.java`](../../../src/main/java/ReorderList.java)

---

## Problem

Reorder `L0→L1→…→Ln` to `L0→Ln→L1→Ln-1→…` in-place.

**Constraints / edges worth remembering**
- Find mid with slow/fast.
- Reverse second half; weave.

---

## Intuition

Three steps: mid, reverse second half, alternate-merge halves.

---

## Approach

1. Slow/fast to mid.
2. Reverse from mid.
3. Merge alternating (`flag` recursion or iterative).

---

## Solution sketch

```java
p1 mid via slow/fast; head2 = reverse(p1);
merge alternating from head and head2;
```

---

## Complexity

| | |
|---|---|
| **Time** | O(n) |
| **Space** | O(1) iterative merge preferred |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Palindrome Linked List** | Same reverse-second-half idea |
| **Zigzag iterator patterns** | Two-list weave |

---

## Pitfalls

- Mid split details differ for even/odd — practice both.
- Avoid cycles when merging (stop when halves meet).
