# 69. Sqrt(x)

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/sqrtx/)

`Math` · `Binary Search` · `Newton's Method`

## Approach

Accepted easy solution in java.
Relevant topics: Math, Binary Search, Newton's Method.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x; // sqrt(0) = 0, sqrt(1) = 1
        }

        int left = 1;
        int right = x / 2; // sqrt(x) can't be more than x/2 for x > 1
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2; // avoid overflow
            long sq = (long) mid * mid; // use long to prevent overflow

            if (sq == x) {
                return mid; // perfect square
            } else if (sq < x) {
                ans = mid; // store candidate
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;



    }
}
```

---

**Runtime** 1 ms · **Memory** 42.2 MB

<sub>Synced by AILeetHub on 2026-04-01.</sub>
