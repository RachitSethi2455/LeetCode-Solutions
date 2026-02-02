# 28. Find the Index of the First Occurrence in a String

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/)

`Two Pointers` · `String` · `String Matching` · `Z Algorithm` · `Knuth–Morris–Pratt Algorithm` · `Boyer–Moore String-Search Algorithm`

## Approach

Accepted easy solution in java.
Relevant topics: Two Pointers, String, String Matching, Z Algorithm, Knuth–Morris–Pratt Algorithm, Boyer–Moore String-Search Algorithm.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
```

---

**Runtime** 0 ms · **Memory** 43.3 MB

<sub>Synced by AILeetHub on 2026-02-02.</sub>
