# LC 460 — LFU Cache

**Pattern:** Design — freq buckets + LRU within freq  
**Difficulty:** Hard  
**Code:** [`LFUCache.java`](../../../src/main/java/LFUCache.java)

---

## Problem

Cache with O(1) `get`/`put`. Evict least **frequently** used; ties broken by least recently used among that frequency.

**Constraints / edges worth remembering**
- Capacity 0 → puts are no-ops.
- Get/put on existing key bumps frequency.

---

## Intuition

Three maps: `key→value`, `key→freq`, `freq→LinkedHashSet(keys)` (insertion order = LRU within that freq). Track global `min` frequency for eviction.

---

## Approach

**get:** bump freq; move key from old freq set to `freq+1` set; if old set empty and freq==min, `min++`.  
**put new:** if full, evict first key in `freqBucketList.get(min)`; insert at freq 1; `min = 1`.  
**put existing:** update value + call get logic.

---

## Solution sketch

```java
// evict: freqBucketList.get(min).iterator().next()
// on bump: remove from freq set; add to freq+1; maybe min++
```

---

## Complexity

| | |
|---|---|
| **Time** | O(1) amortized ops |
| **Space** | O(capacity) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **LRU (LC 146)** | Only recency — DLL + HashMap |
| **Custom LinkedHashSet** | Manual DLL per frequency bucket |

---

## Pitfalls

- After eviction of last key at `min`, new inserts reset `min = 1`.
- Updating an existing key should not double-count capacity.
- `LinkedHashSet` gives LRU order within the same frequency.
