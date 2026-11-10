# 3693. Climbing Stairs II

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/climbing-stairs-ii/)

`Array` · `Dynamic Programming`

## Intuition  
The key observation is that the optimal cost from any step `i` depends only on the optimal costs of the next three reachable steps (`i+1`, `i+2`, `i+3`). Therefore we can treat the problem as a shortest‑path on a directed acyclic graph where each node’s value is the minimum total cost to reach the top from that node. A naïve breadth‑first search would explore all paths and cost `O(3^n)`. By memoizing the result for each index we eliminate repeated sub‑computations, turning the exponential search into a linear one. This is the classic **top‑down dynamic programming with memoization** pattern.

## Approach  
1. **Entry point** – `climbStairs` creates an integer array `dp` of size `n+1` (all zeros) and calls `mincost(n, costs, 0, dp)`.  
2. **Base case** – Inside `mincost`, if `i == n` we have already reached the final step, so return `0`.  
3. **Memo check** – If `dp[i] != 0` the minimum cost from `i` has been computed earlier; return `dp[i]`. (`dp` is initialized with zeros, and a real cost is never zero because `costs[i] ≥ 1` and jump squares are ≥ 1.)  
4. **Initialize candidates** – Set `c1`, `c2`, `c3` to `Integer.MAX_VALUE`. These hold the total cost for the three possible jumps.  
5. **Jump to `i+1`** – If `i+1 ≤ n`, compute `c1 = costs[i] + 1 + mincost(n, costs, i+1, dp)`. The `+1` is `(i+1‑i)²`.  
6. **Jump to `i+2`** – If `i+2 ≤ n`, compute `c2 = costs[i+1] + 4 + mincost(n, costs, i+2, dp)`. The `+4` is `(i+2‑i)²`.  
7. **Jump to `i+3`** – If `i+3 ≤ n`, compute `c3 = costs[i+2] + 9 + mincost(n, costs, i+3, dp)`. The `+9` is `(i+3‑i)²`.  
8. **Select minimum** – Store `dp[i] = Math.min(c1, Math.min(c2, c3))` and return it. This guarantees that every recursive call returns the cheapest way to finish from its start index.  
9. **Final answer** – The initial call returns the minimum total cost from step 0, which is the required result.

Important edge handling: the checks `i+1 <= n`, `i+2 <= n`, `i+3 <= n` prevent out‑of‑bounds access when `i` is near the top. Because the problem guarantees `n ≥ 1`, the recursion always terminates at the base case.

## Dry Run  
**Input:** `n = 4`, `costs = [5, 1, 6, 2]`  

| iteration (i) | c1 (to i+1) | c2 (to i+2) | c3 (to i+3) | dp[i] after compute | note |
|---------------|------------|------------|------------|---------------------|------|
| 0 | 5+1+mincost(1) = 6+? | 1+4+mincost(2) = 5+? | 6+9+mincost(3) = 15+? | 11 | evaluate children first |
| 1 | 1+1+mincost(2) = 2+? | 6+4+mincost(3) = 10+? | 2+9+mincost(4)=11+0 | 13 | mincost(4)=0 (base) |
| 2 | 6+1+mincost(3)=7+? | 2+4+mincost(4)=6+0 | INF | 6 | mincost(3) computed next |
| 3 | 2+1+mincost(4)=3+0 | INF | INF | 3 | base reached next step |
| 4 | – | – | – | 0 | base case |

Working back: `dp[3]=3`, `dp[2]=6`, `dp[1]=13`, `dp[0]=11`. The algorithm returns **11**, matching the optimal path `0 → 2 → 4`.

## Complexity  
- **Time:** `O(n)` – each index `i` is processed once; the recursion explores at most three edges per node, and memoization prevents revisiting.  
- **Space:** `O(n)` – the `dp` array stores one integer per step; the recursion stack depth is at most `n` but is bounded by the same linear term. (The output itself is a single integer and does not affect the asymptotic bound.)

## Solution (Java)

```java
class Solution {
    public int mincost(int n,int[] costs,int i,int[] dp){
        if(i == n ){
            return 0;
        }
        if(dp[i] !=0){
            return dp[i];
        }

        int c1 = Integer.MAX_VALUE;
        int c2 = Integer.MAX_VALUE;
        int c3 = Integer.MAX_VALUE;

        if(i+1 <=n){
            c1 = costs[i] + 1 + mincost(n,costs,i+1,dp);
        }
        if(i+2 <=n){
            c2 = costs[i+1] + 4 + mincost(n,costs,i+2,dp);
        }
        if(i+3 <=n){
            c3 = costs[i+2] + 9 + mincost(n,costs,i+3,dp);
        }

        return dp[i]=Math.min(c1,Math.min(c2,c3));
    }
    public int climbStairs(int n, int[] costs) {
        int[] dp= new int[n+1];
        return mincost(n,costs,0,dp);
    }
}
```

---

**Runtime** 48 ms (beats 20.3%) · **Memory** 133.4 MB (beats 7.8%)

<sub>Synced by AILeetHub on 2026-11-10.</sub>
