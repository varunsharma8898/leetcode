# Staff / Principal coding interview prep

Target: senior staff and principal **coding** rounds at top companies (FAANG+, Stripe, Uber, etc.). At this level, interviewers expect optimal or near-optimal solutions, clean code, explicit complexity, edge cases, and crisp trade-off discussion—not just passing tests.

**Daily budget:** 1–2 hours  
**Suggested split (adjust to taste):**

| Block | Time | Activity |
|-------|------|----------|
| Warm-up | 10–15 min | Re-derive yesterday’s solution on paper; note pattern in one sentence |
| Main | 45–75 min | 1 new problem (Staff+) or 1 hard + sketch of #2 |
| Close | 10–15 min | Update tracker; write “follow-ups I’d expect” and one failure mode |

---

## What “top companies” actually ask at Staff+

Coding rounds still look like LeetCode, but the bar shifts:

1. **Hard mediums and “fair” hards** — not trick puzzles; often classic with a twist or follow-up.
2. **Design-on-the-whiteboard coding** — LRU/LFU, time-based KV, rate limiter, iterator, stream stats.
3. **Graph + DP** — topo sort, shortest path, union-find, interval DP, state compression (occasionally).
4. **Follow-ups** — scale to streaming, concurrency (discuss only), memory limits, k-way merge variants.
5. **Communication** — narrate approach before coding; test with a small example; state invariants.

System design is a separate loop; this plan is **coding-only**, then a **hard LeetCode** capstone.

---

## Roadmap overview (~20 weeks at 1–2 hr/day)

| Phase | Weeks | Focus | Problems |
|-------|-------|--------|----------|
| **1** | 1–4 | Core patterns (medium, timed) | 40 |
| **2** | 5–10 | Staff-frequency catalog | 45 |
| **3** | 11–16 | Hard catalog + design coding | 50 |
| **4** | 17–20+ | Blind hards, mocks, weak spots | 30+ |

**Open the interactive tracker:** [Staff+ Coding Interview Tracker](https://cursor.com/canvas/store-acc0b5be-2a72-4e4c-806e-a62775fef0e4/b41ed50b-870f-4138-9aa2-aa70305eb67f) — checkmarks persist across sessions (click twice to mark **redo**).

---

## Phase 1 — Pattern foundations (Weeks 1–4)

Goal: automatic recognition; 25–35 min on mediums without hints.

### Two pointers / sliding window
- LC 15 3Sum  
- LC 11 Container With Most Water  
- LC 42 Trapping Rain Water  
- LC 3 Longest Substring Without Repeating Characters  
- LC 76 Minimum Window Substring  
- LC 567 Permutation in String  
- LC 438 Find All Anagrams in a String  

### Binary search
- LC 33 Search in Rotated Sorted Array  
- LC 153 Find Minimum in Rotated Sorted Array  
- LC 875 Koko Eating Bananas  
- LC 1011 Capacity To Ship Packages Within D Days  
- LC 4 Median of Two Sorted Arrays *(Staff+ classic; allocate 2 sessions)*  

### Stack / monotonic
- LC 739 Daily Temperatures  
- LC 84 Largest Rectangle in Histogram  
- LC 85 Maximal Rectangle  
- LC 316 Remove Duplicate Letters  
- LC 224 Basic Calculator  

### Heap / merge
- LC 23 Merge k Sorted Lists  
- LC 347 Top K Frequent Elements  
- LC 295 Find Median from Data Stream  
- LC 973 K Closest Points to Origin  
- LC 502 IPO  

### BFS / DFS (grid & graph)
- LC 200 Number of Islands  
- LC 127 Word Ladder  
- LC 994 Rotting Oranges  
- LC 329 Longest Increasing Path in a Matrix  
- LC 130 Surrounded Regions  

### Trees
- LC 102 Binary Tree Level Order Traversal  
- LC 236 Lowest Common Ancestor of a Binary Tree  
- LC 543 Diameter of Binary Tree  
- LC 124 Binary Tree Maximum Path Sum  
- LC 105 Construct Binary Tree from Preorder and Inorder  

### Basics you must not miss
- LC 56 Merge Intervals  
- LC 31 Next Permutation  
- LC 238 Product of Array Except Self  
- LC 560 Subarray Sum Equals K  

---

## Phase 2 — Staff-frequency catalog (Weeks 5–10)

Goal: problems that recur in **L6+** loops; always discuss follow-ups.

### Union-find / graph structure
- LC 547 Number of Provinces  
- LC 684 Redundant Connection  
- LC 721 Accounts Merge  
- LC 207 Course Schedule  
- LC 210 Course Schedule II  
- LC 269 Alien Dictionary *(premium / classic)*  
- LC 787 Cheapest Flights Within K Stops  

### Trie / string
- LC 208 Implement Trie  
- LC 211 Design Add and Search Words Data Structure  
- LC 212 Word Search II  
- LC 72 Edit Distance  
- LC 115 Distinct Subsequences *(hard DP)*  

### DP (interview staples)
- LC 5 Longest Palindromic Substring  
- LC 139 Word Break  
- LC 140 Word Break II  
- LC 152 Maximum Product Subarray  
- LC 300 Longest Increasing Subsequence  
- LC 322 Coin Change  
- LC 416 Partition Equal Subset Sum  
- LC 494 Target Sum  
- LC 312 Burst Balloons *(hard; Staff+ favorite)*  

### Design / API coding
- LC 146 LRU Cache  
- LC 460 LFU Cache  
- LC 380 Insert Delete GetRandom O(1)  
- LC 381 Insert Delete GetRandom O(1) - Duplicates allowed  
- LC 642 Design Search Autocomplete System *(premium)*  
- LC 981 Time Based Key-Value Store  
- LC 355 Design Twitter  
- LC 362 Design Hit Counter  

### Intervals / greedy
- LC 253 Meeting Rooms II  
- LC 435 Non-overlapping Intervals  
- LC 57 Insert Interval  
- LC 630 Course Schedule III  
- LC 1353 Maximum Number of Events That Can Be Attended  

### Linked list / misc high signal
- LC 138 Copy List with Random Pointer  
- LC 25 Reverse Nodes in k-Group  
- LC 143 Reorder List  
- LC 149 Max Points on a Line  
- LC 128 Longest Consecutive Sequence  

---

## Phase 3 — Hard catalog + follow-up bait (Weeks 11–16)

Goal: no panic on “Hard” tag; 45–60 min with partial credit mindset.

- LC 10 Regular Expression Matching  
- LC 44 Wildcard Matching  
- LC 32 Longest Valid Parentheses  
- LC 84 + LC 85 (revisit under time pressure)  
- LC 239 Sliding Window Maximum  
- LC 315 Count of Smaller Numbers After Self  
- LC 354 Russian Doll Envelopes  
- LC 403 Frog Jump  
- LC 410 Split Array Largest Sum  
- LC 432 All O`one Data Structure  
- LC 465 Optimal Account Balancing  
- LC 51 N-Queens  
- LC 52 N-Queens II  
- LC 297 Serialize and Deserialize Binary Tree  
- LC 428 Serialize and Deserialize N-ary Tree *(premium)*  
- LC 127 Word Ladder (II follow-up LC 126)  
- LC 332 Reconstruct Itinerary  
- LC 871 Minimum Number of Refueling Stops  
- LC 895 Maximum Frequency Stack  
- LC 968 Binary Tree Cameras  
- LC 773 Sliding Puzzle  
- LC 827 Making A Large Island  
- LC 847 Shortest Path Visiting All Nodes  
- LC 862 Shortest Subarray with Sum at Least K  
- LC 887 Super Egg Drop  
- LC 1235 Maximum Profit in Job Scheduling  
- LC 1326 Minimum Number of Taps to Open to Water a Garden  
- LC 1499 Max Value of Equation *(heap + deque pattern)*  

**Staff+ drill after each:** write 2 follow-ups (e.g. “what if input is a stream?” “what if we need thread-safe reads?”).

---

## Phase 4 — Hard LeetCode capstone (Week 17+)

Goal: **surprise insurance** — blind hards, company-tagged where available.

### Weekly rhythm (repeat until interviews)
- **Mon–Thu:** 1 blind hard (45 min timer, then 15 min read editorial if stuck)  
- **Fri:** 2 problems mock (medium + hard, 90 min total)  
- **Sat:** Review weak tags from tracker (< 70% completion)  
- **Sun:** Light — 1 medium speed run or rest  

### Hard pool (rotate; aim 40–60 total before onsite)
- LC 37 Sudoku Solver  
- LC 41 First Missing Positive  
- LC 76 (again, strict time)  
- LC 87 Scramble String  
- LC 124 (again)  
- LC 1411 Number of Ways to Paint N × 3 Grid  
- LC 1544 Make The String Great *(stack)*  
- LC 164 Maximum Gap  
- LC 1687 Wildcard Matching / hard strings batch  
- LC 1776 Car Fleet II  
- LC 1857 Largest Color Value in a String  
- LC 1944 Number of Visible People in a Queue  
- LC 2034 Stock Price Fluctuation  
- LC 214 Shortest Palindrome  
- LC 218 The Skyline Problem  
- LC 221 Maximal Square  
- LC 224 (again)  
- LC 2337 Move Pieces to Obtain a String  
- LC 2407 Longest Increasing Subsequence II *(segment tree)*  
- LC 2426 Number of Pairs Satisfying Inequality  
- LC 2577 Minimum Time to Visit a Cell In a Grid  

Use LeetCode “Hard” + filter by tags you marked weak in the canvas.

---

## How to use your existing repo

You already have Java solutions under `src/main/java/`. For each problem:

1. Solve **on LeetCode** (or paper) first — timed.  
2. Re-implement in this repo only if you want a permanent reference implementation.  
3. Link filename in canvas notes (optional).

---

## Success criteria before onsite

- [ ] **90%+** of Phase 1–2 marked complete in tracker  
- [ ] **70%+** of Phase 3 complete  
- [ ] **30+** blind hards in Phase 4 with notes  
- [ ] 3–5 **full mock** coding interviews (peer or Pramp/interviewing.io)  
- [ ] Can explain **time/space** and **why not** alternative approach in &lt; 2 min per problem  

Good luck — consistency beats cramming.
