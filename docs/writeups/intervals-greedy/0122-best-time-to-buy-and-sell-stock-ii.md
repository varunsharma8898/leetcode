# LC 122 — Best Time to Buy and Sell Stock II

**Pattern:** Greedy  
**Difficulty:** Medium  
**Code:** [`BestTimeToBuySellStock2.java`](../../../src/main/java/BestTimeToBuySellStock2.java)

---

## Problem

Unlimited transactions (no overlapping). Maximize profit.

**Constraints / edges worth remembering**
- Sum every positive adjacent climb.
- Equivalent to buying at every valley and selling at peak.

---

## Intuition

Any up-move can be captured; sum `prices[i+1]-prices[i]` when positive.

---

## Approach

Single pass accumulating positive diffs.

---

## Solution sketch

```java
if (prices[i+1] > prices[i]) total += prices[i+1] - prices[i];
```

---

## Complexity

| | |
|---|---|
| **Time** | O(n) |
| **Space** | O(1) |

---

## Variations

| Variant | Change in approach |
|---|---|
| **Stock I** | One transaction — running min |
| **Stock III/IV** | DP with k transactions |
| **With cooldown/fee** | State machine |

---

## Pitfalls

- Don’t hold overlapping positions — the diff sum already models sequential trades.
- Null / short array → 0.
