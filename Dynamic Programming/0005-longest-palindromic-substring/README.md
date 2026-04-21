# 5. Longest Palindromic Substring

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/longest-palindromic-substring/)

`Two Pointers` · `String` · `Dynamic Programming` · `Manacher`

## Approach

Accepted medium solution in java.
Relevant topics: Two Pointers, String, Dynamic Programming, Manacher.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public String longestPalindrome(String s) {
         if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i);     // odd length
            int len2 = expandFromCenter(s, i, i + 1); // even length
            int len = Math.max(len1, len2);
            
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    private int expandFromCenter(String s, int left, int right) {
        // Expand outward while characters match
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return length of palindrome found
        return right - left - 1;
    }
}
```

---

**Runtime** 14 ms · **Memory** 43.6 MB

<sub>Synced by AILeetHub on 2026-04-21.</sub>
