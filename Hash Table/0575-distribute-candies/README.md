# 575. Distribute Candies

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/distribute-candies/)

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
    public int distributeCandies(int[] candyType) {
        Set<Integer> s= new HashSet<Integer>();
        for(int i =0; i< candyType.length; i++){
            s.add(candyType[i]);
        }
        int maxAllowed = candyType.length / 2;
        return Math.min(s.size(), maxAllowed);
    }
}
```

---

**Runtime** 31 ms · **Memory** 48.7 MB

<sub>Synced by AILeetHub on 2026-03-31.</sub>
