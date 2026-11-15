# LC 146 — LRU Cache

**Pattern:** Design — HashMap + doubly linked list  
**Difficulty:** Medium  
**Code:** [`LRUCache.java`](../../../src/main/java/LRUCache.java)

---

## Problem

Design a cache with `get` and `put` in O(1). Evict the least recently used key when capacity is exceeded. Both get and put count as “use”.

**Constraints / edges worth remembering**
- Capacity ≥ 1 typically.
- Updating an existing key is a put that refreshes recency.
- Get miss returns `-1`.

---

## Intuition

HashMap gives O(1) lookup by key. A doubly linked list orders nodes by recency (front = most recent). Sentinel head/tail simplify edge inserts/removes.

---

## Approach

1. `get`: if present, move node to front; return value; else `-1`.
2. `put` existing: update value, move to front.
3. `put` new: if at capacity, remove tail’s prev from list + map; insert new node at front.

---

## Solution sketch

```java
// Map<Integer, Node> + dummy head/tail
get: moveToFront(node); return node.val;
put new at capacity: evict tail.prev; remove from map;
put: create/update node; moveToFront;
```

---

## Complexity

| | |
|---|---|
| **Time** | O(1) get/put |
| **Space** | O(capacity) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **LFU Cache (LC 460)** | Freq lists + min-freq pointer |
| **LinkedHashMap** | Java shortcut with `accessOrder=true` (say you know it; still explain the list) |
| **Thread-safe** | Discuss locking / concurrent structures in follow-up |

---

## Pitfalls

- Evict **before** inserting when at capacity (or carefully if updating existing).
- `moveToFront` must unlink from old position first (guard null prev/next on fresh nodes).
- Store **key** on the node so eviction can remove from the map.
