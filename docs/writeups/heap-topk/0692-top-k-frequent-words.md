# LC 692 — Top K Frequent Words

**Pattern:** Heap / top-K  
**Difficulty:** Medium  
**Code:** [`TopKFrequentWords.java`](../../../src/main/java/TopKFrequentWords.java)

---

## Problem

Given words and integer `k`, return the `k` most frequent words. Tie-break: lower alphabetical order first. Return from most frequent to least.

**Constraints / edges worth remembering**
- Ties are by lexicographical order of the word.
- Output order: highest freq first; among equal freq, alphabetical.

---

## Intuition

Count frequencies, then keep a **min-heap of size k**. Comparator: smaller freq is “worse”; if freqs equal, reverse alpha so the alphabetically larger word is evicted first. Drain heap into a list by `addFirst` to reverse into correct order.

---

## Approach

1. Build `freqMap`.
2. Min-heap comparator: `(a,b) -> a.freq == b.freq ? b.word.compareTo(a.word) : a.freq - b.freq`.
3. Offer each word; if size &gt; k, poll.
4. Poll remaining into `LinkedList` with `addFirst`.

---

## Solution sketch

```java
PriorityQueue<Node> pq = new PriorityQueue<>(
    (a, b) -> a.freq == b.freq ? b.word.compareTo(a.word) : a.freq - b.freq
);
for (String word : freqMap.keySet()) {
    pq.offer(new Node(word, freqMap.get(word)));
    if (pq.size() > k) pq.poll();
}
LinkedList<String> list = new LinkedList<>();
while (!pq.isEmpty()) list.addFirst(pq.poll().word);
```

---

## Complexity

| | |
|---|---|
| **Time** | O(n log k) with heap of size k (n = #distinct words after counting) |
| **Space** | O(n) for the map + O(k) heap |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Top K Frequent Elements (LC 347)** | Same heap idea; no alpha tie-break |
| **Bucket sort** | Buckets by frequency for O(n) after counting |
| **Kth Largest in Stream** | Persistent min-heap of size k |

---

## Pitfalls

- Tie-break comparator is easy to flip — write a tiny example (`i`/`love`).
- Must `addFirst` (or reverse) when draining a min-heap.
- Heap size must stay ≤ k.
