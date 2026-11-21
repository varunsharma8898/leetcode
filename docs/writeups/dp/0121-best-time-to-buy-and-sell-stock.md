# LC 121 — Best Time to Buy and Sell Stock

**Pattern:** DP / running min  
**Difficulty:** Easy  
**Code:** [`BestTimeToBuySellStock.java`](../../../src/main/java/BestTimeToBuySellStock.java)

---

## Problem

One buy and one sell (sell after buy). Maximize profit; return 0 if no profit.

**Constraints / edges worth remembering**
- Strictly decreasing prices → 0.
- Need at least two days for a trade.

---

## Intuition

Track the lowest price so far; at each day profit = `price - low`. Equivalent: Kadane on day-to-day diffs (your `maxCurr` version).

---

## Approach

**Running min:** update `lowPrice`; `profit = max(profit, price - lowPrice)`.  
**Kadane on diffs:** `maxCurr = max(0, maxCurr + diff)`; track max.

---

## Solution sketch

```java
int low = prices[0], profit = 0;
for (int price : prices) {
    if (price < low) low = price;
    else profit = Math.max(profit, price - low);
}
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
| **Stock II** | Sum all positive adjacent diffs |
| **Stock III / IV** | DP with k transactions |
| **With cooldown / fee** | State machine DP |

---

## Pitfalls

- Sell must be after buy — running min handles this.
- Don’t reset low incorrectly after computing profit.
