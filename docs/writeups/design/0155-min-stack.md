# LC 155 — Min Stack

**Pattern:** Design — stack of pairs  
**Difficulty:** Medium  
**Code:** [`MinStack.java`](../../../src/main/java/MinStack.java)

---

## Problem

Stack supporting push/pop/top/getMin in O(1).

**Constraints / edges worth remembering**
- Store (value, minSoFar) on each push.
- Min updates on push; pop restores previous min automatically.

---

## Intuition

Each entry remembers the minimum of the stack at the time it was pushed.

---

## Approach

Push `{x, min(x, currentMin)}`; pop/top/getMin read last pair’s fields.

---

## Solution sketch

```java
myList.addLast(new int[]{ x, Math.min(getMin(), x) }); // empty: {x,x}
getMin → getLast()[1];
```

---

## Complexity

| | |
|---|---|
| **Time** | O(1) ops |
| **Space** | O(n) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Max Stack** | Similar with max |
| **Two stacks** | Values + mins parallel |

---

## Pitfalls

- Empty check on getMin/push first element.
- Integer edge values (MIN/MAX int) appear in tests.
