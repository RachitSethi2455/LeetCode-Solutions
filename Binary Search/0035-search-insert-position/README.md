# 35. Search Insert Position

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/search-insert-position/)

`Array` · `Binary Search`

## Approach

Accepted easy solution in java.
Relevant topics: Array, Binary Search.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == target){
                ans = i;
            }
            else{
                if(target > nums[i]){
                    ans = ans+1;
                }
            }
        }
        return ans;
    }
}
```

---

**Runtime** 0 ms · **Memory** 44.3 MB

<sub>Synced by AILeetHub on 2026-01-20.</sub>
