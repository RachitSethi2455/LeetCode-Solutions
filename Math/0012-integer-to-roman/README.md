# 12. Integer to Roman

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/integer-to-roman/)

`Hash Table` · `Math` · `String`

## Approach

Accepted medium solution in java.
Relevant topics: Hash Table, Math, String.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder result = new StringBuilder();
        // Iterate through values
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                result.append(symbols[i]);
            }
        }
        return result.toString();
    }
}
```

---

**Runtime** 3 ms · **Memory** 46.2 MB

<sub>Synced by AILeetHub on 2026-04-20.</sub>
