# LC 208 — Implement Trie (Prefix Tree)

**Pattern:** Trie  
**Difficulty:** Medium  
**Code:** [`TriePrefixTree.java`](../../../src/main/java/TriePrefixTree.java)

---

## Problem

Implement `insert`, `search` (full word), and `startsWith` (prefix) for lowercase words.

**Constraints / edges worth remembering**
- `search` requires `isEndOfWord`; `startsWith` does not.
- Alphabet size 26 → child array.

---

## Intuition

Each node has up to 26 children. Walking character by character shares prefixes. Mark the final node of an inserted word.

---

## Approach

1. `insert`: walk/create children; set `isEndOfWord` on the last node.
2. `search`: walk; fail on missing child; return `node.isEndOfWord`.
3. `startsWith`: same walk; return true if path exists.

---

## Solution sketch

```java
// insert
for each char: ensure children[c-'a']; node = child;
node.isEndOfWord = true;
// search / startsWith — walk; search checks isEndOfWord
```

---

## Complexity

| | |
|---|---|
| **Time** | O(L) per op — L = word/prefix length |
| **Space** | O(total characters inserted) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Add & Search Word (LC 211)** | DFS on `.` wildcard |
| **Word Search II** | Trie of words + board DFS |
| **Stream Checker** | Trie of reversed words; query stream suffix |

---

## Pitfalls

- `search("app")` false after only inserting `"apple"` until end flag is set on `"app"`.
- Null-check children before descending.
