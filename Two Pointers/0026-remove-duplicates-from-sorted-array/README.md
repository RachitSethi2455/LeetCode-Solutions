# 26. Remove Duplicates from Sorted Array

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)

`Array` · `Two Pointers`

## Approach

Accepted easy solution in java.
Relevant topics: Array, Two Pointers.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        /*List<Integer> l = new ArrayList<>();
        for(int i =0; i< nums.length -1; i ++){
            for(int j =1; i< nums.length -1; i ++){
                if(nums[i] == nums[j]){
                    continue;
                }
                else{
                    l.add(nums[i]);
                }
            }
        }
        return l.size();*/
        if(nums.length == 0) return 0;
        int i =0;
        for(int j =1;j<nums.length;j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
```

---

**Runtime** 0 ms · **Memory** 46.8 MB

<sub>Synced by AILeetHub on 2026-01-18.</sub>
