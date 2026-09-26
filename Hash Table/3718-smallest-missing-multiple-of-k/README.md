# 3718. Smallest Missing Multiple of K

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/smallest-missing-multiple-of-k/)

`Array` · `Hash Table`

## Approach

Accepted easy solution in java.
Relevant topics: Array, Hash Table.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet <Integer> s = new HashSet<>();
        for(int num : nums){
            s.add(num);
        }
        int miss = k;
        while(s.contains(miss)){
            miss += k;
        }
        return miss;
    }
}
```

---

**Runtime** 2 ms · **Memory** 45.7 MB

<sub>Synced by AILeetHub on 2026-09-26.</sub>
