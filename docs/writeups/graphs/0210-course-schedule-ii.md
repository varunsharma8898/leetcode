# LC 210 — Course Schedule II

**Pattern:** Topological sort (Kahn)  
**Difficulty:** Medium  
**Code:** [`CourseSchedule2.java`](../../../src/main/java/CourseSchedule2.java)

---

## Problem

Return a valid order to finish all courses given prerequisites `[a,b]` (b before a). If impossible (cycle), return empty array.

**Constraints / edges worth remembering**
- Multiple valid orders may exist — any one is fine.
- Edge direction: `b → a`.

---

## Intuition

Same Kahn BFS as Course Schedule I, but record the dequeue order. If you process fewer than `n` nodes, cycle → `[]`.

---

## Approach

1. Build adj + in-degree.
2. Queue all in-degree 0.
3. Pop into `result[index++]`; reduce neighbors.
4. Return `result` if `index == n`, else `new int[0]`.

---

## Solution sketch

```java
result[index++] = element;
// ... reduce in-degrees, enqueue zeros
return index == n ? result : new int[0];
```

---

## Complexity

| | |
|---|---|
| **Time** | O(V + E) |
| **Space** | O(V + E) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Course Schedule I** | Only boolean `count == n` |
| **Alien Dictionary (LC 269)** | Build char graph from sorted word pairs + topo |
| **DFS topo** | Post-order insert; detect grey-node cycles |

---

## Pitfalls

- Return empty array on cycle, not a partial order.
- Same edge-direction bug surface as LC 207.
