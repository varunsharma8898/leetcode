# LC 213 — House Robber II

**Pattern:** DP — circular  
**Difficulty:** Medium  
**Code:** [`HouseRobber2.java`](../../../src/main/java/HouseRobber2.java)

---

## Problem

Houses in a **circle** (first adjacent to last). Cannot rob adjacent. Maximize money.

**Constraints / edges worth remembering**
- Single house → that value.
- Cannot take both index 0 and n-1.

---

## Intuition

Solve linear House Robber twice: range `[0..n-2]` and `[1..n-1]`; take max.

---

## Approach

1. If n==1 return nums[0].
2. `max(robLinear(0,n-2), robLinear(1,n-1))` with the usual prev1/prev2 loop.

---

## Solution sketch

```java
return Math.max(helper(nums, 0, n-2), helper(nums, 1, n-1));
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
| **House Robber I** | Single linear range |
| **House Robber III** | Tree DP |

---

## Pitfalls

- Handle n==1 before splitting ranges.
- End indices are inclusive in your helper.
