# LC 153 — Find Minimum in Rotated Sorted Array

**Pattern:** Binary search  
**Difficulty:** Medium  
**Code:** [`FindMinInRotatedSortedArray.java`](../../../src/main/java/FindMinInRotatedSortedArray.java)

---

## Problem

Sorted ascending array rotated at an unknown pivot (no duplicates). Return the minimum element.

**Constraints / edges worth remembering**
- Not rotated → first element is min.
- Min is the only place where order “breaks” relative to the right end.

---

## Intuition

If `nums[mid] > nums[right]`, the min is strictly to the right of `mid`. Otherwise the min is at `mid` or to its left. Narrow until `left == right`.

---

## Approach

1. `left = 0`, `right = n - 1`.
2. While `left < right`: mid = …; if `nums[mid] > nums[right]` then `left = mid + 1`, else `right = mid`.
3. Return `nums[left]`.

---

## Solution sketch

```java
while (left < right) {
    int mid = left + (right - left) / 2;
    if (nums[mid] > nums[right]) left = mid + 1;
    else right = mid;
}
return nums[left];
```

---

## Complexity

| | |
|---|---|
| **Time** | O(log n) |
| **Space** | O(1) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Search target (LC 33)** | Find min index, then binary search the correct half |
| **With duplicates (LC 154)** | When equal to right, `right--` (worst O(n)) |

---

## Pitfalls

- `while (left < right)` — not `<=`.
- `right = mid`, never `mid - 1`, or you can drop the minimum.
- Your comments in code call this out — keep them in muscle memory.
