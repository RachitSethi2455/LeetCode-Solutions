# 287. Find the Duplicate Number

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/find-the-duplicate-number/)

`Array` · `Two Pointers` · `Binary Search` · `Bit Manipulation` · `Pigeonhole Principle` · `Floyd's Cycle Finding Algorithm`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Two Pointers, Binary Search, Bit Manipulation, Pigeonhole Principle, Floyd's Cycle Finding Algorithm.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        // Step 2: Detect cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        // Step 3: Find entry point of cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow; // Duplicate number
    }
}
```

---

**Runtime** 4 ms · **Memory** 83 MB

<sub>Synced by AILeetHub on 2026-02-12.</sub>
