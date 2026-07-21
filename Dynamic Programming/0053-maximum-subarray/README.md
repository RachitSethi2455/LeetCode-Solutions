# 53. Maximum Subarray

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/maximum-subarray/)

`Array` · `Divide and Conquer` · `Dynamic Programming`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Divide and Conquer, Dynamic Programming.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int maxSubArray(int[] nums) {
        /*int maxsum = nums[0];
        for(int i =0; i< nums.length ; i++){
            int sum =0;
            for(int j=i;j< nums.length; j++){
                sum = sum + nums[j];
                maxsum = Math.max(maxsum,sum);
            }
        }
        return maxsum;*/
        int maxsum= nums[0];
        int sum =0;
        for(int i =0; i < nums.length; i++){
            sum = sum + nums[i];
            maxsum =Math.max(sum,maxsum);
            if(sum<0){
                sum =0;
            }
        }
        return maxsum;
    }
}
```

---

**Runtime** 1 ms · **Memory** 77.1 MB

<sub>Synced by AILeetHub on 2026-07-21.</sub>
