# 14. Longest Common Prefix

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/longest-common-prefix/)

`Array` · `String` · `Trie`

## Approach

Accepted easy solution in java.
Relevant topics: Array, String, Trie.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if (strs == null || strs.length == 0) return "";

        // Start with the first string as the prefix
        String prefix = strs[0];

        // Compare prefix with each string
        for (int i = 1; i < strs.length; i++) {
            // Reduce prefix until it matches the start of strs[i]
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
```

---

**Runtime** 0 ms · **Memory** 43.5 MB

<sub>Synced by AILeetHub on 2026-04-03.</sub>
