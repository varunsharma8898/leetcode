# LC 503 — Next Greater Element II

**Pattern:** Monotonic stack (circular)  
**Difficulty:** Medium  
**Code:** [`NextGreaterElement2.java`](../../../src/main/java/NextGreaterElement2.java)

---

## Problem

Circular array: for each index, next greater element to the right (wrapping). None → -1.

**Constraints / edges worth remembering**
- Loop `2n` with `i % n`.
- Init result with -1.

---

## Intuition

Monotonic decreasing stack of indices. When current value is larger, pop and fill. Circular → two passes.

---

## Approach

Fill res with -1; for i in 0..2n-1: while stack top < nums[i%n], pop and set; push i%n.

---

## Solution sketch

```java
for (int i = 0; i < 2 * n; i++) {
  while (!stack.isEmpty() && nums[i%n] > nums[stack.peek()])
    res[stack.pop()] = nums[i%n];
  stack.push(i % n);
}
```

---

## Complexity

| | |
|---|---|
| **Time** | O(n) |
| **Space** | O(n) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Next Greater Element I** | Map from nums1 via stack on nums2 |
| **Daily Temperatures** | Same stack, distance instead of value |

---

## Pitfalls

- Don’t forget `% n` for circular index.
- Pushing every iteration of 2n may leave duplicates on stack — still correct because later equal indices overwrite harmlessly; optional: push only on first pass.
