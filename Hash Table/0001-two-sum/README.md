# 1. Two Sum

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/two-sum/)

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
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length; i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]== target){
                    int arr[]={i,j};
                    return arr;
                }
            }
        }
        return new int[]{};
    }
}
```

---

**Runtime** 45 ms · **Memory** 46.9 MB

<sub>Synced by AILeetHub on 2025-12-26.</sub>
