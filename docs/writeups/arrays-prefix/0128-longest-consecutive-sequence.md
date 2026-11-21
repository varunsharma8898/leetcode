# LC 128 — Longest Consecutive Sequence

**Pattern:** Hash set  
**Difficulty:** Medium  
**Code:** [`LongestConsecutiveSequence.java`](../../../src/main/java/LongestConsecutiveSequence.java)

---

## Problem

Return length of the longest consecutive elements sequence. O(n) required (no sort that costs n log n as the intended solution).

**Constraints / edges worth remembering**
- Duplicates don’t extend length.
- Numbers can be negative / sparse.

---

## Intuition

Put all numbers in a set. Only start a streak from values where `x-1` is missing (true sequence start). Count forward while `x+1` exists.

---

## Approach

1. Build `HashSet`.
2. For each `x`, skip if `x-1` present.
3. Else walk `y = x+1, x+2, …`; `best = max(best, y - x)`.

---

## Solution sketch

```java
if (numSet.contains(x - 1)) continue;
int y = x + 1;
while (numSet.contains(y)) y++;
best = Math.max(best, y - x);
```

---

## Complexity

| | |
|---|---|
| **Time** | O(n) — each number visited constant times as streak start/extension |
| **Space** | O(n) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Sort then scan** | O(n log n) — simpler but not the target |
| **Union-Find** | Unite neighbors; track component sizes |

---

## Pitfalls

- Must skip non-starts; otherwise O(n²) on long ranges.
- Length is `y - x`, not `y - x + 1` once `y` is the first missing.
