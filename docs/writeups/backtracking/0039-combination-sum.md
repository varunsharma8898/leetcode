# LC 39 — Combination Sum

**Pattern:** Backtracking  
**Difficulty:** Medium  
**Code:** [`CombinationSum.java`](../../../src/main/java/CombinationSum.java)

---

## Problem

Distinct positive `candidates`. Return all unique combinations that sum to `target`. The same number may be reused unlimited times. Order within a combination doesn’t create uniqueness.

**Constraints / edges worth remembering**
- Unlimited reuse → recurse with same index `i`, not `i + 1`.
- Copy the path when recording a solution.

---

## Intuition

DFS choosing candidates in nondecreasing order (sort + start index) avoids duplicate combinations. Subtract from target; hit 0 → success; go negative → prune.

---

## Approach

1. Sort candidates.
2. Backtrack(`start`, `remain`, `path`).
3. For `i = start .. n-1`: push `candidates[i]`; recurse with `i` (reuse allowed); pop.
4. Base: `remain == 0` → add copy of path; `remain < 0` → return.

---

## Solution sketch

```java
helper(start, candidates, target, result, path) {
    if (target < 0) return;
    if (target == 0) { result.add(new ArrayList<>(path)); return; }
    for (int i = start; i < candidates.length; i++) {
        path.add(candidates[i]);
        helper(i, candidates, target - candidates[i], result, path); // i, not i+1
        path.remove(path.size() - 1);
    }
}
```

---

## Complexity

| | |
|---|---|
| **Time** | Exponential in target / branching — typical backtracking bound |
| **Space** | O(target / minCandidate) recursion depth + output |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Combination Sum II** | Each number once; skip duplicate values at same depth (`i > start && a[i]==a[i-1]`) |
| **Combination Sum III** | Fixed k numbers from 1..9 |
| **Combination Sum IV** | Count permutations → DP, not unique combos |
| **Permutations / Subsets** | Same template; change start / used[] rules |

---

## Pitfalls

- `new ArrayList<>(path)` when storing — otherwise every result aliases the same list.
- Reuse ⇒ `helper(i, …)` not `i + 1`.
