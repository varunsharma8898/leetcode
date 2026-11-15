# LC 238 — Product of Array Except Self

**Pattern:** Prefix / suffix products  
**Difficulty:** Medium  
**Code:** [`ProductOfArrayExceptSelf.java`](../../src/main/java/ProductOfArrayExceptSelf.java)

---

## Problem

Return an array `answer` where `answer[i]` is the product of all elements of `nums` except `nums[i]`. Solve without using division, in O(n) time.

**Constraints / edges worth remembering**
- Zeros in the array make division-based tricks fail — prefix/suffix still works.
- Output length equals input length.

---

## Intuition

`answer[i] = (product of everything left of i) × (product of everything right of i)`. Build left products, build right products, multiply. Optimized version reuses the output array for left products and a single running `right` scalar for the second pass.

---

## Approach

**Two-array version**
1. `left[0] = 1`; `left[i] = left[i-1] * nums[i-1]`.
2. `right[n-1] = 1`; fill from the right symmetrically.
3. `answer[i] = left[i] * right[i]`.

**O(1) extra space version** (your `productExceptSelfOptimized`)
1. Write left products into `answer`.
2. Sweep right → left with a running `right` multiplier.

---

## Solution sketch

```java
// optimized
answer[0] = 1;
for (int i = 1; i < n; i++)
    answer[i] = answer[i - 1] * nums[i - 1];

int right = 1;
for (int i = n - 1; i >= 0; i--) {
    answer[i] *= right;
    right *= nums[i];
}
```

---

## Complexity

| | |
|---|---|
| **Time** | O(n) |
| **Space** | O(1) extra (output not counted) for optimized; O(n) for two aux arrays |

---

## Variations

| Variant | Change in approach |
|---|---|
| **With division** | Total product / `nums[i]` — careful with zeros (0 / 1 / 2 zeros cases) |
| **Prefix sums analog** | Same idea for “sum except self” or range queries |
| **Follow-up: streaming / immutable nums** | Prefer explicit left/right arrays for clarity |

---

## Pitfalls

- `left[0]` and `right[n-1]` must be `1` (empty product).
- In the right pass, multiply `answer[i]` by `right` *before* updating `right *= nums[i]`.
- Interviewers often ask for the O(1)-extra version after the two-array solution.
