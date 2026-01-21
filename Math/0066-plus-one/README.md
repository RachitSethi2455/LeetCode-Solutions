# 66. Plus One

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/plus-one/)

`Array` · `Math`

## Approach

Accepted easy solution in java.
Relevant topics: Array, Math.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int[] plusOne(int[] digits) {
        /*int len = digits.length;
        if(digits[len -1] != 9){
            digits[len- 1] = digits[len- 1] + 1;
        }
        else{
            for(int i =0; i<= digits.length;i++){
            }
        }
        return digits;*/
        int len = digits.length;
        for(int i = len-1;i>=0;i--){
            if(digits[i] < 9){
                digits[i] = digits[i] + 1;
                return digits;
            }
            digits[i]=0;
        }
        int[] res = new int[len+1];
        res[0] =1;
        return res;
    }
}
```

---

**Runtime** 0 ms · **Memory** 43.5 MB

<sub>Synced by AILeetHub on 2026-01-21.</sub>
