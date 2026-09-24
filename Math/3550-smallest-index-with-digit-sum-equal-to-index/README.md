# 3550. Smallest Index With Digit Sum Equal to Index

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/smallest-index-with-digit-sum-equal-to-index/)

`Array` · `Math`

## Approach

Accepted easy solution in java.
Relevant topics: Array, Math.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int smallestIndex(int[] nums) {
        int sum =0;
        for(int i =0; i< nums.length ; i++){
            int num = nums[i];
            while(num > 0){
                int r = num % 10;
                sum += r;
                num = num /10;
            }
            if(sum == i){
                return i;
            }
            sum =0;
        }
        return -1;
    }
}
```

---

**Runtime** 1 ms · **Memory** 45.4 MB

<sub>Synced by AILeetHub on 2026-09-24.</sub>
