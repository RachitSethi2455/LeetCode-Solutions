# 1431. Kids With the Greatest Number of Candies

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/)

`Array`

## Approach

Accepted easy solution in java.
Relevant topics: Array.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max=0;
        for(int candy : candies){
            if(candy > max){
                max = candy;
            }
        }
        for(int candy : candies){
            result.add(candy + extraCandies >= max);
        }
        return result;
    }
}
```

---

**Runtime** 1 ms · **Memory** 44.1 MB

<sub>Synced by AILeetHub on 2026-01-06.</sub>
