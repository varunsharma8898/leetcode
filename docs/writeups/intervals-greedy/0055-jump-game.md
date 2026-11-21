# LC 55 — Jump Game

**Pattern:** Greedy  
**Difficulty:** Medium  
**Code:** [`JumpGame.java`](../../../src/main/java/JumpGame.java)

---

## Problem

From index 0, at index `i` you may jump up to `nums[i]` steps. Return whether you can reach the last index.

**Constraints / edges worth remembering**
- `n < 2` → true.
- Zero in the middle can trap you if max reach equals that index.

---

## Intuition

Track farthest reachable index. If you ever stand at an index beyond that reach, fail. If farthest covers the end, success.

Alternate: scan right→left; shrink target to `i` whenever `i + nums[i] >= target`.

---

## Approach

```java
int maxIndex = 0;
for (int i = 0; i < n; i++) {
    if (maxIndex >= n - 1) return true;
    maxIndex = Math.max(maxIndex, i + nums[i]);
    if (maxIndex == i) return false; // stuck
}
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
| **Jump Game II** | Greedy levels / BFS-on-array for min jumps |
| **Jump Game III** | BFS/DFS to value 0 with ±nums[i] |

---

## Pitfalls

- Update `maxIndex` before concluding stuck — order in the loop matters.
- `maxIndex == i` after update means you cannot move past i.
