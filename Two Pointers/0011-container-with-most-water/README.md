# 11. Container With Most Water

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/container-with-most-water/)

`Array` · `Two Pointers` · `Greedy`

## Intuition  
The key observation is that the water level of any container is limited by the shorter of its two bounding lines, and the width shrinks whenever we move either pointer inward. After each step the pointer at the smaller height can never form a larger area with any line farther inside, because any such pair would have an equal or smaller height and a strictly reduced width. This eliminates the need for a quadratic scan or extra storage; we can settle for a single pass that constantly discards the sub‑optimal side. The pattern used is the classic **two‑pointer** greedy scan.

## Approach  
1. **Initialize pointers** `left = 0` and `right = height.length‑1`. Set `max = 0`.  
2. **Loop while `left < right`** – the invariant is that all pairs outside the current window have already been evaluated, and the current window `[left, right]` contains the only candidates not yet considered.  
3. **Compute current area**:  
   * If `height[left] < height[right]`, `area = height[left] * (right‑left)`.  
   * Otherwise, `area = height[right] * (right‑left)`.  
   The multiplication uses the shorter side because it caps the water level.  
4. **Update the best answer** with `max = Math.max(max, area)`.  
5. **Move the pointer at the shorter side**:  
   * When `height[left] < height[right]`, execute `left++`.  
   * Otherwise, execute `right--`.  
   This choice preserves the invariant that any future container must involve a line at least as tall as the one we just discarded; otherwise the area could not improve.  
6. **Terminate** when `left` meets `right`; all possible pairs have been examined.  
7. **Return** `max` as the maximal water volume.

Edge cases are handled implicitly: an array of length 2 enters the loop once, computes the only possible area, and exits; an empty or single‑element array never reaches the loop (the problem guarantees `n ≥ 2`). The comparison uses `<` rather than `<=` so that when heights are equal we arbitrarily move the right pointer, which is safe because both sides are symmetric.

## Dry Run  

**Input:** `height = [1,8,6,2,5,4,8,3,7]`

| step | left | right | height[left] | height[right] | area | max | note |
|------|------|-------|--------------|---------------|------|-----|------|
| 1    | 0    | 8     | 1            | 7             | 1·8=8 | 8   | `height[left] < height[right]` → `left++` |
| 2    | 1    | 8     | 8            | 7             | 7·7=49| 49  | `height[left] ≥ height[right]` → `right--` |
| 3    | 1    | 7     | 8            | 3             | 3·6=18| 49  | `height[left] ≥ height[right]` → `right--` |
| 4    | 1    | 6     | 8            | 8             | 8·5=40| 49  | `height[left] ≥ height[right]` → `right--` |
| 5    | 1    | 5     | 8            | 4             | 4·4=16| 49  | `height[left] ≥ height[right]` → `right--` |
| 6    | 1    | 4     | 8            | 5             | 5·3=15| 49  | `height[left] ≥ height[right]` → `right--` |
| 7    | 1    | 3     | 8            | 2             | 2·2=4 | 49  | `height[left] ≥ height[right]` → `right--` |
| 8    | 1    | 2     | 8            | 6             | 6·1=6 | 49  | `height[left] ≥ height[right]` → `right--` (loop ends) |

The loop ends with `max = 49`, which is the largest possible container area.

## Complexity  
- **Time:** `O(n)` – the while‑loop advances one of the two pointers each iteration, so at most `n‑1` iterations are performed.  
- **Space:** `O(1)` – only a handful of integer variables are used; the algorithm does not allocate extra arrays or recursion stacks.

## Solution (Java)

```java
class Solution {
    public int maxArea(int[] height) {
        int left =0;
        int right = height.length -1;
        int max=0;
        int area =0;
        while(left < right){
            if(height[left]<height[right]){
                area = height[left] * (right-left);
                max=Math.max(max,area);
                left++;
            }
            else{
                area = height[right] * (right-left);
                max = Math.max(max,area);
                right--;
            }
        }
        return max;
    }
}
```

---

**Runtime** 4 ms (beats 95.0%) · **Memory** 77.1 MB (beats 78.2%)

<sub>Synced by AILeetHub on 2026-10-23.</sub>
