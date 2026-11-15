# LC 3 — Longest Substring Without Repeating Characters

**Pattern:** Sliding window  
**Difficulty:** Medium  
**Code:** [`LongestSubstringWithoutRepeatChars.java`](../../../src/main/java/LongestSubstringWithoutRepeatChars.java)

---

## Problem

Given a string `s`, return the length of the longest substring with all unique characters.

**Constraints / edges worth remembering**
- Empty string → 0.
- All same character → 1.
- Repeats can be anywhere in the current window, not just adjacent.

---

## Intuition

Grow a window `[left, right)` that always has unique chars. When `s[right]` is already in the window, shrink from the left until it’s gone, then expand again. Track max window length.

---

## Approach

1. Maintain a `Set` of chars in the current window.
2. Advance `right`; while `s[right]` is in the set, remove `s[left]` and `left++`.
3. Add `s[right]`, then `result = max(result, right - left)` (after incrementing `right`).

---

## Solution sketch

```java
Set<Character> window = new HashSet<>();
int left = 0, right = 0, result = 0;
while (right < s.length()) {
    while (window.contains(s.charAt(right)))
        window.remove(s.charAt(left++));
    window.add(s.charAt(right++));
    result = Math.max(result, right - left);
}
```

---

## Complexity

| | |
|---|---|
| **Time** | O(n) — each index enters/leaves the window at most once |
| **Space** | O(min(n, Σ)) — set of distinct chars in the window |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Longest substring with at most K distinct** | Window + freq map; shrink when distinct count &gt; K |
| **Minimum Window Substring (LC 76)** | Shrink when all required chars covered |
| **Find All Anagrams / Permutation in String** | Fixed-size window + counts |
| **Map last index** | Jump `left` to `last[c] + 1` instead of removing one-by-one |

---

## Pitfalls

- Update max **after** adding the new char (window is valid).
- `right - left` is the length when `right` has already been incremented past the last included index.
- HashSet works; interviewers may prefer `int[128]` / last-seen index for O(1) shrink.
