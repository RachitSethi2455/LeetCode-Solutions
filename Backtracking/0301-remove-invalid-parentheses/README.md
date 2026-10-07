# 301. Remove Invalid Parentheses

![Hard](https://img.shields.io/badge/Difficulty-Hard-ff375f?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/remove-invalid-parentheses/)

`String` · `Backtracking` · `Breadth-First Search`

## Intuition  
The key observation is that the number of parentheses that must be deleted can be determined in a single left‑to‑right scan: every unmatched ‘)’ increments a *close* counter, and every ‘(’ that later finds a matching ‘)’ decrements an *open* counter. After the scan `open` tells how many ‘(’ and `close` how many ‘)’ need to be removed to obtain any valid string. Knowing these exact quotas eliminates the naïve exponential search over all subsets or the need for a BFS that explores strings level by level. The solution therefore follows the classic **backtracking with pruning** pattern, where each character is either kept or discarded while respecting the remaining removal quotas and a running balance of open parentheses.

## Approach  
1. **Count removals** – Iterate `c` over `s.toCharArray()`.  
   * If `c == '('` → `open++`.  
   * If `c == ')'` → if `open > 0` then `open--` (pair found); else `close++`.  
   After the loop `open` = number of ‘(’ to delete, `close` = number of ‘)’ to delete.  

2. **Start recursion** – Call `backtrack(s, 0, open, close, 0, new StringBuilder())`.  

3. **Base case – invalid prefix** – If `balance < 0` (more ‘)’ than ‘(’) return immediately; this prunes any branch that can never become valid.  

4. **Base case – end of string** – When `index == s.length()`:  
   * Accept the built string only if `openToRemove == 0`, `closeToRemove == 0`, and `balance == 0`.  
   * Convert `curr` to a string, add to `ans` if not already present (deduplication).  

5. **Process current character `c = s.charAt(index)`**  
   * **Letter** (`c` not '(' or ')'): must be kept. Append, recurse with `index+1`, then backtrack (`deleteCharAt`).  
   * **'('**:  
     - *Remove* branch if `openToRemove > 0` → recurse with `openToRemove‑1`.  
     - *Keep* branch → append `'('`, recurse with `balance+1`, then backtrack.  
   * **')'**:  
     - *Remove* branch if `closeToRemove > 0` → recurse with `closeToRemove‑1`.  
     - *Keep* branch → append `')'`, recurse with `balance‑1`, then backtrack.  

6. **Termination** – All recursive calls eventually hit one of the base cases, guaranteeing that every feasible combination respecting the exact removal counts is examined exactly once.

## Dry Run  
Input: `()())()`

| step | index | char | openToRemove | closeToRemove | balance | curr   | note                              |
|------|-------|------|--------------|---------------|---------|--------|-----------------------------------|
| 1    | 0     | '('  | 1            | 0             | 0       | ""     | keep '(' → balance=1              |
| 2    | 1     | ')'  | 1            | 0             | 1       | "("    | keep ')' → balance=0              |
| 3    | 2     | '('  | 1            | 0             | 0       | "()"   | keep '(' → balance=1              |
| 4    | 3     | ')'  | 1            | 0             | 1       | "()("  | keep ')' → balance=0              |
| 5    | 4     | ')'  | 1            | 0             | 0       | "()()" | **remove** this ')' (closeToRemove=0) |
| 6    | 5     | '('  | 0            | 0             | 0       | "()()" | keep '(' → balance=1              |
| 7    | 6     | ')'  | 0            | 0             | 1       | "()()(" | keep ')' → balance=0, end reached |
| 8    | 7     | –    | 0            | 0             | 0       | "()()()"| accepted → added to `ans`          |

The recursion also explores the branch that removes the first `'('` (using `openToRemove`), producing the second valid result `"(() )()"`. Both strings have the minimum two deletions, so `ans = ["()()()", "(())()"]`.

## Complexity  
- **Time:** O( C ), where C is the number of distinct recursive states. Each state corresponds to a unique tuple `(index, openToRemove, closeToRemove, balance)`. In the worst case this is bounded by O( n·open·close ), but the initial counting step guarantees that `open + close` ≤ number of parentheses (≤20), so the practical runtime is exponential in the number of removable parentheses, not in `n`.  
- **Space:** O( n ) for the recursion stack and the `StringBuilder` that holds the current construction; the output list `ans` is excluded from the space count.

## Solution (Java)

```java
class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {

        int open = 0;
        int close = 0;

        // Find minimum number of '(' and ')' to remove
        for (char c : s.toCharArray()) {

            if (c == '(') {
                open++;
            }
            else if (c == ')') {

                if (open > 0) {
                    open--;
                }
                else {
                    close++;
                }
            }
        }

        backtrack(s, 0, open, close, 0, new StringBuilder());

        return ans;
    }

    void backtrack(String s, int index,
                   int openToRemove, int closeToRemove,
                   int balance, StringBuilder curr) {

        // Invalid prefix
        if (balance < 0) {
            return;
        }

        // End of string
        if (index == s.length()) {

            if (openToRemove == 0 &&
                closeToRemove == 0 &&
                balance == 0) {

                String result = curr.toString();

                if (!ans.contains(result)) {
                    ans.add(result);
                }
            }

            return;
        }

        char c = s.charAt(index);

        // Letter: must keep it
        if (c != '(' && c != ')') {

            curr.append(c);

            backtrack(s, index + 1,
                      openToRemove, closeToRemove,
                      balance, curr);

            curr.deleteCharAt(curr.length() - 1);

        }

        // '('
        else if (c == '(') {

            // Option 1: remove '('
            if (openToRemove > 0) {

                backtrack(s, index + 1,
                          openToRemove - 1,
                          closeToRemove,
                          balance, curr);
            }

            // Option 2: keep '('
            curr.append('(');

            backtrack(s, index + 1,
                      openToRemove,
                      closeToRemove,
                      balance + 1,
                      curr);

            curr.deleteCharAt(curr.length() - 1);
        }

        // ')'
        else {

            // Option 1: remove ')'
            if (closeToRemove > 0) {

                backtrack(s, index + 1,
                          openToRemove,
                          closeToRemove - 1,
                          balance, curr);
            }

            // Option 2: keep ')'
            curr.append(')');

            backtrack(s, index + 1,
                      openToRemove,
                      closeToRemove,
                      balance - 1,
                      curr);

            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
```

---

**Runtime** 144 ms (beats 23.7%) · **Memory** 43.6 MB (beats 94.6%)

<sub>Synced by AILeetHub on 2026-10-07.</sub>
