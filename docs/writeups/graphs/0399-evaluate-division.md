# LC 399 — Evaluate Division

**Pattern:** Weighted graph BFS/DFS  
**Difficulty:** Medium  
**Code:** [`EvaluateDivision.java`](../../../src/main/java/EvaluateDivision.java)

---

## Problem

Equations `a/b = k` given. Answer queries `x/y` as product along a path, or -1 if impossible.

**Constraints / edges worth remembering**
- Build bidirectional edges: a→b with k, b→a with 1/k.
- Missing variable → -1.

---

## Intuition

Graph of variables with edge weights as multipliers. BFS/DFS from start accumulating product until end.

---

## Approach

1. Adj map `var → (nei → weight)`.
2. For each query, BFS with running product; return -1 if start/end unseen.

---

## Solution sketch

```java
adj[from].put(to, val); adj[to].put(from, 1/val);
BFS Node(var, product) until end;
```

---

## Complexity

| | |
|---|---|
| **Time** | O(E + V) per query typical |
| **Space** | O(V + E) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Union-Find with weight** | Parent + ratio to parent |
| **Currency conversion variants** | Same graph model |

---

## Pitfalls

- Always add reverse edges.
- Visited set prevents cycles / infinite loops.
