# 605. Can Place Flowers

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/can-place-flowers/)

`Array` · `Greedy`

## Approach

Accepted easy solution in java.
Relevant topics: Array, Greedy.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count =0;
        for(int i=0; i<= flowerbed.length -1; i++){
            if(flowerbed[i] == 0){
                Boolean left = (i == 0) || (flowerbed[i-1] == 0);
                Boolean right = (i == flowerbed.length -1) || (flowerbed[i+1] == 0);
                if(left && right){
                    flowerbed[i] = 1;
                    count++;
                    if(count >= n){
                        return true;
                    }
                }
            }
        }
        return count >= n;
    }
}
```

---

**Runtime** 2 ms · **Memory** 47.9 MB

<sub>Synced by AILeetHub on 2026-01-07.</sub>
