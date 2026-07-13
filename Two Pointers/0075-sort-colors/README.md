# 75. Sort Colors

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/sort-colors/)

`Array` · `Two Pointers` · `Sorting` · `Quicksort` · `Bubble Sort`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Two Pointers, Sorting, Quicksort, Bubble Sort.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public void sortColors(int[] nums) {
       int[] ar = new int[nums.length];
       int s=0;
       int e=nums.length-1;
       for(int i=0;i<nums.length;i++){
        if(nums[i]==0){
            ar[s]=nums[i];
            s++;
        }
        else if(nums[i]==2){
            ar[e]=nums[i];
            e--;
        }
       }
       for(int j=s;j<=e;j++){
        ar[j]=1;
       }
       for(int k =0;k<nums.length;k++){
        nums[k]=ar[k];
       }
    }
}
```

---

**Runtime** 0 ms · **Memory** 43.3 MB

<sub>Synced by AILeetHub on 2026-07-13.</sub>
