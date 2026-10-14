# 3723. Maximize Sum of Squares of Digits

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/maximize-sum-of-squares-of-digits/)

`Math` · `Greedy`

## Intuition  
The score of a digit is its square, which grows faster than the digit itself. To maximize the total score under a fixed digit‑sum, we should concentrate as much of the sum as possible into the largest digits (9’s) and place any remainder in the next most‑significant position. This greedy choice also yields the numerically largest integer among all optimal scores because larger digits are placed earlier. A naïve solution would try every composition of `sum` into `num` parts (exponential) or sort all candidates (quadratic). The observation that “put 9’s first, then the leftover digit, then zeros” eliminates all extra work. The pattern is a classic **greedy digit construction**.

## Approach  
1. **Feasibility check** –  
   *If* `sum == 0` *or* `sum > 9 * num` → return `""`.  
   The first condition means we cannot place a non‑zero digit at the most‑significant place; the second means the required sum exceeds the maximum achievable (`9` per digit).  
2. **Initialize** – create an empty `StringBuilder s`.  
3. **Iterate over positions** (`i` from `0` to `num‑1`):  
   - **Loop invariant**: before each iteration, `sum` equals the total of the digits that still need to be placed in the remaining `num‑i` positions, and all already appended digits are the largest possible for those earlier positions.  
   - **Decision**:  
     *If* `sum >= 9` → append `'9'` (`s.append('9')`) and decrement `sum` by `9`.  
     *Else* → append the exact leftover digit (`s.append((char)('0' + sum))`) and set `sum = 0`.  
   - The `else` branch also handles the case where `sum` becomes zero before all positions are processed; subsequent iterations will keep appending `'0'` because `sum >= 9` is false and `sum` is already `0`.  
4. **Return** – after the loop, `s` contains `num` characters forming the desired integer, so `return s.toString()`.

**Edge handling**:  
- Empty or single‑digit inputs are covered by the feasibility check; a single digit with `sum ≤ 9` will be placed directly in step 3.  
- The loop uses `<=` in the feasibility test (`sum > 9 * num`) because `9 * num` is the absolute maximum sum; equality is still feasible.  
- No overflow concerns: `sum` and `num` fit in 32‑bit `int` per constraints, and we only subtract at most `9` each iteration.

## Dry Run  

Input: `num = 2, sum = 3`

| i (position) | sum before | action                               | sum after | s (partial) | note                         |
|--------------|------------|--------------------------------------|-----------|-------------|------------------------------|
| 0            | 3          | `sum < 9` → append `'3'`             | 0         | "3"         | leftover digit placed first |
| 1            | 0          | `sum < 9` → append `'0'` (char `'0'`+0) | 0         | "30"        | fill remaining slots with 0 |

Loop ends after `i = 1`. `s` equals `"30"`, which is the maximal‑score integer because the only possible scores are `5` (12/21) and `9` (30).

## Complexity  
- **Time:** `O(num)` – the single `for` loop runs exactly `num` iterations, each doing O(1) work.  
- **Space:** `O(num)` – the `StringBuilder` stores `num` characters; no additional auxiliary structures are used. (The output string itself is counted as required space.)

## Solution (Java)

```java
class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum ==0 || sum > 9* num){
            return "";
        }
        StringBuilder s = new StringBuilder();
        for(int i =0; i < num;i++){
            if(sum >= 9){
                s.append('9');
                sum -=9;
            }
            else{
                s.append((char) ('0' + sum));
                sum = 0;
            }
        }
        return s.toString();
    }
}
```

---

**Runtime** 61 ms (beats 59.8%) · **Memory** 47.7 MB (beats 82.9%)

<sub>Synced by AILeetHub on 2026-10-14.</sub>
