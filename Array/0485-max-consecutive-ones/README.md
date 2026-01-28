# 485. Max Consecutive Ones

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/max-consecutive-ones/)

`Array`

## Approach

Accepted easy solution in java.
Relevant topics: Array.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        /*ArrayList<Integer> l = new ArrayList<>();
        int count =0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 1){
                count++;
            }
            else{
                l.add(count);
                count = 0;
            }
            l.add(count);
        }
        int cons = Collections.max(l);
        return cons;*/
        int count =0;
        int max =0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 1){
                count++;
                max = Math.max(max,count);
            }
            else{
                count = 0;
            }
        }
        return max;
    }
}
```

---

**Runtime** 3 ms · **Memory** 52.7 MB

<sub>Synced by AILeetHub on 2026-01-28.</sub>
