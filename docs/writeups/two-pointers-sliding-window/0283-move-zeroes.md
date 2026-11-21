# LC 283 — Move Zeroes

**Pattern:** Two pointers / in-place  
**Difficulty:** Easy  
**Code:** [`MoveZeros.java`](../../../src/main/java/MoveZeros.java)

---

## Problem

Move all zeros to the end, keeping relative order of non-zeros. In-place.

**Constraints / edges worth remembering**
- Two-pass: compact non-zeros, then fill zeros.
- Or swap with slow pointer.

---

## Intuition

Write non-zeros to the front with a write index; fill the rest with 0.

---

## Approach

`counter` write pointer; copy non-zeros; zero out from counter to end.

---

## Solution sketch

```java
if (nums[i] != 0) nums[counter++] = nums[i];
for (i = counter; i < n; i++) nums[i] = 0;
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
| **Remove Element** | Same write-pointer pattern |
| **Sort Array By Parity** | Partition swaps |

---

## Pitfalls

- Preserve order of non-zeros.
- Second loop must start at `counter`.
