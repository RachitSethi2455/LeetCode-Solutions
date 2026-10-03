# 32. Longest Valid Parentheses

![Hard](https://img.shields.io/badge/Difficulty-Hard-ff375f?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/longest-valid-parentheses/)

`String` · `Dynamic Programming` · `Stack` · `Bracket Sequences`

## Approach

Accepted hard solution in java.
Relevant topics: String, Dynamic Programming, Stack, Bracket Sequences.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int longestValidParentheses(String s) {
        Stack <Integer> st = new Stack<>();
        st.push(-1);
        int ans =0;
        for(int i =0; i < s.length(); i++){
            char c = s.charAt(i);
            if( c == '('){
                st.push(i);
            }
            else{
                st.pop();
                if (st.isEmpty()) {
                    st.push(i);
                }
                else {
                    ans = Math.max(ans, i - st.peek());
                }
            }
        }
        return ans;
    }
}
```

---

**Runtime** 5 ms · **Memory** 46.7 MB

<sub>Synced by AILeetHub on 2026-10-03.</sub>
