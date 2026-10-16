# 468. Validate IP Address

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/validate-ip-address/)

`String`

## Intuition  
The string can only be one of two well‑defined formats: four decimal blocks separated by ‘.’ (IPv4) or eight hexadecimal blocks separated by ‘:’ (IPv6). The key observation is that the presence of a dot or a colon uniquely determines which format to validate, so we never need to try both. A naïve solution might scan the string twice, build auxiliary structures, or use regular expressions, but the delimiter check lets us discard the irrelevant format immediately and validate the chosen one in a single linear pass.

## Approach  
1. **Detect format** – If `queryIP.contains(".")` we treat it as a candidate IPv4; else if `queryIP.contains(":")` we treat it as a candidate IPv6; otherwise return `"Neither"`.  
2. **Split preserving empties** – `queryIP.split("\\.", -1)` (or `split(":", -1)`) produces all blocks, including empty strings that arise from leading, trailing, or consecutive delimiters. The `-1` limit is crucial; without it, trailing empties would be dropped and the length check would be wrong.  
3. **Length check** – For IPv4 we require exactly 4 parts; for IPv6 exactly 8. Any deviation yields `"Neither"`.  
4. **Iterate over each block (`val`)**:  
   - **Empty block** – `val.length() == 0` → invalid.  
   - **IPv4‑specific checks**:  
     * Leading zero rule: if `val.length() > 1 && val.charAt(0) == '0'` → invalid.  
     * Digit‑only rule: iterate `for (char c : val.toCharArray())` and reject any non‑digit.  
     * Length bound: `val.length() > 3` → invalid (since max 255).  
     * Numeric bound: `Integer.parseInt(val) > 255` → invalid.  
   - **IPv6‑specific checks**:  
     * Length rule: `val.length() < 1 || val.length() > 4` → invalid.  
     * Hexadecimal rule: iterate characters and reject any that are not a digit nor in `'a'–'f'` nor `'A'–'F'`.  
5. **Return result** – If the loop finishes without hitting a `return "Neither"`, the address satisfies all constraints, so return `"IPv4"` or `"IPv6"` accordingly.

## Dry Run  

Input: `queryIP = "172.16.254.1"`

| Iteration | `parts` (split by ‘.’)                | `val` examined | Checks passed / failed | Note                              |
|-----------|---------------------------------------|----------------|------------------------|-----------------------------------|
| 1         | ["172","16","254","1"]                | "172"          | length = 3, no leading 0, all digits, ≤255 | IPv4 block valid |
| 2         | same                                  | "16"           | length = 2, no leading 0, all digits, ≤255 | IPv4 block valid |
| 3         | same                                  | "254"          | length = 3, no leading 0, all digits, ≤255 | IPv4 block valid |
| 4         | same                                  | "1"            | length = 1, digit, ≤255                 | IPv4 block valid |

All four parts pass; loop ends, function returns `"IPv4"` because the dot‑path was taken.

## Complexity  
- **Time:** O(n) – the string is scanned once to split and then each character is examined exactly once; for IPv4 the loop runs at most n/2 times because `fast`‑style advancement is not used, but the linear bound holds.  
- **Space:** O(1) extra – aside from the `parts` array that references substrings of the original input (no additional data structures proportional to n are allocated).

## Solution (Java)

```java
class Solution {
    public String validIPAddress(String queryIP) {
        if(queryIP.contains(".")){
            String[] parts = queryIP.split("\\.",-1);
            if(parts.length != 4){
                return "Neither";
            }
            for(String val : parts){
                if(val.length() ==0){
                    return "Neither";
                }
                if(val.length()>1 && val.charAt(0) == '0'){
                    return "Neither";
                }
                for(char c : val.toCharArray()){
                    if(!Character.isDigit(c)){
                        return "Neither";
                    }
                }
                if(val.length()>3){
                    return "Neither";
                }
                if(Integer.parseInt(val)>255){
                    return "Neither";
                }
            }
            return "IPv4";
        }
        else if(queryIP.contains(":")){
            String[] parts = queryIP.split(":",-1);
            if(parts.length != 8){
                return "Neither";
            }
            for(String val : parts){
                if(val.length()<1 || val.length()>4){
                    return "Neither";
                }
                for(char c : val.toCharArray()){
                    if(!Character.isDigit(c) && !(c >= 'a' && c<= 'f') &&
                    !(c >= 'A' && c<= 'F')){
                    return "Neither";
                    }
                }
            }
            return "IPv6";
        }
        else{
            return "Neither";
        }
    }
}
```

---

**Runtime** 1 ms (beats 94.2%) · **Memory** 42.5 MB (beats 97.6%)

<sub>Synced by AILeetHub on 2026-10-16.</sub>
