# LC 953 — Verifying an Alien Dictionary

**Pattern:** Strings / custom order  
**Difficulty:** Easy  
**Code:** [`AlienDictionary.java`](../../../src/main/java/AlienDictionary.java)

---

## Problem

Given words and a permutation `order` of the alphabet, return whether `words` is sorted lexicographically in that alien language.

**Constraints / edges worth remembering**
- Prefix rule: `"apple"` after `"app"` is **false** (longer word with equal prefix is greater).
- This is **not** LC 269 (deriving order from words).

---

## Intuition

Map each alien char to a normal comparable char (`a`, `b`, …) in order-index sequence. Convert each word and check adjacent pairs are nondecreasing under standard string compare.

---

## Approach

1. Build `orderMap`: alien char → `'a' + index`.
2. Convert words; ensure `converted[i-1] <= converted[i]` via `compareTo`.

---

## Solution sketch

```java
for (char c : order) orderMap.put(c, start++);
// convert words; if converted[i-1].compareTo(converted[i]) > 0 → false
```

---

## Complexity

| | |
|---|---|
| **Time** | O(N · L) total characters |
| **Space** | O(N · L) if storing converted; can compare in place with map |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Alien Dictionary (LC 269)** | Build graph of letter inequalities + topo sort |
| **In-place compare** | Walk two words with order index array `[26]` |

---

## Pitfalls

- Java `String.compareTo` already handles the prefix case (`"app" < "apple"`).
- Don’t confuse with the hard “find any valid order” problem.
