# 42. Trapping Rain Water

![Hard](https://img.shields.io/badge/Difficulty-Hard-ff375f?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/trapping-rain-water/)

`Array` · `Two Pointers` · `Dynamic Programming` · `Stack` · `Monotonic Stack`

## Approach

Accepted hard solution in java.
Relevant topics: Array, Two Pointers, Dynamic Programming, Stack, Monotonic Stack.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }
}
```

---

**Runtime** 0 ms · **Memory** 47.5 MB

<sub>Synced by AILeetHub on 2026-04-09.</sub>
