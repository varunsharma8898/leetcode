# LC 20 — Valid Parentheses

**Pattern:** Stack  
**Difficulty:** Easy  
**Code:** [`ValidParentheses.java`](../../../src/main/java/ValidParentheses.java)

---

## Problem

Given a string of `()[]{}` only, return whether brackets are correctly matched and nested.

**Constraints / edges worth remembering**
- Empty string → true.
- Closing bracket with empty stack → false.
- Leftover opens at end → false.

---

## Intuition

Push the **expected closer** when you see an opener. On a closer, it must equal the stack top.

---

## Approach

1. For `(`, `{`, `[` push `)`, `}`, `]` respectively.
2. Else: if stack empty or `pop() != c`, return false.
3. Return `stack.isEmpty()`.

---

## Solution sketch

```java
if (c == '(') stack.push(')');
else if (c == '{') stack.push('}');
else if (c == '[') stack.push(']');
else if (stack.isEmpty() || stack.pop() != c) return false;
return stack.isEmpty();
```

---

## Complexity

| | |
|---|---|
| **Time** | O(n) |
| **Space** | O(n) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Generate Parentheses** | Backtracking with open/close counts |
| **Longest Valid Parentheses** | Stack of indices or DP |
| **Min Add to Make Valid** | Count imbalance without full matching stack variants |

---

## Pitfalls

- Push expected closers (elegant) vs pushing openers and mapping — both fine.
- Must check empty before pop on a closer.
