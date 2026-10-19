# 141. Linked List Cycle

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/linked-list-cycle/)

`Hash Table` · `Linked List` · `Two Pointers` · `Floyd's Cycle Finding Algorithm`

## Intuition  
If we could remember every node we have already visited, we would instantly know when a node appears a second time – that moment signals a cycle. The naïve way would be to scan the list repeatedly, comparing each node with all previous ones, which costs O(n²). By storing each visited node in a hash set we turn the “have we seen this node?” question into O(1) work, eliminating the need for a second pass, extra pointers, or recursion.

## Approach  
1. **Create a hash set `s`.** It will hold references to every node encountered so far.  
2. **Iterate while `head != null`.**  
   - *Invariant*: All nodes before the current `head` are already in `s`.  
   - **Check membership:** `if (s.contains(head))` → a duplicate reference means the list loops back, so return `true`.  
   - **Otherwise:** add the current node with `s.add(head)` and advance `head = head.next`.  
3. **Exit loop:** When `head` becomes `null` we have reached the tail without repeats, therefore return `false`.  

**Edge‑case handling**  
- An empty list (`head == null`) bypasses the loop entirely and yields `false`.  
- A single‑node list without a self‑loop also exits immediately because `head.next` is `null`.  
- The code treats a self‑loop (`head.next == head`) correctly: the first iteration adds the node, the second iteration finds it in `s` and returns `true`.  
- The `while` condition uses `!= null` rather than `!= head` because we rely on the set to detect revisits, not pointer equality tricks.

## Dry Run  
Input list (visual): `3 → 2 → 0 → -4 ↘︎` (tail points back to node with value `2`).  

| Iteration | `head.val` | `s` (values stored) | Action                               | Note                     |
|-----------|------------|----------------------|--------------------------------------|--------------------------|
| 1         | 3          | {}                   | add 3, move to next                  | `s = {3}`                |
| 2         | 2          | {3}                  | add 2, move to next                  | `s = {3,2}`              |
| 3         | 0          | {3,2}                | add 0, move to next                  | `s = {3,2,0}`            |
| 4         | -4         | {3,2,0}              | add -4, move to next (points to 2)   | `s = {3,2,0,-4}`         |
| 5         | 2          | {3,2,0,-4}           | `s.contains(2)` is true → return `true` | Cycle detected          |

The algorithm stops at iteration 5 because the node with value 2 reappears, confirming a cycle.

## Complexity  
- **Time:** O(n) – each node is visited at most once; the hash‑set lookup and insertion are O(1) on average.  
- **Space:** O(n) – up to `n` node references may be stored in the set (excluding the input list itself).

## Solution (Java)

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> s = new HashSet<>();

        while(head != null){
            if(s.contains(head)){
                return true;
            }
            else{
                s.add(head);
                head = head.next;
            }
        }
        return false;
    }
}
```

---

**Runtime** 7 ms (beats 8.1%) · **Memory** 46.5 MB (beats 90.3%)

<sub>Synced by AILeetHub on 2026-10-19.</sub>
