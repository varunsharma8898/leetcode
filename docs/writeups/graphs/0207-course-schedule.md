# LC 207 — Course Schedule

**Pattern:** Topological sort (Kahn’s BFS)  
**Difficulty:** Medium  
**Code:** [`CourseSchedule.java`](../../../src/main/java/CourseSchedule.java)

---

## Problem

There are `numCourses` labeled `0 .. numCourses-1`. Prerequisites are pairs `[a, b]` meaning “b before a”. Return whether you can finish all courses (i.e. the graph has no cycle).

**Constraints / edges worth remembering**
- Edge direction: `b → a` (must take `b` first).
- Isolated courses (in-degree 0, no edges) are always finishable.
- Mutual prerequisites → cycle → `false`.

---

## Intuition

Model as a directed graph. You can finish iff there is a valid topological order of all nodes. Kahn’s algorithm: repeatedly take nodes with in-degree 0; if you process all `n` nodes, no cycle.

---

## Approach

1. Build adjacency list: for each `[a, b]`, add edge `b → a`; increment `inDegree[a]`.
2. Enqueue every course with `inDegree == 0`.
3. BFS: pop a course, `count++`; decrement neighbors’ in-degrees; enqueue when a neighbor hits 0.
4. Return `count == numCourses`.

---

## Solution sketch

```java
// edge: prereq → course
adjList.get(b).add(a);
inDegree[a]++;

Queue<Integer> q = /* all i with inDegree[i] == 0 */;
int count = 0;
while (!q.isEmpty()) {
    int u = q.poll();
    count++;
    for (int v : adjList.getOrDefault(u, empty)) {
        if (--inDegree[v] == 0) q.offer(v);
    }
}
return count == numCourses;
```

---

## Complexity

| | |
|---|---|
| **Time** | O(V + E) — each node/edge processed once |
| **Space** | O(V + E) — adj list + queue + in-degree |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Course Schedule II** ([`CourseSchedule2.java`](../../../src/main/java/CourseSchedule2.java)) | Same BFS; append nodes to `result[]` as you dequeue; return order or `[]` if cycle |
| **DFS cycle detect** | 3-color / recursion stack; cycle ⇒ false |
| **Course Schedule IV** | Reachability queries after transitive closure / topo DP |
| **Alien Dictionary** | Same topo idea on character graph; detect cycle + incomplete alphabet carefully |

---

## Pitfalls

- Mixing up edge direction (`[a,b]` means b before a).
- Forgetting courses with no prerequisites still need to be seeded into the queue.
- Using `adjList.get(key)` without default → NPE on nodes with no outgoing edges (your code uses `getOrDefault`).
- `count == n` is the cycle check — don’t just check that the queue eventually empties.
