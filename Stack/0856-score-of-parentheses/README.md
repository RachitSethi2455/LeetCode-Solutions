# 856. Score of Parentheses

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/score-of-parentheses/)

`String` · `Stack` · `Bracket Sequences`

## Intuition  
When we scan a balanced parentheses string from left to right, the score contributed by a closing parenthesis depends only on the score accumulated **inside** its matching pair. If the inner segment is empty the pair contributes 1; otherwise it contributes twice the inner score. By keeping a running total for each nesting level, we can compute the final score in a single pass without any extra passes, hash maps, or recursion. This observation leads naturally to a **stack** that stores the partial scores of each depth.

## Approach  
1. **Initialize** a stack with a single `0`. This sentinel represents the score of the outermost (virtual) level.  
2. **Iterate** over the characters of `s` using index `i`.  
   - **If** `c == '('` → push `0` onto the stack. The new top will accumulate the score of the substring that starts at this '(' .  
   - **Else** (`c == ')'`) → a matching pair is closed:  
     a. `inside = stack.pop();` // score of the substring directly inside this pair.  
     b. Compute `val`:  
        - `if (inside == 0) val = 1;` // “()” case.  
        - `else val = 2 * inside;` // “(A)” case.  
     c. `previous = stack.pop();` // score accumulated before this pair at the outer level.  
     d. `stack.push(previous + val);` // merge the pair’s contribution into the outer level.  
3. After the loop finishes, the stack contains a single element – the total score. Return `stack.pop();`.

**Key invariants**  
- The stack always holds scores for each open '(' that has not yet been closed, from outermost (bottom) to innermost (top).  
- The top element is the score of the current innermost unfinished segment.  

**Edge handling**  
- Empty or single‑character strings cannot occur because the input is guaranteed balanced and length ≥ 2.  
- The sentinel `0` avoids a special‑case when the outermost pair finishes; we always have a `previous` to pop.  
- The `<=` vs `<` issue does not arise because we compare `inside == 0` exactly, distinguishing the empty‑pair case.

## Dry Run  

**Input:** `(())`

| i | c | stack (bottom→top)          | inside | val | previous | note                              |
|---|---|-----------------------------|--------|-----|----------|-----------------------------------|
| 0 | '('| `[0, 0]`                    | –      | –   | –        | push a new level for '('          |
| 1 | '('| `[0, 0, 0]`                 | –      | –   | –        | another nested '('                |
| 2 | ')'| pop → `inside=0`; `val=1`; pop → `previous=0`; push `0+1` → `[0, 1]` | 0 | 1 | 0 | closed inner “()”, contributes 1 |
| 3 | ')'| pop → `inside=1`; `val=2*1=2`; pop → `previous=0`; push `0+2` → `[2]` | 1 | 2 | 0 | closed outer pair, doubles inner  |

After processing all characters the stack holds `[2]`; popping yields `2`, which is the correct score.

## Complexity  
- **Time:** **O(n)** – the loop runs once per character; each iteration performs a constant amount of stack operations.  
- **Space:** **O(n)** – in the worst case (e.g., `"(((...)))"`), the stack depth grows linearly with the number of '(' characters. The output integer itself is not counted toward extra space.

## Solution (Java)

```java
class Solution {
    public int scoreOfParentheses(String s) {
        /*int score =0;
        Stack<Character> stack = new Stack<>();
        for(int i =0; i< s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(c);
            }
            else{
                stack.pop();
                score++;
            }
        }
        return score;*/
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i =0; i< s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(0);
            }
            else{
                int inside = stack.pop();
                int val;
                if(inside == 0){
                    val=1;
                }
                else{
                    val = 2*inside;
                }
                int previous = stack.pop();
                stack.push(previous + val);
            }
        }
        return stack.pop();
    }
}
```

---

**Runtime** 1 ms (beats 62.0%) · **Memory** 42.9 MB (beats 12.4%)

<sub>Synced by AILeetHub on 2026-10-05.</sub>
