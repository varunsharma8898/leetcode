# LC 49 — Group Anagrams

**Pattern:** Strings / hashing  
**Difficulty:** Medium  
**Code:** [`GroupAnagrams.java`](../../../src/main/java/GroupAnagrams.java)

---

## Problem

Group strings that are anagrams of each other. Order of groups / within groups can be anything.

**Constraints / edges worth remembering**
- Empty string is a valid anagram key.
- Case: typically lowercase in LC.

---

## Intuition

Anagrams share the same sorted character sequence (or the same char-count signature). Use that as a hashmap key → list of originals.

---

## Approach

1. For each string, sort its chars → key.
2. Append original string to `map[key]`.
3. Return map values.

---

## Solution sketch

```java
Map<String, List<String>> map = new HashMap<>();
for (String str : strs) {
    char[] chars = str.toCharArray();
    Arrays.sort(chars);
    String key = String.valueOf(chars);
    map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
}
return new ArrayList<>(map.values());
```

---

## Complexity

| | |
|---|---|
| **Time** | O(n · k log k) with sort key (n strings, length k); O(n · k) with count signature |
| **Space** | O(n · k) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Valid Anagram** | Single pair compare via counts |
| **Count key** | `int[26]` serialized as key — better when k is large |
| **Group Shifted Strings** | Normalize by offset from first char |

---

## Pitfalls

- Must use the **sorted form as key**, not the original string.
- Don’t forget empty-string / single-char cases.
