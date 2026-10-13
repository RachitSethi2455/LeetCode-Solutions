# 3727. Maximum Alternating Sum of Squares

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/maximum-alternating-sum-of-squares/)

`Array` · `Greedy` · `Sorting`

## Intuition  
The alternating score is maximized when the largest squared values occupy the “plus” positions (indices 0, 2, 4, …) and the smallest squared values occupy the “minus” positions (indices 1, 3, 5, …).  If we sort all squares in non‑decreasing order, the first ⌊n/2⌋ elements are the smallest and must be subtracted, while the remaining ⌈n/2⌉ elements are the largest and must be added.  A naïve solution would try every permutation (O(n!)) or use a DP that is O(n²); the sorting insight eliminates the combinatorial explosion and yields a linear‑time greedy pass after sorting.

## Approach  
1. **Square each element** – iterate `i` from 0 to `n‑1`, compute `arr[i] = (long) nums[i] * nums[i]`.  
   *Invariant*: after processing index `i‑1`, `arr[0…i‑1]` holds the exact squares of the corresponding input values.  
2. **Sort the squares** – `Arrays.sort(arr)`.  
   *Invariant*: after sorting, `arr` is non‑decreasing, so `arr[0] ≤ arr[1] ≤ … ≤ arr[n‑1]`.  
3. **Subtract the small half** – loop `i` from 0 while `i < n/2`; each iteration does `ans -= arr[i]`.  
   *Exit condition*: `i == n/2`.  
   *Invariant*: after iteration `i‑1`, `ans` equals the negative sum of the first `i` smallest squares.  
   *Edge handling*: when `n` is 1, `n/2` is 0, so this loop is skipped, correctly leaving no subtraction.  
4. **Add the large half** – loop `i` from `n/2` while `i < n`; each iteration does `ans += arr[i]`.  
   *Exit condition*: `i == n`.  
   *Invariant*: after iteration `i‑1`, `ans` equals (negative sum of the first `n/2` squares) + (positive sum of squares from `n/2` up to `i‑1`).  
   *Odd length*: the extra element at index `n/2` belongs to the “plus” side, matching the required pattern.  
5. **Return `ans`** – the final value is the maximum alternating sum of squares.

## Dry Run  
Input: `nums = [1, 2, 3]`

| Step | `i` (square loop) | `arr` after squaring | `i` (subtract loop) | `ans` after subtraction | `i` (add loop) | `ans` after addition | Note |
|------|-------------------|----------------------|----------------------|--------------------------|----------------|----------------------|------|
| 1    | –                 | `[1,4,9]` (sorted)   | –                    | 0                        | –              | 0                    | squares computed & sorted |
| 2    | –                 | –                    | 0 (`i < 1`)          | `ans = -1`               | –              | –                    | subtract smallest |
| 3    | –                 | –                    | –                    | –                        | 1 (`i < 3`)    | `ans = -1 + 4 = 3`   | add first large |
| 4    | –                 | –                    | –                    | –                        | 2 (`i < 3`)    | `ans = 3 + 9 = 12`   | add second large |
| 5    | –                 | –                    | –                    | –                        | 3 (`i == 3`)   | –                    | loop ends |

Final `ans = 12`, which matches the optimal arrangement `[2,1,3]`.

## Complexity  
- **Time:** `O(n log n)` – sorting dominates; the two linear scans each run `n/2` or `n‑n/2` iterations.  
- **Space:** `O(n)` – the auxiliary `long[] arr` stores the squares; the algorithm uses only constant extra variables besides this output array.

## Solution (Java)

```java
class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(arr);

        long ans = 0;

        for (int i = 0; i < n / 2; i++) {
            ans -= arr[i];
        }

        for (int i = n / 2; i < n; i++) {
            ans += arr[i];
        }

        return ans;
    }
}
```

---

**Runtime** 32 ms (beats 84.5%) · **Memory** 135.2 MB (beats 44.4%)

<sub>Synced by AILeetHub on 2026-10-13.</sub>
