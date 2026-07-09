# 219. Contains Duplicate II

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/contains-duplicate-ii/)

`Array` · `Hash Table` · `Sliding Window`

## Approach

Accepted easy solution in java.
Relevant topics: Array, Hash Table, Sliding Window.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        /*for(int i =0; i<nums.length; i++){
            for(int j =i+1; j<nums.length;j++){
                if(nums[i] == nums[j] && Math.abs(i-j)<=k){
                    return true;
                }
            }
        }*/
        HashMap<Integer,Integer> map = new HashMap<>();
        int i =0;
        while(i< nums.length){
            if(map.containsKey(nums[i])){
                int j = map.get(nums[i]);
                if(Math.abs(i-j)<= k){
                    return true;
                }
            }
            map.put(nums[i],i);
            i++;
        }
        return false;
    }
}
```

---

**Runtime** 24 ms · **Memory** 90.8 MB

<sub>Synced by AILeetHub on 2026-07-09.</sub>
