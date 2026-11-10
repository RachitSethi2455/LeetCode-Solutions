# 70. Climbing Stairs

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/climbing-stairs/)

`Math` · `Dynamic Programming` · `Memoization`

## Intuition  
The number of ways to finish the climb from any step *i* is exactly the sum of the ways from the next step (*i + 1*) and the step after that (*i + 2*). This recurrence turns the problem into a simple linear relation, but a naïve depth‑first recursion would explore the same sub‑problems exponentially many times. By remembering (memoizing) the result for each *i* the algorithm avoids recomputation and reduces the work to a single pass over the *n* positions. The pattern used here is classic **top‑down dynamic programming with memoization**.

## Approach  
1. **Initialisation** – In `climbStairs` allocate an integer array `dp` of length `n` and fill it with `-1`. The array will store the number of ways to reach the top from each index `i` (0 ≤ i < n).  
2. **Recursive entry** – Call `minstep(n, 0, dp)`. The argument `i` represents the current step count already taken; starting at `0` means “before any step”.  
3. **Base case – exact finish** – If `i == n` return `1`. We have reached the top with a valid sequence, so there is exactly one way to finish from here.  
4. **Base case – overshoot** – If `i > n` return `0`. Stepping beyond the top is illegal, contributing no valid ways.  
5. **Memoization check** – If `dp[i] != -1` the sub‑problem has been solved before; return the cached value immediately. This prevents the exponential blow‑up of the pure recursion.  
6. **Recursive decomposition** – Compute `minstep(n, i+1, dp)` (take a single step) and `minstep(n, i+2, dp)` (take a double step). Their sum is stored in `dp[i]` and returned. The loop invariant for each call is: *dp[k] holds the exact number of ways from step k to the top for all k already visited*.  
7. **Termination** – The recursion unwinds once every reachable index `i` (0 … n‑1) has been evaluated, and `climbStairs` returns the value cached at `dp[0]`, i.e., the total number of distinct ways from the ground.

## Dry Run  
**Input:** `n = 4`

| Call (i) | dp before call | Action                               | dp after call | Note                               |
|----------|----------------|--------------------------------------|---------------|------------------------------------|
| 0        | [-1,-1,-1,-1]  | recurse to i=1 and i=2              | (filled later) | start from ground                 |
| 1        | [-1,-1,-1,-1]  | recurse to i=2 and i=3              | (filled later) | one step taken                    |
| 2        | [-1,-1,-1,-1]  | recurse to i=3 and i=4              | (filled later) | two steps taken                   |
| 3        | [-1,-1,-1,-1]  | recurse to i=4 (→1) and i=5 (→0)    | dp[3]=1       | last step before top               |
| 4        | N/A            | i==n → return 1                     | N/A           | exact finish                       |
| 5        | N/A            | i>n → return 0                      | N/A           | overshoot                          |
| 2 (return) | [-1,-1,-1,-1] | dp[2]=dp[3]+dp[4]=1+1=2               | dp[2]=2       | ways from step 2                   |
| 3 (return) | [-1,-1,2,-1]  | dp[1]=dp[2]+dp[3]=2+1=3               | dp[1]=3       | ways from step 1                   |
| 0 (return) | [ -1,3,2,-1]  | dp[0]=dp[1]+dp[2]=3+2=5               | dp[0]=5       | total ways from ground = 5         |

The final state has `dp[0] = 5`, which is the correct answer for `n = 4`.

## Complexity  
- **Time:** **O(n)** – each index `i` (0 ≤ i < n) is evaluated once; the recursive calls advance by 1 or 2, so the total number of memoized calls is linear.  
- **Space:** **O(n)** – the `dp` array stores `n` integers; the recursion stack depth is at most `n` (worst case when always taking single steps), which is also linear. (The output integer itself is not counted.)

## Solution (Java)

```java
class Solution {
    public int minstep(int n,int i,int[] dp){
        if (i == n) return 1;
        if (i > n) return 0;
        if(dp[i] != -1){
            return dp[i];
        }

        return dp[i]=minstep(n,i+1,dp) + minstep(n,i+2,dp);
    }
    public int climbStairs(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return minstep(n,0,dp);
    }
}
```

---

**Runtime** 0 ms (beats 100.0%) · **Memory** 41.6 MB (beats 76.0%)

<sub>Synced by AILeetHub on 2026-11-10.</sub>
