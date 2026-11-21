# LC 133 — Clone Graph

**Pattern:** Graph clone — BFS/DFS + map  
**Difficulty:** Medium  
**Code:** [`CloneGraph.java`](../../../src/main/java/CloneGraph.java)

---

## Problem

Deep-copy a connected undirected graph. Each node has a value and a list of neighbors.

**Constraints / edges worth remembering**
- `null` input → `null`.
- Cycles / shared neighbors — must reuse already-cloned nodes.

---

## Intuition

Map original node → clone. BFS or DFS: create clone on first visit, then wire neighbor links using the map.

---

## Approach (BFS)

1. Create clone of root; put in map; enqueue root.
2. While queue: for each neighbor, if unseen create clone + enqueue; add clone-neighbor to current clone’s list.

DFS variant: recurse; if already in map return it; else create, map, then clone neighbors.

---

## Solution sketch

```java
Map<Node, Node> map = new HashMap<>();
map.put(root, new Node(root.val));
q.offer(root);
while (!q.isEmpty()) {
  Node curr = q.poll();
  for (Node nei : curr.neighbors) {
    if (!map.containsKey(nei)) { map.put(nei, new Node(nei.val)); q.offer(nei); }
    map.get(curr).neighbors.add(map.get(nei));
  }
}
```

---

## Complexity

| | |
|---|---|
| **Time** | O(V + E) |
| **Space** | O(V) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Copy List with Random Pointer** | Same map idea, or interleaving trick |
| **Clone Binary Tree with Random** | Map + DFS |

---

## Pitfalls

- Create the clone **before** exploring neighbors, and put it in the map immediately — otherwise cycles infinite-loop.
