# LC 11 — Container With Most Water

**Pattern:** Two pointers  
**Difficulty:** Medium  
**Code:** [`MaxAreaContainer.java`](../../../src/main/java/MaxAreaContainer.java)

---

## Problem

Heights at indices form vertical lines. Choose two lines that, with the x-axis, form a container holding the most water. Return that max area.

**Constraints / edges worth remembering**
- Area = `min(h[l], h[r]) * (r - l)`.
- Unlike Trapping Rain Water, only two lines matter — water doesn’t “fill valleys”.

---

## Intuition

Start at both ends (max width). The shorter line limits area, so advance the shorter side hoping for a taller line. Width only shrinks, so you only improve if height increases enough.

---

## Approach

1. `l = 0`, `r = n - 1`.
2. While `l < r`: compute area; move the pointer at the smaller height.
3. Track max area.

---

## Solution sketch

```java
int l = 0, r = n - 1, maxArea = 0;
while (l < r) {
    if (height[l] < height[r]) {
        maxArea = Math.max(maxArea, height[l] * (r - l));
        l++;
    } else {
        maxArea = Math.max(maxArea, height[r] * (r - l));
        r--;
    }
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
| **Trapping Rain Water (LC 42)** | Sum water over all bars using left/right maxes |
| **Brute force** | Try all pairs O(n²) — too slow, but good for proving correctness |

---

## Pitfalls

- Always move the **shorter** side (ties: either side is fine).
- Don’t confuse with trapping rain water’s per-index water formula.
