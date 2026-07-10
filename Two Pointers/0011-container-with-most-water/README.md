# 11. Container With Most Water

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/container-with-most-water/)

`Array` · `Two Pointers` · `Greedy`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Two Pointers, Greedy.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxarea = 0;
        int area = 0;
        while(left < right){
            if(height[left] < height[right]){
                area = height[left] *(right-left);
                maxarea = Math.max(maxarea,area);
                left++;
            }
            else{
                area = height[right] *(right-left);
                maxarea = Math.max(maxarea,area);
                right--;
            }
        }
        return maxarea;
    }
}
```

---

**Runtime** 4 ms · **Memory** 77.3 MB

<sub>Synced by AILeetHub on 2026-07-10.</sub>
