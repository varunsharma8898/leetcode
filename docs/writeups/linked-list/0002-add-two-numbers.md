# LC 2 — Add Two Numbers

**Pattern:** Linked list — digit-wise  
**Difficulty:** Medium  
**Code:** [`AddTwoNumbersLinkedList.java`](../../../src/main/java/AddTwoNumbersLinkedList.java)

---

## Problem

Two non-empty lists store non-negative integers **in reverse** digit order. Add them; return sum as a list (also reverse).

**Constraints / edges worth remembering**
- Unequal lengths.
- Final carry may create an extra node.

---

## Intuition

Walk both lists with a running `sum` that keeps carry via `sum /= 10` each step; append `sum % 10`.

---

## Approach

Dummy head; while either list remains: fold carry, add digits, append; if carry left, append 1.

---

## Solution sketch

```java
sum /= 10; // previous carry
if (l1 != null) { sum += l1.val; l1 = l1.next; }
head.next = new ListNode(sum % 10);
```

---

## Complexity

| | |
|---|---|
| **Time** | O(max(m, n)) |
| **Space** | O(max(m, n)) output |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Add Two Numbers II** | Forward order → stacks or reverse first |
| **Plus One Linked List** | Similar carry propagation |

---

## Pitfalls

- Don’t drop the final carry.
- Digits are reverse order — don’t reverse unless asked.
