# 13. Roman to Integer

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/roman-to-integer/)

`Hash Table` · `Math` · `String`

## Approach

Accepted easy solution in java.
Relevant topics: Hash Table, Math, String.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> values = new HashMap<>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);

        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int current = values.get(s.charAt(i));
            
            // Check if next symbol exists and is larger
            if (i + 1 < s.length() && current < values.get(s.charAt(i + 1))) {
                total -= current;
            } else {
                total += current;
            }
        }
        return total;
    }
}
```

---

**Runtime** 4 ms · **Memory** 46.6 MB

<sub>Synced by AILeetHub on 2026-04-07.</sub>
