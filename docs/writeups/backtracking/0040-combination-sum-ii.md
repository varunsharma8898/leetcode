# LC 40 — Combination Sum II

**Pattern:** Backtracking + skip duplicates  
**Difficulty:** Medium  
**Code:** [`CombinationSum2.java`](../../../src/main/java/CombinationSum2.java)

---

## Problem

Candidates may contain duplicates; each number used **at most once**. Return unique combinations summing to target.

**Constraints / edges worth remembering**
- Sort first.
- Skip same value at same depth: `i > start && a[i]==a[i-1]`.

---

## Intuition

Same backtracking as Combination Sum, but recurse with `i+1` and skip duplicate starts.

---

## Approach

Sort; DFS; on each i skip duplicates; push; `helper(i+1,…)`; pop.

---

## Solution sketch

```java
if (i > start && candidates[i] == candidates[i-1]) continue;
helper(i + 1, …); // not i
```

---

## Complexity

| | |
|---|---|
| **Time** | Exponential; O(2^n) bound typical |
| **Space** | O(n) depth + output |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Combination Sum I** | Unlimited reuse → helper(i,…) |
| **Subsets II** | Same duplicate-skip pattern |

---

## Pitfalls

- Must sort for the skip rule to work.
- Copy path when target hits 0.
