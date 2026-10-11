# 2778. Sum of Squares of Special Elements 

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/sum-of-squares-of-special-elements/)

`Array` · `Enumeration`

## Intuition  
The only elements that matter are those whose 1‑based positions are divisors of the array length `n`. Because the array is already indexed sequentially, we can discover every special element simply by scanning the indices once and checking the arithmetic condition `n % i == 0`. A naïve alternative would be to first compute the full set of divisors of `n` (which itself needs a loop) and then look up each divisor, or to use extra containers such as a hash set. The single‑pass divisor test eliminates any extra pass or auxiliary storage while preserving correctness.

## Approach  
1. **Determine length** – `int n = nums.length;` gives the divisor target.  
2. **Initialize accumulator** – `int sum = 0;` will hold the running total of squares.  
3. **Iterate over 1‑based indices** – `for (int i = 1; i <= n; i++)` loops exactly `n` times; the loop exits when `i` exceeds `n`.  
   - *Invariant*: before each iteration, `sum` equals the sum of squares of all special elements whose indices are `< i`.  
4. **Divisibility test** – Inside the loop, `if (n % i == 0)` checks whether the current index is a divisor of `n`.  
   - The condition uses `<=` in the loop bound because the last index `i = n` must also be examined; `n % n` is always `0`, guaranteeing the final element is considered.  
5. **Accumulate square** – When the test succeeds, the element at the 0‑based position `i‑1` is accessed (`nums[i‑1]`) and its square is added: `sum += nums[i‑1] * nums[i‑1];`.  
   - The `i‑1` offset correctly maps the required 1‑based index to Java’s 0‑based array.  
6. **Return result** – After the loop finishes, `return sum;` yields the required total.  

Edge cases are handled automatically: for `n = 1` the loop runs once, the single element is a divisor of itself, and its square is returned. No overflow concerns arise because `nums[i] ≤ 50`, so each square ≤ 2500 and the maximum possible sum ≤ 125 000, well within `int`.

## Dry Run  

**Input**: `nums = [2, 7, 1, 19, 18, 3]` ( `n = 6` )

| i | n % i | add? | sum after iteration | note |
|---|-------|------|---------------------|------|
| 1 | 0 | yes | 2·2 = 4 | 1 divides 6, add `nums[0]²` |
| 2 | 0 | yes | 4 + 7·7 = 53 | 2 divides 6, add `nums[1]²` |
| 3 | 0 | yes | 53 + 1·1 = 54 | 3 divides 6, add `nums[2]²` |
| 4 | 2 | no  | 54 | 4 does not divide 6 |
| 5 | 1 | no  | 54 | 5 does not divide 6 |
| 6 | 0 | yes | 54 + 3·3 = 63 | 6 divides 6, add `nums[5]²` |

The loop terminates after `i = 6`. The final `sum` is **63**, which matches the required answer because it aggregates the squares of exactly the special elements.

## Complexity  
- **Time:** `O(n)` – the single `for` loop visits each index once; the divisibility check is constant time.  
- **Space:** `O(1)` – only a few primitive variables (`sum`, `n`, `i`) are used, independent of input size. The output integer is not counted toward extra space.

## Solution (Java)

```java
class Solution {
    public int sumOfSquares(int[] nums) {
        int sum =0;
        int n = nums.length;
        for(int i =1; i <=n; i++){
            if(n % i == 0){
                sum+= nums[i-1]*nums[i-1];
            }
        }
        return sum;
    }
}
```

---

**Runtime** 1 ms (beats 100.0%) · **Memory** 46.6 MB (beats 14.7%)

<sub>Synced by AILeetHub on 2026-10-11.</sub>
