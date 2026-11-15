# LC 33 — Search in Rotated Sorted Array

**Pattern:** Binary search (find pivot, then search)  
**Difficulty:** Medium  
**Code:** [`SearchInRotatedSortedArray.java`](../../../src/main/java/SearchInRotatedSortedArray.java)

---

## Problem

Array was sorted ascending then rotated at an unknown pivot. Search for `target` in O(log n). Return index or `-1`. (No duplicates in the classic version.)

**Constraints / edges worth remembering**
- Single-element arrays.
- Not rotated (already sorted).
- Target may lie in the left “high” half or right “low” half.

---

## Intuition

The rotation creates two sorted halves. Find the index of the minimum (pivot), decide which half can contain `target`, then binary search that half.

---

## Approach

1. Find min index with `left < right`, compare `nums[mid]` vs `nums[right]`.
2. If `target > nums[n-1]`, search `[0 .. pivot]`; else search `[pivot .. n-1]`.
3. Standard binary search in the chosen range.

---

## Solution sketch

```java
int pivot = findMinIndex(nums); // while left < right; mid > right → left=mid+1 else right=mid
int left = 0, right = n - 1;
if (target > nums[right]) right = pivot;
else left = pivot;
// classic binary search for target
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
| **Find Minimum (LC 153)** | Just return `nums[pivot]` |
| **With duplicates (LC 81)** | When `nums[mid] == nums[right]`, shrink carefully — can degrade to O(n) |
| **One-pass** | At each mid, decide which side is sorted and whether target is in that side |

---

## Pitfalls

- Min-finding loop must be `left < right` (not `<=`) to avoid infinite loop.
- When not taking `mid + 1`, keep `right = mid` (not `mid - 1`) so the min isn’t skipped.
- Compare mid with **right** on a rotated array, not with left.
