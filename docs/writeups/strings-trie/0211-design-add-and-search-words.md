# LC 211 — Design Add and Search Words Data Structure

**Pattern:** Trie + DFS for `.`  
**Difficulty:** Medium  
**Code:** [`WordDictionary.java`](../../../src/main/java/WordDictionary.java)

---

## Problem

`addWord(word)` and `search(word)` where search may include `'.'` matching any letter.

**Constraints / edges worth remembering**
- `'.'` can appear multiple times.
- Search must land on `isEndOfWord`.

---

## Intuition

Standard trie for add. For search: recurse; on `.`, try all 26 children; on a letter, follow that child only.

---

## Approach

1. `addWord` — same as Implement Trie.
2. `searchHelper(word, level, node)`: if level==len return `isEndOfWord`; if char≠`.`, descend one path; else loop children.

---

## Solution sketch

```java
if (c != '.')
    return node.next[c-'a'] != null && searchHelper(word, level+1, node.next[c-'a']);
for (TrieNode child : node.next)
    if (child != null && searchHelper(word, level+1, child)) return true;
```

---

## Complexity

| | |
|---|---|
| **Time** | Add O(L); search O(L) normal, up to O(26^L) worst with dots |
| **Space** | O(total chars) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Implement Trie (LC 208)** | No wildcard |
| **Word Search II** | Trie of words + board DFS |

---

## Pitfalls

- Don’t require end-of-word until the full pattern is consumed.
- Short-circuit on first successful `.` branch.
