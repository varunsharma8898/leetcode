# LC 72 — Edit Distance

**Pattern:** DP — Levenshtein  
**Difficulty:** Medium  
**Code:** [`EditDistance.java`](../../../src/main/java/EditDistance.java)

---

## Problem

Minimum insertions, deletions, or replacements to turn `word1` into `word2`.

**Constraints / edges worth remembering**
- Empty string → answer is the other length.
- Matching last chars → take diagonal without +1.

---

## Intuition

`dp[i][j]` = edit distance of first `i` chars of word1 and first `j` of word2. Transitions: replace/delete/insert each cost 1; if chars equal, replace cost is just `dp[i-1][j-1]`.

---

## Approach

1. `dp[i][0] = i`, `dp[0][j] = j`.
2. For i,j ≥ 1: if equal, `dp = dp[i-1][j-1]`; else `1 + min(replace, delete, insert)`.

---

## Solution sketch

```java
int replace = res[i-1][j-1], delete = res[i-1][j], insert = res[i][j-1];
res[i][j] = word1.charAt(i-1) == word2.charAt(j-1)
    ? replace
    : 1 + Math.min(replace, Math.min(delete, insert));
```

---

## Complexity

| | |
|---|---|
| **Time** | O(m · n) |
| **Space** | O(m · n) — can roll to O(min(m,n)) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **One-edit distance** | Early exit / single mismatch rules |
| **Delete Operations for Two Strings** | Related LCS: `m+n-2*LCS` |

---

## Pitfalls

- Border init is `i` / `j`, not all zeros or ones.
- When chars match, use diagonal **without** adding 1 (your code sets this after computing `1+min` — order matters).
