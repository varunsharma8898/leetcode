# LC 48 — Rotate Image

**Pattern:** Matrix transform  
**Difficulty:** Medium  
**Code:** [`RotateImage.java`](../../../src/main/java/RotateImage.java)

---

## Problem

Rotate an `n x n` matrix 90° clockwise **in-place**.

**Constraints / edges worth remembering**
- Clockwise: reverse rows top↔bottom, then transpose.
- Anti-clockwise: transpose then reverse.

---

## Intuition

Two geometric steps beat layer-by-layer 4-cycles for clarity (both O(n²)).

---

## Approach

1. Reverse vertically.
2. Transpose (swap `matrix[i][j]` with `matrix[j][i]` for j < i).

---

## Solution sketch

```java
reverse top-down;
for i for j < i: swap(matrix[i][j], matrix[j][i]);
```

---

## Complexity

| | |
|---|---|
| **Time** | O(n²) |
| **Space** | O(1) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Spiral Matrix** | Traversal order |
| **Anti-clockwise rotate** | Transpose then reverse (your helper) |

---

## Pitfalls

- Transpose only j < i to avoid double-swap.
- Don’t allocate a second matrix unless allowed.
