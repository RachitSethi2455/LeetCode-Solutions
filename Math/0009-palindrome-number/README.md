# 9. Palindrome Number

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/palindrome-number/)

`Math`

## Approach

Accepted easy solution in java.
Relevant topics: Math.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        String rev = new StringBuilder(str).reverse().toString();
        return str.equals(rev);
        
    }
}
```

---

**Runtime** 8 ms · **Memory** 46.1 MB

<sub>Synced by AILeetHub on 2026-01-11.</sub>
