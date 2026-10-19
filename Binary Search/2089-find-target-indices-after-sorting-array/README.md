# 2089. Find Target Indices After Sorting Array

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/find-target-indices-after-sorting-array/)

`Array` · `Binary Search` · `Sorting`

## Intuition  
After sorting, every occurrence of `target` appears in one contiguous segment because the array is in non‑decreasing order. Therefore the indices we need are simply the positions of that segment, and we can obtain them with a single left‑to‑right scan. The naïve way would be to sort and then perform a binary search for the first and last occurrence, which adds extra bookkeeping; the contiguity property lets us drop that extra pass. This solution follows the classic **sort‑then‑scan** pattern.

## Approach  
1. **Determine length** – `int n = nums.length;` gives the number of elements.  
2. **Sort in‑place** – `Arrays.sort(nums);` rearranges `nums` so that equal values are adjacent.  
3. **Prepare result container** – `List<Integer> l = new ArrayList<>();` will hold the target indices.  
4. **Linear scan** – `for (int i = 0; i < n; i++)` iterates while `i < n`.  
   * *Invariant*: before each iteration, all positions `< i` have been examined and any index where `nums[index] == target` has already been added to `l`.  
   * Inside the loop, `if (nums[i] == target) l.add(i);` records the current index when the element matches.  
   * The loop exits when `i == n`, i.e., after the last element has been processed.  
5. **Return** – `return l;` yields the collected indices, already in increasing order because `i` grew monotonically.

**Edge‑case handling**  
- The constraints guarantee `n ≥ 1`, so an empty array never reaches the loop.  
- If `n == 1`, the loop runs once and either adds `0` (when the sole element equals `target`) or adds nothing.  
- When `target` does not appear, the condition is never true and the method returns an empty list.  
- The comparison uses `==` on primitive `int`s, so no overflow concerns arise; the loop bound `i < n` (not `<=`) prevents an out‑of‑range access.

## Dry Run  

Input: `nums = [1, 2, 5, 2, 3]`, `target = 2`  

| i | nums[i] after sort | l (collected indices) | Change |
|---|-------------------|-----------------------|--------|
| 0 | 1                 | []                    | no match |
| 1 | 2                 | [1]                   | added 1 |
| 2 | 2                 | [1, 2]                | added 2 |
| 3 | 3                 | [1, 2]                | no match |
| 4 | 5                 | [1, 2]                | no match |

After the loop finishes, `l = [1, 2]`, which are exactly the positions of `target` in the sorted array.

## Complexity  
- **Time:** `O(n log n)` – `Arrays.sort` dominates with `n log n` comparisons; the subsequent linear scan adds only `O(n)`.  
- **Space:** `O(1)` extra – sorting is in‑place and the only additional storage is the output list `l`, which the problem counts as the result, not auxiliary memory.

## Solution (Java)

```java
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> l = new ArrayList<>();
        for(int i =0; i< n; i++){
            if(nums[i] == target){
                l.add(i);
            }
        }
        return l;
    }
}
```

---

**Runtime** 5 ms (beats 71.8%) · **Memory** 50 MB (beats 18.4%)

<sub>Synced by AILeetHub on 2026-10-19.</sub>
