# 55. Jump Game

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/jump-game/)

`Array` · `Dynamic Programming` · `Greedy`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Dynamic Programming, Greedy.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            // If current index is not reachable
            if (i > maxReach) {
                return false;
            }
            // Update maximum reachable index
            maxReach = Math.max(maxReach, i + nums[i]);
            // If we can already reach the last index
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        return true;
    }
}
```

---

**Runtime** 2 ms · **Memory** 48 MB

<sub>Synced by AILeetHub on 2026-04-23.</sub>
