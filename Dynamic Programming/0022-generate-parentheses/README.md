# 22. Generate Parentheses

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/generate-parentheses/)

`String` · `Dynamic Programming` · `Backtracking` · `Bracket Sequences`

## Approach

Accepted medium solution in java.
Relevant topics: String, Dynamic Programming, Backtracking, Bracket Sequences.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    void helper(String curr, int open , int close, int n){

        if(open == n && close == n){
            res.add(curr);// only adds after string build is complete
            return;
        }

        if(open < n){
            helper(curr+"(" , open +1 , close,n);// exploring open braces
        }

        if(close < open){
            helper(curr+")" , open , close +1,n);// exploring all the closing bracket opts
        }
    }

    ArrayList<String> res = new ArrayList<>();// outside so that helper can use it

    public List<String> generateParenthesis(int n) {

        res.clear();
        helper("", 0, 0, n);
        return res;

    }
}
```

---

**Runtime** 2 ms · **Memory** 45.2 MB

<sub>Synced by AILeetHub on 2026-10-02.</sub>
