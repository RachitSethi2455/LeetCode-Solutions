# 678. Valid Parenthesis String

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/valid-parenthesis-string/)

`String` · `Dynamic Programming` · `Stack` · `Greedy` · `Bracket Sequences`

## Intuition  
The key observation is that we can keep track of the *range* of possible open‑parenthesis counts as we scan the string once. After processing any prefix, `low` is the smallest number of unmatched '(' that could remain (treating every ‘*’ as a ')'), while `high` is the largest such number (treating every ‘*’ as a '('). If at any point `high` becomes negative, even the most optimistic interpretation already has too many ')', so the whole string is invalid. This single pass eliminates the need for a second traversal, a stack, or exponential case analysis.

## Approach  
1. **Initialize** `low = 0`, `high = 0`.  
2. **Iterate** `i` from `0` to `s.length()‑1`.  
   - Read `c = s.charAt(i)`.  
   - **Update the range**:  
     * If `c == '('` → `low++`, `high++`.  
     * If `c == ')'` → `low--`, `high--`.  
     * If `c == '*'` → `low--` (use it as ')'), `high++` (use it as '(').  
   - **Clamp the lower bound**: if `low < 0` set `low = 0`. This reflects that a negative minimum means we can discard some ‘*’ as empty to avoid a deficit.  
   - **Early failure check**: if `high < 0` return `false`. Even the maximal possible open count is negative, so no interpretation can balance the prefix.  
3. **After the loop**, the string is valid iff `low == 0`. A non‑zero `low` means every possible interpretation still leaves at least one unmatched '('.

*Edge handling*:  
- Empty or single‑character strings are covered because the loop runs zero or one iteration and the final `low == 0` test correctly decides validity.  
- For odd‑length strings the algorithm still works; the range logic automatically rejects impossible balances.  
- The `<=` vs `<` distinction is irrelevant here because we clamp only when `low` drops below zero; `high` is allowed to be zero (a perfectly balanced prefix).

## Dry Run  
**Input:** `s = "(*))"`  

| i | c   | low (min open) | high (max open) | note                              |
|---|-----|----------------|-----------------|-----------------------------------|
| 0 | '(' | 1 → 1          | 1 → 1           | '(' adds one to both bounds       |
| 1 | '*' | 1‑1 = 0 → 0    | 1+1 = 2 → 2     | treat as ')' for low, '(' for high|
| 2 | ')' | 0‑1 = -1 → 0   | 2‑1 = 1 → 1     | low clamped to 0                  |
| 3 | ')' | 0‑1 = -1 → 0   | 1‑1 = 0 → 0     | still non‑negative, continue      |

Loop ends; `low == 0`, so the method returns `true`. The final state shows that there exists an interpretation (e.g., `(*)` → `()`) that balances all parentheses.

## Complexity  
- **Time:** O(n) – the single `for` loop visits each character once, and `high` moves at most two steps per iteration.  
- **Space:** O(1) – only a few integer variables (`low`, `high`, `i`, `c`) are used, independent of input size. The output is a boolean, not counted toward extra space.

## Solution (Java)

```java
class Solution {
    public boolean checkValidString(String s) {

        int low = 0;
        int high = 0;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == '(') {
                low++;
                high++;
            }
            else if (c == ')') {
                low--;
                high--;
            }
            else { // '*'
                low--;
                high++;
            }

            // Minimum balance cannot go below 0
            if (low < 0) {
                low = 0;
            }

            // Even maximum balance is negative
            if (high < 0) {
                return false;
            }
        }
        return low == 0;
    }
}
```

---

**Runtime** 0 ms (beats 100.0%) · **Memory** 42.7 MB (beats 51.5%)

<sub>Synced by AILeetHub on 2026-10-04.</sub>
