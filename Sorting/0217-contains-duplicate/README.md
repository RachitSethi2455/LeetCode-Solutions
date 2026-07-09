# 217. Contains Duplicate

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/contains-duplicate/)

`Array` · `Hash Table` · `Sorting`

## Approach

Accepted easy solution in java.
Relevant topics: Array, Hash Table, Sorting.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        /*for(int i =0; i<nums.length; i++){
            for(int j =i+1; j<nums.length;j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }*/
        HashSet<Integer> set = new HashSet<>();
        int i =0;
        while(i < nums.length){
            if(set.contains(nums[i])){
                return true;
            }
            else{
                set.add(nums[i]);
                i++;
            }
        }
        return false;
    }
}
```

---

**Runtime** 18 ms · **Memory** 108.3 MB

<sub>Synced by AILeetHub on 2026-07-09.</sub>
