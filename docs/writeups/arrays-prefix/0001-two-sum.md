# LC 1 — Two Sum

**Pattern:** Hash map  
**Difficulty:** Easy  
**Code:** [`TwoSum.java`](../../../src/main/java/TwoSum.java)

---

## Problem

Return indices of two distinct numbers in `nums` that add up to `target`. Exactly one solution exists.

**Constraints / edges worth remembering**
- Cannot use the same element twice.
- Return indices, not values.

---

## Intuition

One pass: for each number, look up `target - nums[i]` in a map of value → index seen so far. If present, done; else store the current value.

---

## Approach

1. Map from value to index.
2. For each index `i`, if `target - nums[i]` is in the map, return those indices.
3. Otherwise `put(nums[i], i)`.

---

## Solution sketch

```java
Map<Integer, Integer> map = new HashMap<>();
for (int i = 0; i < nums.length; i++) {
    int need = target - nums[i];
    if (map.containsKey(need)) return new int[] { map.get(need), i };
    map.put(nums[i], i);
}
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
| **2Sum sorted** | Two pointers from ends |
| **3Sum / 4Sum** | Fix one/two values, reduce to 2Sum |
| **Two Sum II (sorted, 1-indexed)** | Two pointers; no hash map needed |

---

## Pitfalls

- Store index **after** the lookup so you never pair an element with itself.
- Your early `if (index == 0)` special-case is unnecessary — the general loop covers it.
