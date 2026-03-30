# 169. Majority Element

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/majority-element/)

`Array` · `Hash Table` · `Divide and Conquer` · `Sorting` · `Counting` · `Boyer–Moore Majority Vote Algorithm`

## Approach

Accepted easy solution in java.
Relevant topics: Array, Hash Table, Divide and Conquer, Sorting, Counting, Boyer–Moore Majority Vote Algorithm.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > n / 2) {
                return num; // majority found early
            }
        }
        return -1;
    }
}
```

---

**Runtime** 16 ms · **Memory** 52.5 MB

<sub>Synced by AILeetHub on 2026-03-30.</sub>
