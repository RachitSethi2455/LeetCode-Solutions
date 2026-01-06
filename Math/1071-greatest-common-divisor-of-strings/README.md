# 1071. Greatest Common Divisor of Strings

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/greatest-common-divisor-of-strings/)

`Math` · `String` · `Euclidean Algorithm` · `Greatest Common Divisor`

## Approach

Accepted easy solution in java.
Relevant topics: Math, String, Euclidean Algorithm, Greatest Common Divisor.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        /*int sl2 = str2.length();
        StringBuilder result = new StringBuilder("");
        for(int i =0; i< sl2 ; i++){
            if(str1.charAt(i) == str2.charAt(i)){
                result.append(str2.charAt(i));
            }
        }
        return result.toString();*/
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }
        int gcd = gcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
```

---

**Runtime** 1 ms · **Memory** 43.5 MB

<sub>Synced by AILeetHub on 2026-01-06.</sub>
