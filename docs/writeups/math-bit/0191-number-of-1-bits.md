# LC 191 — Number of 1 Bits

**Pattern:** Bit manipulation  
**Difficulty:** Easy  
**Code:** [`NumberOfOneBits.java`](../../../src/main/java/NumberOfOneBits.java)

---

## Problem

Return the Hamming weight — number of `1` bits in the binary representation of a signed integer (treat as 32-bit two’s complement).

**Constraints / edges worth remembering**
- Negative numbers still have bit patterns (e.g. `-3` has many 1s).
- Don’t use arithmetic `>>` thinking for unsigned shift needs — prefer `n &= n - 1` or unsigned ops.

---

## Intuition

Brian Kernighan: `n & (n - 1)` clears the lowest set bit. Loop until `n == 0`, counting clears. Or use language bitCount.

---

## Approach

1. `sum = 0`; while `n != 0`: `sum++`; `n &= (n - 1)`.
2. Alternate: `Integer.bitCount(n)`.

---

## Solution sketch

```java
int sum = 0;
while (n != 0) {
    sum++;
    n &= (n - 1);
}
return sum;
```

---

## Complexity

| | |
|---|---|
| **Time** | O(#set bits) ≤ O(32) |
| **Space** | O(1) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Hamming Distance** | `bitCount(x ^ y)` |
| **Counting Bits (LC 338)** | DP: `dp[i] = dp[i >> 1] + (i & 1)` |
| **Power of Two** | `n > 0 && (n & (n - 1)) == 0` |

---

## Pitfalls

- Loop condition `n != 0` works for negatives in Java (32-bit wrap of the pattern).
- Interviewers often want the `n & (n - 1)` trick, not only library bitCount.
