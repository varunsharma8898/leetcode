# LC 162 — Find Peak Element

**Pattern:** Binary search on slope  
**Difficulty:** Medium  
**Code:** [`FindPeakElement.java`](../../../src/main/java/FindPeakElement.java)

---

## Problem

Peak = greater than neighbors (nums[-1]=nums[n]=-∞). Return any peak index in O(log n).

**Constraints / edges worth remembering**
- Length 1 → 0.
- Check ends first if desired; else mid slope.

---

## Intuition

If mid < left neighbor, a peak lies left; if mid < right neighbor, peak lies right; else mid is peak.

---

## Approach

Handle ends; BS in (1..n-2); move toward the rising slope.

---

## Solution sketch

```java
if (nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1]) return mid;
else if (nums[mid] < nums[mid-1]) right = mid-1;
else left = mid+1;
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
| **Find Peak Element II** | 2D variant |
| **Bitonic array search** | Related slope ideas |

---

## Pitfalls

- Any peak is accepted — don’t overfit to the global max.
- Ends are peaks if descending into the array.
