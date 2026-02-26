# 70. Climbing Stairs

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/climbing-stairs/)

`Math` · `Dynamic Programming` · `Memoization`

## Approach

Accepted easy solution in java.
Relevant topics: Math, Dynamic Programming, Memoization.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int first = 1;
        int second = 2;
        int result = 0;

        for (int i = 3; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }
}
```

---

**Runtime** 0 ms · **Memory** 42.1 MB

<sub>Synced by AILeetHub on 2026-02-26.</sub>
