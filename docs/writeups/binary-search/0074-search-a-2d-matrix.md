# LC 74 — Search a 2D Matrix

**Pattern:** Binary search on virtual array  
**Difficulty:** Medium  
**Code:** [`Search2DMatrix.java`](../../../src/main/java/Search2DMatrix.java)

---

## Problem

Matrix: each row sorted; first of each row > last of previous. Search target in O(log(mn)).

**Constraints / edges worth remembering**
- Treat as 1D array of length m*n.
- mid → (mid/cols, mid%cols).

---

## Intuition

Binary search on flattened index space.

---

## Approach

`left=0, right=m*n-1`; map mid to row/col; classic BS.

---

## Solution sketch

```java
int row = mid / cols, col = mid % cols;
if (target == matrix[row][col]) return true;
```

---

## Complexity

| | |
|---|---|
| **Time** | O(log(m · n)) |
| **Space** | O(1) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Search 2D Matrix II** | Start top-right staircase — rows/cols sorted independently |
| **Find Peak 2D** | Different binary elimination |

---

## Pitfalls

- Empty matrix guard.
- Col count from `matrix[0].length`.
