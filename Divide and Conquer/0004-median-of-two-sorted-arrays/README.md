# 4. Median of Two Sorted Arrays

![Hard](https://img.shields.io/badge/Difficulty-Hard-ff375f?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/median-of-two-sorted-arrays/)

`Array` · `Binary Search` · `Divide and Conquer`

## Approach

Accepted hard solution in java.
Relevant topics: Array, Binary Search, Divide and Conquer.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> l = new ArrayList<>();
        double result;
        
        for(int num : nums1){
            l.add(num);
        }
        for(int num : nums2){
            l.add(num);
        }
        Collections.sort(l);
        if((nums1.length + nums2.length)%2 == 0){
            double a = l.get((nums1.length + nums2.length)/2);
            double b = l.get(((nums1.length + nums2.length)/2)-1);
            result = (a+b)/2;
        }
        else{
            result = l.get((nums1.length + nums2.length)/2);
        }
        return result;
    }
}
```

---

**Runtime** 7 ms · **Memory** 48.9 MB

<sub>Synced by AILeetHub on 2026-01-24.</sub>
