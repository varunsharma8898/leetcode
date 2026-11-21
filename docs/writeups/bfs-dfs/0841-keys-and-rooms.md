# LC 841 — Keys and Rooms

**Pattern:** Graph DFS/BFS reachability  
**Difficulty:** Medium  
**Code:** [`KeysAndRooms.java`](../../../src/main/java/KeysAndRooms.java)

---

## Problem

`rooms[i]` lists keys in room i. Start at room 0. Return whether every room is visitable.

**Constraints / edges worth remembering**
- Room 0 always open.
- Keys unlock other rooms — classic reachability.

---

## Intuition

DFS/BFS from 0 following keys; check all visited.

---

## Approach

Stack/queue from 0; mark visited when pushing; finally ensure no false in visited[].

---

## Solution sketch

```java
visited[0]=true; stack.push(0);
while (!empty) for keys in room: if !visited push;
```

---

## Complexity

| | |
|---|---|
| **Time** | O(N + E) keys total |
| **Space** | O(N) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Number of Provinces** | Components count |
| **Clone Graph** | Traverse all nodes via edges |

---

## Pitfalls

- Mark visited when enqueue/push to avoid duplicates.
- Final scan of visited array.
