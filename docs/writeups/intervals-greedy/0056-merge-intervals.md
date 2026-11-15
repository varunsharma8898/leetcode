# LC 56 — Merge Intervals

**Pattern:** Intervals / greedy  
**Difficulty:** Medium  
**Code:** [`MergeIntervals.java`](../../../src/main/java/MergeIntervals.java)

---

## Problem

Given intervals `[start, end]`, merge all overlapping ones and return the non-overlapping merged set.

**Constraints / edges worth remembering**
- Touching endpoints count as overlap (`[1,4]` + `[4,5]` → `[1,5]`).
- Sort by start first.

---

## Intuition

After sorting by start, overlaps can only happen with the previous merged interval. Extend its end if the next interval starts before/at that end; otherwise start a new merged interval.

---

## Approach

1. Sort by start (tie-break by end).
2. Seed `prev` with the first interval in the result list.
3. For each `curr`: if `curr.start <= prev.end`, `prev.end = max(prev.end, curr.end)`; else append `curr` as new `prev`.

---

## Solution sketch

```java
Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
List<int[]> result = new ArrayList<>();
int[] prev = intervals[0];
result.add(prev);
for (int[] curr : intervals) {
    if (curr[0] <= prev[1]) prev[1] = Math.max(prev[1], curr[1]);
    else { prev = curr; result.add(curr); }
}
```

---

## Complexity

| | |
|---|---|
| **Time** | O(n log n) — sort dominates |
| **Space** | O(n) — output (sort may be in-place) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Insert Interval (LC 57)** | Merge while inserting one new interval into sorted list |
| **Meeting Rooms II** | Sweep line / min-heap of end times |
| **Non-overlapping Intervals** | Greedy erase by earliest end |

---

## Pitfalls

- Use `<=` for overlap (inclusive ends).
- Mutating `prev` in place works because it’s the same array reference already in `result`.
