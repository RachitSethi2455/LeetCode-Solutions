# 1502. Can Make Arithmetic Progression From Sequence

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/)

`Array` · `Sorting`

## Approach

Accepted easy solution in java.
Relevant topics: Array, Sorting.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int prog = arr[1] - arr[0];
        for(int i=0;i<arr.length -1;i++){
            int diff = arr[i+1] - arr[i];
            if(diff == prog){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
```

---

**Runtime** 5 ms · **Memory** 44.2 MB

<sub>Synced by AILeetHub on 2025-12-29.</sub>
