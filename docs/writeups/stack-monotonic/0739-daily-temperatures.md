# LC 739 — Daily Temperatures

**Pattern:** Monotonic stack  
**Difficulty:** Medium  
**Code:** [`DailyTemperatures.java`](../../../src/main/java/DailyTemperatures.java)

---

## Problem

Given daily temperatures `T`, return an array where `answer[i]` is the number of days you wait after day `i` until a warmer temperature. If none, `0`.

**Constraints / edges worth remembering**
- Strictly warmer (`>`), not `>=`.
- Trailing days with no warmer day stay 0.

---

## Intuition

Keep a stack of indices with decreasing temperatures (candidates waiting for a warmer day). When today’s temp is warmer, pop and fill answers as `i - index`.

---

## Approach

1. Stack stores `(val, index)` (or just indices).
2. For each day `i`, while stack top is colder than `T[i]`, pop and set `ret[index] = i - index`.
3. Push day `i`. Unresolved days remain 0.

---

## Solution sketch

```java
Stack<Node> stack = new Stack<>(); // val + index
int[] ret = new int[T.length];
for (int i = 0; i < T.length; i++) {
    while (!stack.isEmpty() && T[i] > stack.peek().val) {
        Node node = stack.pop();
        ret[node.index] = i - node.index;
    }
    stack.push(new Node(T[i], i));
}
```

---

## Complexity

| | |
|---|---|
| **Time** | O(n) — each index pushed/popped once |
| **Space** | O(n) — stack |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Next Greater Element I/II** | Same stack; circular array → loop `2n` with `% n` |
| **Online Stock Span** | Monotonic stack of (price, span) |
| **Largest Rectangle in Histogram** | Next smaller left/right via monotonic stack |

---

## Pitfalls

- Store **indices**, not only values (need distance).
- Unused `count` variable in early drafts — answer is `i - index`, not a running count.
- Empty input → empty array.
