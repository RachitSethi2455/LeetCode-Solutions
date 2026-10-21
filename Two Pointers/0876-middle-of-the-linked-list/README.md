# 876. Middle of the Linked List

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/middle-of-the-linked-list/)

`Linked List` · `Two Pointers`

## Intuition  
If two pointers start together at the head and one moves twice as fast as the other, after each iteration the fast pointer has covered exactly two nodes while the slow pointer has covered one. Consequently, when the fast pointer reaches the end of the list, the slow pointer will be positioned at the halfway point. This observation eliminates the need for a preliminary pass to count nodes, a hash map to store indices, or any recursion. The solution is a classic **two‑pointer** (or “tortoise‑hare”) technique.

## Approach  
1. **Initialize** `slow = head` and `fast = head`. Both start at the first node.  
2. **Iterate** while `fast != null && fast.next != null`.  
   - *Invariant*: At the start of each loop, `fast` is either at the last node (odd length) or one node before the last (even length), and `slow` is exactly half the distance from the head as `fast`.  
   - **Advance** `slow = slow.next`; now `slow` has moved one step.  
   - **Advance** `fast = fast.next.next`; now `fast` has moved two steps.  
3. **Terminate** when the condition fails. At this moment `fast` is either `null` (odd length) or its `next` is `null` (even length), meaning the list cannot be advanced two steps further. By the invariant, `slow` points to the required middle node – the second middle in an even‑length list.  
4. **Return** `slow`.  

*Edge handling*:  
- The constraints guarantee at least one node, so the initial assignment is safe.  
- For a single‑node list, the loop condition fails immediately (`fast.next` is `null`), and `slow` (the head) is returned, which is correct.  
- The `&&` guard prevents a `NullPointerException` when `fast` is at the last node of an odd‑length list. Using `<=` would be wrong because we need to ensure a full two‑step jump is possible before executing it.

## Dry Run  
**Input:** `head = [1,2,3,4]`  

| Iteration | slow.val | fast.val | fast.next.val | Action                              | Note                              |
|-----------|----------|----------|---------------|-------------------------------------|-----------------------------------|
| 0 (init)  | 1        | 1        | 2             | –                                   | Both pointers at head             |
| 1         | 2        | 3        | 4             | `slow = slow.next`; `fast = fast.next.next` | Moved one and two steps respectively |
| 2         | 3        | null     | –             | Loop exits (`fast == null`)        | `slow` now points to node 3, the second middle |

The algorithm stops with `slow` at the node containing `3`, which is the correct answer for an even‑length list because it returns the second of the two middle nodes.

## Complexity  
- **Time:** O(n) – the loop advances `fast` two nodes per iteration, so at most ⌈n/2⌉ iterations are executed.  
- **Space:** O(1) – only two pointer variables are used regardless of list size; the output node is part of the input structure.

## Solution (Java)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
```

---

**Runtime** 0 ms (beats 100.0%) · **Memory** 42.5 MB (beats 89.0%)

<sub>Synced by AILeetHub on 2026-10-21.</sub>
