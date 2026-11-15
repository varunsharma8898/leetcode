# LC 1115 — Print FooBar Alternately

**Pattern:** Concurrency — wait/notify  
**Difficulty:** Medium  
**Code:** [`PrintFooBarAlternately.java`](../../../src/main/java/PrintFooBarAlternately.java)

---

## Problem

Two threads call `foo` and `bar` `n` times. Output must be `"foobar"` repeated `n` times (strict alternation).

**Constraints / edges worth remembering**
- Ordering, not just mutual exclusion.
- Spurious wakeups → always `wait` inside `while`, not `if`.

---

## Intuition

A shared turn flag (`tracker`) decides whose turn it is. Each thread waits until its turn, prints, flips the flag, notifies the other.

---

## Approach

1. Shared `lock` + `volatile tracker` (0 = foo’s turn, 1 = bar’s).
2. `foo`: wait while `tracker != 0`; print; set `tracker = 1`; `notifyAll`.
3. `bar`: wait while `tracker != 1`; print; set `tracker = 0`; `notifyAll`.

---

## Solution sketch

```java
synchronized (lock) {
    while (tracker != expected) lock.wait();
    print.run();
    tracker = next;
    lock.notifyAll();
}
```

---

## Complexity

| | |
|---|---|
| **Time** | O(n) prints |
| **Space** | O(1) shared state |

---

## Variations

| Variant | Change in approach |
|---|---|
| **FizzBuzz multithreaded** | More states / semaphores per role |
| **Semaphore** | `fooSem`/`barSem` instead of wait/notify |
| **LockSupport / BlockingQueue** | Alternate handoff styles |

---

## Pitfalls

- `while` + `wait`, never bare `if` + `wait`.
- Prefer `notifyAll` when multiple waiters possible.
- `volatile` on the flag helps visibility alongside synchronized blocks (synchronized already provides visibility on entry/exit).
