# 20. Valid Parentheses

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/valid-parentheses/)

`String` · `Stack` · `Bracket Sequences`

## Intuition  
The key observation is that a closing bracket must match the most recent unmatched opening bracket; therefore the sequence of opens can be treated as a LIFO stack. A naïve solution that scans the string twice—once to collect opens and once to match closes—would either miss ordering or require extra storage such as a hash map. By maintaining a single stack while walking the string once, we guarantee that every close either finds its correct partner at the top of the stack or triggers an immediate failure. This is the classic **two‑pointer/stack** pattern for bracket matching.

## Approach  
1. **Initialize** an empty `Stack<Character>` called `stack`.  
2. **Iterate** over the string with index `i` from `0` to `l‑1` (`l = s.length()`).  
   - *Loop invariant*: before processing `s[i]`, `stack` contains exactly the unmatched opening brackets that appear earlier in the string, in the order they were seen.  
3. **Read** the current character `c = s.charAt(i)`.  
   - If `c` is one of `'('`, `'['`, `'{'`, **push** it onto `stack`.  
   - Otherwise `c` is a closing bracket.  
     - **Guard**: if `stack.isEmpty()`, there is no opening bracket to match, so return `false`.  
     - **Pop** the top element `top = stack.pop()`.  
     - **Validate** that `top` and `c` form a legal pair:  
       - `c == ')' && top == '('`  
       - `c == ']' && top == '['`  
       - `c == '}' && top == '{'`  
       If none hold, return `false`.  
4. After the loop finishes, **final check**: the string is valid only when `stack.isEmpty()`, meaning every opening bracket found a matching closing one.  

**Edge‑case handling**:  
- Empty or single‑character strings are covered because the loop runs zero or one iteration and the final emptiness test catches mismatches.  
- For odd‑length inputs the final emptiness test fails automatically.  
- The code uses `stack.isEmpty()` before `pop` to avoid `EmptyStackException`.  
- The `if` chain uses `||` with explicit comparisons rather than a map to keep constant‑time checks and avoid extra memory.

## Dry Run  

Input: `s = "([)]"`

| i | c  | stack before | action                               | stack after | note                              |
|---|----|--------------|--------------------------------------|-------------|-----------------------------------|
| 0 | '('| []           | push '('                             | ['(']       | opening bracket added            |
| 1 | '['| ['(']        | push '['                             | ['(','[']   | another opening bracket           |
| 2 | ')'| ['(','[']    | pop → top='['; mismatch with ')' → return false | – | early exit because pair invalid |
| 3 | –  | –            | –                                    | –           | loop terminated                  |

The algorithm stops at `i = 2` and returns `false` because the closing `')'` does not match the most recent `'['`. Hence the string is invalid.

## Complexity  
- **Time:** O(n) – the single `for` loop visits each character once, and each stack operation (`push`, `pop`, `isEmpty`) is O(1).  
- **Space:** O(n) in the worst case when the string consists only of opening brackets, because the stack stores up to `n` characters. (The output boolean is not counted.)

## Solution (Java)

```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int l = s.length();
        for(int i =0; i< l; i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if((c == ')' && top != '(') || (c == ']' && top != '[') || 
                (c == '}' && top != '{')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
```

---

**Runtime** 3 ms (beats 83.1%) · **Memory** 43.3 MB (beats 40.3%)

<sub>Synced by AILeetHub on 2026-09-07.</sub>
