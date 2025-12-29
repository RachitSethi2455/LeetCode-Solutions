# 2485. Find the Pivot Integer

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/find-the-pivot-integer/)

`Math` · `Prefix Sum`

## Approach

Accepted easy solution in java.
Relevant topics: Math, Prefix Sum.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int pivotInteger(int n) {
        int total = n*(n+1)/2;
        for(int x=1;x<= n;x++){
            int left = x*(x+1)/2;
            int right = total - (x*(x-1)/2);
            if(left == right){
                return x;
            }
        }
        return -1;
    }
}
```

---

**Runtime** 1 ms · **Memory** 42 MB

<sub>Synced by AILeetHub on 2025-12-29.</sub>
