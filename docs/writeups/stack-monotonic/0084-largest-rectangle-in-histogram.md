# LC 84 — Largest Rectangle in Histogram

**Pattern:** Monotonic stack  
**Difficulty:** Hard  
**Code:** [`MaxRectangleInHistogram.java`](../../../src/main/java/MaxRectangleInHistogram.java)

---

## Problem

Bars of width 1 with given heights. Return the area of the largest rectangle in the histogram.

**Constraints / edges worth remembering**
- Empty / null → 0.
- Rectangle height is limited by the shortest bar inside its width.

---

## Intuition

For each bar, find how far it can extend left/right while remaining the shortest. A monotonic increasing stack of heights finds the previous smaller bar; when a shorter bar appears, pop and compute area with width `i - startIndex`.

---

## Approach

1. Maintain parallel stacks: heights and the leftmost index that height can cover.
2. When current height is smaller than stack top, pop and area = `height * (i - index)`.
3. Push current height with the (possibly extended) index.
4. After the loop, flush remaining bars using `n - index` as width.

---

## Solution sketch

```java
// heightStack + indexStack; index may stretch left when popping
while (!heightStack.isEmpty() && heightStack.peek() > heights[i]) {
    int h = heightStack.pop();
    tmpIndex = indexStack.pop();
    maxArea = Math.max(maxArea, h * (i - tmpIndex));
}
heightStack.push(heights[i]);
indexStack.push(tmpIndex);
// flush with width = n - tmpIndex
```

---

## Complexity

| | |
|---|---|
| **Time** | O(n) |
| **Space** | O(n) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Maximal Rectangle (LC 85)** | Treat each row as histogram base heights; run LC 84 per row |
| **Sentinel 0** | Append height 0 to force flush instead of a second loop |

---

## Pitfalls

- When popping, reuse the popped **index** for the new bar — it can extend left over taller bars you just removed.
- Flush the stack after the main loop.
- Null/empty early return.
