# LC 142 — Linked List Cycle II

**Pattern:** Linked list / Floyd  
**Difficulty:** Medium  
**Code:** [`LinkedListCycle2.java`](../../../src/main/java/LinkedListCycle2.java)

---

## Problem

If a linked list has a cycle, return the node where the cycle begins; otherwise `null`.

**Constraints / edges worth remembering**
- No cycle → `null`.
- Cycle may start at head.

---

## Intuition

Floyd: slow/fast meet inside the cycle. Reset one pointer to head; advance both one step — they meet at the cycle entrance (equal remaining distance math).

---

## Approach

1. Slow/fast from head; move 1 and 2 until meet or fast hits null.
2. If no meet → `null`.
3. Advance `head` and `slow` together until equal; return that node.

---

## Solution sketch

```java
while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
    if (slow == fast) break;
}
if (fast == null || fast.next == null) return null;
while (head != slow) { head = head.next; slow = slow.next; }
return slow;
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
| **Linked List Cycle (LC 141)** | Only detect boolean meeting |
| **Hash set** | First repeated node is entrance — O(n) space |

---

## Pitfalls

- After the first loop, check that a meeting actually happened.
- Don’t reset `slow` to head if you keep using the meeting node and move `head` — either pattern works; be consistent.
