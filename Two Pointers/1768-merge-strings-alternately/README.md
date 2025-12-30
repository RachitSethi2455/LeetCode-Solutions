# 1768. Merge Strings Alternately

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/merge-strings-alternately/)

`Two Pointers` · `String`

## Approach

Accepted easy solution in java.
Relevant topics: Two Pointers, String.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        StringBuilder result=new StringBuilder("");
        int max = Math.max(word1.length(),word2.length());
        for(int i=0;i< max;i++){
            if(i<word1.length()){
                result.append(word1.charAt(i));
            }
            if(i<word2.length()){
                result.append(word2.charAt(i));
            }
        }return result.toString();
    }
}
```

---

**Runtime** 1 ms · **Memory** 43.1 MB

<sub>Synced by AILeetHub on 2025-12-30.</sub>
