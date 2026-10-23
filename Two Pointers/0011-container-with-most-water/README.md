# 11. Container With Most Water

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/container-with-most-water/)

`Array` · `Two Pointers` · `Greedy`

## Intuition  
When the two pointers are at positions `left` and `right`, the water they can hold is limited by the **shorter** of the two lines, because the taller line cannot raise the water level above the shorter one. The width shrinks by one each time we move a pointer inward. Therefore, discarding the taller line can never create a larger area: any container that uses the taller line must also use the shorter line’s height, and a smaller width would only reduce the area. This insight lets us avoid trying every pair (which would be O(n²)) and instead eliminate one candidate per iteration, yielding a linear‑time greedy scan. The pattern is the classic **two‑pointer** technique.

## Approach  
1. **Initialize** `left = 0`, `right = height.length‑1`, `maxarea = 0`.  
2. **Loop while** `left < right`.  
   - **Invariant:** `maxarea` stores the greatest area seen among all pairs examined so far; the segment `[left, right]` is the only unexplored region.  
3. **Compare heights** `height[left]` and `height[right]`.  
   - If `height[left] < height[right]`  
     * Compute `area = height[left] * (right‑left)`.  
     * Update `maxarea = Math.max(maxarea, area)`.  
     * Advance the left pointer with `left++`.  
   - Else (including equality)  
     * Compute `area = height[right] * (right‑left)`.  
     * Update `maxarea` similarly.  
     * Decrease the right pointer with `right--`.  
4. **Terminate** when `left == right`; all possible containers have been considered.  
5. **Return** `maxarea`.  

**Edge handling:**  
- For an array of length 2 the loop runs once and returns the only possible area.  
- Duplicate heights are fine; the `else` branch treats equality as moving the right pointer, a consistent convention that still respects the invariant.  
- No overflow concerns because `height[i] ≤ 10⁴` and `right‑left ≤ 10⁵`, so the product fits in a 32‑bit signed int.

## Dry Run  

Input: `height = [1,8,6,2,5,4,8,3,7]`

| iter | left | right | height[left] | height[right] | area | maxarea | note |
|------|------|-------|--------------|---------------|------|---------|------|
| 1 | 0 | 8 | 1 | 7 | 1 × 8 = 8 | 8 | `height[left] < height[right]` → `left++` |
| 2 | 1 | 8 | 8 | 7 | 7 × 7 = 49 | 49 | `height[left] ≥ height[right]` → `right--` |
| 3 | 1 | 7 | 8 | 3 | 3 × 6 = 18 | 49 | `height[left] ≥ height[right]` → `right--` |
| 4 | 1 | 6 | 8 | 8 | 8 × 5 = 40 | 49 | `height[left] ≥ height[right]` → `right--` |
| 5 | 1 | 5 | 8 | 4 | 4 × 4 = 16 | 49 | `height[left] ≥ height[right]` → `right--` |
| 6 | 1 | 4 | 8 | 5 | 5 × 3 = 15 | 49 | `height[left] ≥ height[right]` → `right--` |
| 7 | 1 | 3 | 8 | 2 | 2 × 2 = 4  | 49 | `height[left] ≥ height[right]` → `right--` |
| 8 | 1 | 2 | 8 | 6 | 6 × 1 = 6  | 49 | `height[left] ≥ height[right]` → `right--` |

Loop ends when `left == right`. The final `maxarea` is **49**, which is the maximum water container.

## Complexity  
- **Time:** **O(n)** – each iteration moves either `left` or `right` inward, so the loop executes at most `n‑1` times.  
- **Space:** **O(1)** – only a handful of integer variables are used; the input array is not duplicated.

## Solution (Java)

```java
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxarea = 0;
        int area = 0;
        while(left < right){
            if(height[left] < height[right]){
                area = height[left] *(right-left);
                maxarea = Math.max(maxarea,area);
                left++;
            }
            else{
                area = height[right] *(right-left);
                maxarea = Math.max(maxarea,area);
                right--;
            }
        }
        return maxarea;
    }
}
```

---

**Runtime** 4 ms (beats 95.0%) · **Memory** 77.3 MB (beats 63.1%)

<sub>Synced by AILeetHub on 2026-07-10.</sub>
