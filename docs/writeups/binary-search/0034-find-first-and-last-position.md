# LC 34 — Find First and Last Position of Element in Sorted Array

**Pattern:** Binary search (lower/upper bound)  
**Difficulty:** Medium  
**Code:** [`FindFirstLastPositionSortedArray.java`](../../../src/main/java/FindFirstLastPositionSortedArray.java)

---

## Problem

Sorted array (non-decreasing). Return `[first, last]` indices of `target`, or `[-1, -1]` if missing. O(log n).

**Constraints / edges worth remembering**
- Empty array.
- Target absent but mid values nearby.
- All elements equal to target.

---

## Intuition

Two binary searches: one biased left (keep searching left after a hit), one biased right.

---

## Approach

1. `findStart`: on match, record mid and set `right = mid - 1`.
2. `findEnd`: on match, record mid and set `left = mid + 1`.
3. Verify `nums[start/end] == target` before writing into the result (handles miss).

---

## Solution sketch

```java
// start: when equal, start=mid; right=mid-1
// end:   when equal, end=mid;   left=mid+1
if (nums[start] == target) result[0] = start;
if (nums[end] == target) result[1] = end;
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
| **Search Insert Position** | Lower bound only |
| **First Bad Version** | Same left-biased binary search |
| **Count occurrences** | `last - first + 1` |

---

## Pitfalls

- Don’t return mid on first hit — keep narrowing for first/last.
- On miss, recorded start/end may be wrong indices; always compare to `target`.
