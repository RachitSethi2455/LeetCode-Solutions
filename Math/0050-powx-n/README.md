# 50. Pow(x, n)

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/powx-n/)

`Math` · `Recursion`

## Approach

Accepted medium solution in java.
Relevant topics: Math, Recursion.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public double myPow(double x, int n) {
        long N = n;  // convert to long to handle overflow
        
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        double result = 1.0;
        while (N > 0) {
            if (N % 2 == 1) {   // if odd
                result *= x;
            }
            x *= x;  // square the base
            N /= 2;  // halve the exponent
        }
        return result;
    }
}
```

---

**Runtime** 0 ms · **Memory** 48.1 MB

<sub>Synced by AILeetHub on 2026-04-28.</sub>
