# 62. Unique Paths

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/unique-paths/)

`Math` · `Dynamic Programming` · `Combinatorics`

## Intuition  
The number of ways to reach the bottom‑right corner from any cell equals the sum of ways from the cell directly below and the cell directly to the right. This creates overlapping subproblems: many recursive calls ask for the same sub‑grid. By caching the result for each coordinate the exponential blow‑up disappears, turning the naïve recursion into a linear‑time DP. The obvious brute‑force recursion would explore every path (≈ 2^(m+n)) and is infeasible; memoization removes the repeated work. The pattern used is **top‑down dynamic programming with memoization**.

## Approach  
1. **Allocate memo table** – `int[][] dp = new int[m][n];` all entries start at 0, meaning “not computed”.  
2. **Start recursion** – call `helper(m, n, 0, 0, dp)`.  
3. **Base case 1 (target reached)** – if `i == m‑1 && j == n‑1` return 1 because the robot is already at the destination.  
4. **Base case 2 (out of bounds)** – if `i >= m || j >= n` return 0; no path can continue outside the grid.  
5. **Memo check** – if `dp[i][j] != 0` return the cached value; this guarantees each cell is processed once.  
6. **Recursive expansion** – compute `right = helper(m, n, i+1, j, dp)` (move down) and `down = helper(m, n, i, j+1, dp)` (move right).  
7. **Store and return** – assign `dp[i][j] = down + right` and return that sum.  

The loop invariant for every call is: *`dp[i][j]` either holds the exact number of paths from `(i,j)` to the goal, or is still 0 because the subproblem has not been solved yet.* The exit condition of the recursion is reaching either the target cell or an out‑of‑bounds coordinate.

Edge handling: when `m == 1` or `n == 1` the recursion quickly hits the out‑of‑bounds base case after a single straight line, correctly returning 1. The code chooses `dp[i][j] != 0` as the memo guard; this works because the answer is always ≥ 1 for reachable cells, so 0 can safely denote “uncomputed”.

## Dry Run  
**Input:** `m = 3, n = 2` (grid 3 × 2)  

| Call # | (i, j) | dp[i][j] before | Action                               | dp[i][j] after | Note                              |
|-------|--------|----------------|--------------------------------------|----------------|-----------------------------------|
| 1     | (0,0)  | 0              | recurse to (1,0) and (0,1)           | –              | start from top‑left               |
| 2     | (1,0)  | 0              | recurse to (2,0) and (1,1)           | –              |                                   |
| 3     | (2,0)  | 0              | recurse to (3,0) → out of bounds, (2,1) | –          | out‑of‑bounds returns 0           |
| 4     | (2,1)  | 0              | target reached → return 1            | dp[2][1]=1     | bottom‑right cell                 |
| 5     | (1,0)  | 0              | combine: down=1 (from (2,0)→0) + right=1 (from (1,1) later) | dp[1][0]=1 | after both children resolved     |
| 6     | (1,1)  | 0              | target reached → return 1            | dp[1][1]=1     |                                   |
| 7     | (0,0)  | 0              | combine: down=1 (from (1,0)) + right=1 (from (0,1) later) | dp[0][0]=2 | after (0,1) finishes              |
| 8     | (0,1)  | 0              | target reached → return 1            | dp[0][1]=1     | final right‑move from start       |

After all calls finish, `dp[0][0] = 3`, which is the total number of unique paths for a 3 × 2 grid.

## Complexity  
- **Time:** `O(m × n)` – each cell `(i,j)` is evaluated at most once because the memo check prevents re‑execution of its sub‑problem.  
- **Space:** `O(m × n)` for the `dp` table plus `O(m + n)` recursion stack depth (the longest path from top‑left to bottom‑right). The output itself is a single integer, so it does not affect the asymptotic bound.

## Solution (Java)

```java
class Solution {
    /*int helper(int m, int n, int i, int j){
        if(i == m-1 && j == n-1) return 1;
        if(i >= m || j >= n) return 0;
        int right = helper(m,n,i+1,j);
        int down = helper(m,n,i,j+1);
        return right + down;
    }
    public int uniquePaths(int m, int n) {
        return helper(m,n,0,0);
    }*/
    int helper(int m, int n, int i, int j, int[][] dp){
        if(i == m-1 && j == n-1) return 1;
        if(i >= m || j >= n) return 0;

        if(dp[i][j] != 0) return dp[i][j];

        int right = helper(m,n,i+1,j,dp);
        int down = helper(m,n,i,j+1,dp);

        return dp[i][j] = down + right;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return helper(m,n,0,0,dp);
    }
}
```

---

**Runtime** 0 ms (beats 100.0%) · **Memory** 42.2 MB (beats 28.4%)

<sub>Synced by AILeetHub on 2026-10-11.</sub>
