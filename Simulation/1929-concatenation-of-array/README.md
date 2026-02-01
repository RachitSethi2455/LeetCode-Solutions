# 1929. Concatenation of Array

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/concatenation-of-array/)

`Array` · `Simulation`

## Approach

Accepted easy solution in java.
Relevant topics: Array, Simulation.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int len  = 2 * n;
        int[] ans = new int[len];
        for(int i=0;i<len;i++){
            if(i<n){
                ans[i] = nums[i];
            }
            if(i>=n){
                ans[i] = nums[i-n];
            }
        }
        return ans;
    }
}
```

---

**Runtime** 2 ms · **Memory** 47.3 MB

<sub>Synced by AILeetHub on 2026-02-01.</sub>
