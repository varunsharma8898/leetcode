# LC 198 — House Robber

**Pattern:** DP — choose / skip  
**Difficulty:** Medium  
**Code:** [`HouseRobber.java`](../../../src/main/java/HouseRobber.java)

---

## Problem

Houses in a line with money `nums[i]`. Cannot rob adjacent houses. Maximize total.

**Constraints / edges worth remembering**
- Empty → 0; one house → that value.
- Circular version is House Robber II.

---

## Intuition

At each house: rob it (+ best up to i-2) or skip (best up to i-1). Rolling two variables is enough.

---

## Approach

1. `prev1` = best including up to previous house; `prev2` = best before that.
2. For each `num`: `new = max(prev2 + num, prev1)`; shift.
3. Or top-down memo: `max(rob(i-2)+nums[i], rob(i-1))`.

---

## Solution sketch

```java
int prev1 = 0, prev2 = 0;
for (int num : nums) {
    int tmp = prev1;
    prev1 = Math.max(prev2 + num, prev1);
    prev2 = tmp;
}
return prev1;
```

---

## Complexity

| | |
|---|---|
| **Time** | O(n) |
| **Space** | O(1) iterative; O(n) memo |

---

## Variations

| Variant | Change in approach |
|---|---|
| **House Robber II** | Run linear rob on `[0..n-2]` and `[1..n-1]`; take max |
| **House Robber III** | Tree DP: rob/skip per subtree |
| **Delete and Earn** | Bucket by value → House Robber on buckets |

---

## Pitfalls

- Off-by-one on i-1 vs i-2.
- Don’t mutate the input array unless intentional.
