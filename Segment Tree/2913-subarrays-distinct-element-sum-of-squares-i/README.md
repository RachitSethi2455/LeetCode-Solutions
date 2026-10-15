# 2913. Subarrays Distinct Element Sum of Squares I

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i/)

`Array` · `Hash Table` · `Binary Indexed Tree` · `Segment Tree`

## Intuition  
The distinct count of a subarray grows only when a previously unseen value appears; otherwise it stays the same. If we enumerate every possible left endpoint `i` and then extend the right endpoint `j` one step at a time, we can maintain the current set of seen values in `O(1)` amortized per extension. A naïve solution that recomputes the distinct count from scratch for each `(i, j)` pair would be `O(n³)`. By keeping a `HashSet` that is updated incrementally, we eliminate the inner recomputation and achieve `O(n²)` overall. This is the classic “enumerate all subarrays with a sliding set” pattern.

## Approach  
1. **Initialize answer** `ans = 0`.  
2. **Outer loop** `for (int i = 0; i < nums.size(); i++)`  
   - *Exit condition*: `i` reaches `nums.size()`.  
   - *Invariant*: before the inner loop starts, no elements from index `i` onward have been added to the set `m`.  
3. **Create a fresh set** `HashSet<Integer> m = new HashSet<>();` for each new left endpoint. This guarantees that subarrays sharing the same `i` do not interfere with each other.  
4. **Inner loop** `for (int j = i; j < nums.size(); j++)`  
   - *Exit condition*: `j` reaches the end of the array.  
   - *Invariant*: `m` contains exactly the distinct values in `nums[i..j]`.  
   - **Update set** `m.add(nums.get(j));` – adding a duplicate has no effect, preserving the invariant.  
   - **Compute distinct count** `int distinct = m.size();`.  
   - **Accumulate contribution** `ans += distinct * distinct;`.  
5. After the inner loop finishes, all subarrays starting at `i` have contributed their squared distinct counts to `ans`.  
6. Return `ans` after both loops complete.  

*Edge‑case handling*:  
- When `nums` has length 1, the outer loop runs once, the inner loop runs once, and `ans` becomes `1`.  
- Duplicate values are safely ignored by the set, so even‑length vs odd‑length subarrays need no special treatment.  
- The check `j < nums.size()` (strict `<`) is required because `j` is an index; using `<=` would cause an `IndexOutOfBoundsException`.

## Dry Run  
Input: `nums = [1, 2, 1]`

| i | j | m (contents) | distinct = m.size() | ans (after update) | note |
|---|---|--------------|----------------------|--------------------|------|
| 0 | 0 | {1}          | 1                    | 1                  | first subarray `[1]` |
| 0 | 1 | {1,2}        | 2                    | 5 (=1+4)           | subarray `[1,2]` |
| 0 | 2 | {1,2}        | 2                    | 9 (=5+4)           | subarray `[1,2,1]` |
| 1 | 1 | {2}          | 1                    | 10 (=9+1)          | new left endpoint, `[2]` |
| 1 | 2 | {2,1}        | 2                    | 14 (=10+4)         | subarray `[2,1]` |
| 2 | 2 | {1}          | 1                    | 15 (=14+1)         | last subarray `[1]` |

Final `ans = 15`, which matches the required sum of squares.

## Complexity  
- **Time:** `O(n²)` – the outer loop runs `n` times and the inner loop runs at most `n‑i` times; each iteration performs only constant‑time `HashSet` operations.  
- **Space:** `O(k)` where `k` ≤ `n` – the set `m` holds at most the distinct elements of the current subarray, and a new set is created for each `i`. The output integer does not count toward extra space.

## Solution (Java)

```java
class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans=0;
        for(int i =0; i < nums.size() ; i++){
            HashSet<Integer> m = new HashSet<>();
            for(int j =i; j< nums.size() ; j++){
                m.add(nums.get(j));

                int distinct = m.size();
                ans += distinct * distinct;
            }
        }
        return ans;
    }
}
```

---

**Runtime** 9 ms (beats 45.2%) · **Memory** 46.5 MB (beats 79.5%)

<sub>Synced by AILeetHub on 2026-10-15.</sub>
