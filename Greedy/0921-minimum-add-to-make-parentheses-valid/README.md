# 921. Minimum Add to Make Parentheses Valid

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/)

`String` · `Stack` · `Greedy` · `Bracket Sequences`

## Intuition  
While scanning a parentheses string from left to right we can keep a single counter that represents how many opening brackets are currently unmatched. Every time we see a `'('` we increment the counter, and every time we see a `')'` we try to match it with a previously seen `'('`. If the counter is already zero, the closing bracket cannot be matched and therefore forces us to insert an opening bracket somewhere before it – we record this need with a separate counter. The total number of insertions is simply the sum of unmatched opens left at the end and the number of forced inserts recorded along the way. A naïve solution might build an explicit stack or perform two passes (first counting opens, then closes), but the single‑pass greedy balance eliminates both extra memory and extra traversal. This pattern is commonly called a **greedy balance counter** for bracket sequences.

## Approach  
1. **Initialize** `open = 0` (unmatched `'('` count) and `res = 0` (insertions needed for stray `')'`).  
2. **Iterate** `i` from `0` to `s.length()‑1`.  
   - **Invariant** before each iteration: `open` equals the number of `'('` seen so far that have not been paired, and `res` equals the number of `')'` that could not be paired up to index `i‑1`.  
   - Read `c = s.charAt(i)`.  
3. **If** `c == '('` → `open++`. This records a new potential match.  
4. **Else** (`c == ')'`):  
   - **If** `open > 0` → a previous `'('` can pair with this `')'`; decrement `open--`.  
   - **Else** (`open == 0`) → there is no opening bracket to match, so we must insert one; increment `res++`.  
5. **After the loop**, all characters have been processed; `open` now holds the number of unmatched `'('` that still need a closing partner, and `res` holds the number of inserted `'('` needed for stray `')'`.  
6. **Return** `open + res`. This sum is the minimal number of insertions because each unmatched opening requires exactly one closing insertion and each unmatched closing required exactly one opening insertion, and no insertion can serve two mismatches simultaneously.

Edge cases are handled naturally: an empty string never enters the loop, leaving both counters at zero; a single‑character string updates either `open` or `res` accordingly; the algorithm does not depend on the parity of the length, so even and odd lengths are treated uniformly.

## Dry Run  

Input: `s = "())"`  

| i | c | open (before) | res (before) | Action                               | open (after) | res (after) | Note                         |
|---|---|----------------|--------------|--------------------------------------|--------------|-------------|------------------------------|
| 0 | '('| 0              | 0            | `open++`                             | 1            | 0           | first opening seen           |
| 1 | ')'| 1              | 0            | `open > 0` → `open--`                | 0            | 0           | matches previous '('         |
| 2 | ')'| 0              | 0            | `open == 0` → `res++`                | 0            | 1           | stray closing, need '('      |

Loop ends. `open = 0`, `res = 1`, so the function returns `1`. One insertion (an opening '(' before the last ')') makes the string valid, which is optimal.

## Complexity  
- **Time:** `O(n)` – the single `for` loop visits each character exactly once.  
- **Space:** `O(1)` – only two integer counters (`open` and `res`) are used, independent of input size. The output integer is not counted as extra space.

## Solution (Java)

```java
class Solution {
    public int minAddToMakeValid(String s) {
        /*int open=0;
        int close=0;
        for(int i =0; i <s.length();i++){
            char c= s.charAt(i);
            if( c == '(' ){
                open++;
            }
            if( c == ')' ){
                close++;
            }
        }
        int res = Math.abs(open - close);
        return res;*/
        int open =0;
        int res =0;
        for(int i =0; i <s.length(); i++){
            char c = s.charAt(i);
            if (c == '('){
                open++;
            }
            else{
                if(open > 0){
                    open--;
                }
                else{
                    res++;
                }
            }
        }
        return open + res;
    }
}
```

---

**Runtime** 1 ms (beats 70.1%) · **Memory** 42.9 MB (beats 39.7%)

<sub>Synced by AILeetHub on 2026-10-06.</sub>
