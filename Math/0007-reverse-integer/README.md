# 7. Reverse Integer

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/reverse-integer/)

`Math`

## Approach

Accepted medium solution in java.
Relevant topics: Math.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int reverse(int x) {
        int rev = 0;
        while(x != 0){
            int pop = x % 10;
            x = x / 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && pop < -8)) {
                return 0;
            }
            rev = rev *10 + pop;
        }
        return rev;
    }
}
```

---

**Runtime** 1 ms · **Memory** 42.9 MB

<sub>Synced by AILeetHub on 2026-02-24.</sub>
