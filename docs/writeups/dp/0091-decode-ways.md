# LC 91 — Decode Ways

**Pattern:** DP — string decode  
**Difficulty:** Medium  
**Code:** [`DecodeWays.java`](../../../src/main/java/DecodeWays.java)

---

## Problem

Letters map `A=1 … Z=26`. Given digit string `s`, return number of ways to decode it.

**Constraints / edges worth remembering**
- Leading zero → 0 ways.
- `"0"` mid-string only valid as part of `10`/`20`.
- `"06"` invalid.

---

## Intuition

Like climbing stairs with constraints: `dp[i]` ways for prefix length i. Add `dp[i-1]` if single digit valid; add `dp[i-2]` if two-digit in `[10,26]`.

---

## Approach

1. `dp[0]=1`, `dp[1]=1` if `s[0] != '0'`.
2. For i = 2..n: add prior ways for valid 1- and 2-digit endings.

---

## Solution sketch

```java
if (s.charAt(i-1) != '0') dp[i] += dp[i-1];
int two = Integer.parseInt(s.substring(i-2, i));
if (two >= 10 && two <= 26) dp[i] += dp[i-2];
```

---

## Complexity

| | |
|---|---|
| **Time** | O(n) |
| **Space** | O(n) — or O(1) with two rolling vars |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Decode Ways II** | `*` wildcards — more cases |
| **Climbing Stairs** | Same recurrence without digit constraints |

---

## Pitfalls

- Reject strings starting with `'0'`.
- Two-digit must be `>= 10` (so `"01"` doesn’t count).
