# 88. Merge Sorted Array

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/merge-sorted-array/)

`Array` · `Two Pointers` · `Sorting`

## Approach

Accepted easy solution in java.
Relevant topics: Array, Two Pointers, Sorting.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[m+n];
        int i=0;
        for(int num : nums1){
            if(i<m){
                ans[i] = num;
                i++;
            }
        }
        for(int nums : nums2){
            ans[i] = nums;
            i++;
        }
        Arrays.sort(ans);
        for (int idx = 0; idx < m+n; idx++) {
            nums1[idx] = ans[idx];
        }
    }
}
```

---

**Runtime** 4 ms · **Memory** 44.1 MB

<sub>Synced by AILeetHub on 2026-01-25.</sub>
