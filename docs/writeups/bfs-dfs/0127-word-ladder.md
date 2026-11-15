# LC 127 — Word Ladder

**Pattern:** BFS on implicit graph  
**Difficulty:** Hard  
**Code:** [`WordLadder.java`](../../../src/main/java/WordLadder.java)

---

## Problem

Transform `beginWord` → `endWord` by changing one letter at a time; each intermediate must be in `wordList`. Return length of shortest transformation sequence (including begin), or `0` if impossible.

**Constraints / edges worth remembering**
- `endWord` not in list → 0.
- Length counts words, so begin alone is length 1; first transformation yields 2, etc.
- All words same length.

---

## Intuition

Each word is a graph node; edges connect words differing by one char. Shortest path = BFS. Level = transformation length.

---

## Approach

1. Put word list in a set; optionally collect allowed characters.
2. BFS from `beginWord`, level starting at 1.
3. For each word, try changing each position to each allowed char; enqueue neighbors in the bank not yet visited.
4. When dequeued word equals `endWord`, return level.

---

## Solution sketch

```java
q.offer(beginWord); int level = 1;
while (!q.isEmpty()) {
    int len = q.size();
    for (...) {
        String curr = q.poll();
        if (curr.equals(endWord)) return level;
        // try all one-letter mutations in bank, not visited → offer
    }
    level++;
}
return 0;
```

---

## Complexity

| | |
|---|---|
| **Time** | O(N · L · Σ) — N words, length L, alphabet Σ (often 26) |
| **Space** | O(N · L) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Word Ladder II** | BFS to build parents, then DFS to collect all shortest paths |
| **Bidirectional BFS** | Search from both ends to cut the branching factor |
| **Genetic Mutation** | Same BFS; bank of genes |

---

## Pitfalls

- Start `level` at **1**, not 0.
- Mark visited carefully (when enqueue vs dequeue) to avoid duplicates / missing shorter paths.
- Building `allowedChars` only from the bank is fine; begin’s unique chars still get tried via mutations toward bank words.
