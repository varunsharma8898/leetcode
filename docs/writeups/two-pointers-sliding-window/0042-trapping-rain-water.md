# LC 42 — Trapping Rain Water

**Pattern:** Prefix / suffix max (two-pass)  
**Difficulty:** Hard  
**Code:** [`TrappingRainWater.java`](../../../src/main/java/TrappingRainWater.java)

---

## Problem

Given non-negative heights of bars of width 1, compute how much water can be trapped after raining.

**Constraints / edges worth remembering**
- `null`, empty, or length &lt; 3 → 0 (no “valley”).
- Water at index `i` is bounded by the shorter of the tallest bar on the left and on the right.

---

## Intuition

At each index, water height = `min(maxLeft, maxRight) - height[i]` (clamped at ≥ 0). Precompute the running max from left and from right, then one more pass to sum.

---

## Approach

1. Early-exit if length &lt; 3.
2. Build `leftArr[i]` = max height on `[0..i]`.
3. Build `rightArr[i]` = max height on `[i..n-1]`.
4. For each `i`, add `min(leftArr[i], rightArr[i]) - height[i]`.

Your code fills both arrays in one loop by walking from both ends.

---

## Solution sketch

```java
leftArr[0] = height[0];
rightArr[n - 1] = height[n - 1];
for (int i = 1; i < n; i++) {
    leftArr[i] = Math.max(height[i], leftArr[i - 1]);
    rightArr[n - i - 1] = Math.max(height[n - i - 1], rightArr[n - i]);
}
for (int i = 0; i < n; i++)
    total += Math.min(leftArr[i], rightArr[i]) - height[i];
```

---

## Complexity

| | |
|---|---|
| **Time** | O(n) — two linear passes |
| **Space** | O(n) — two aux arrays |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Two pointers O(1) space** | Advance the side with smaller max; water decided by the known shorter wall |
| **Monotonic stack** | Stack of indices; when a taller bar appears, pop and add trapped width × height |
| **Container With Most Water (LC 11)** | Maximize area between two lines, not trapped units between many bars |
| **Trapping Rain Water II (2D)** | Priority-queue / BFS from borders inward |

---

## Pitfalls

- Must seed `leftArr[0]` / `rightArr[n-1]` with boundary heights.
- Start the fill loop at `i = 1`, not `0`.
- `min(left, right) - height` is never negative when left/right are maxes that include `height[i]` itself.
