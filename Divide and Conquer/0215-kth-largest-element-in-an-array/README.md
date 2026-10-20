# 215. Kth Largest Element in an Array

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/kth-largest-element-in-an-array/)

`Array` · `Divide and Conquer` · `Sorting` · `Heap (Priority Queue)` · `Quickselect`

## Intuition  
The key observation is that a max‑heap always keeps the largest element at its root, and removing the root repeatedly yields the next largest values in order. If we insert every array element into such a heap, the element at the root after `k‑1` removals must be the k‑th largest. A naïve approach would sort the whole array ( O(n log n) ) or scan the array `k` times while tracking the maximum ( O(k·n) ). The heap insight eliminates the need for a full sort and avoids repeated linear scans, giving a single‑pass construction plus at most `k‑1` extra extractions. This pattern is the classic **max‑heap (priority queue)** technique for selection problems.

## Approach  
1. **Create a max‑heap** `pq` using `new PriorityQueue<>(Collections.reverseOrder())`.  
2. **Populate the heap** – iterate `i` from `0` to `nums.length‑1` (`i < nums.length`). In each iteration `pq.offer(nums[i])` inserts the current element while maintaining the heap property.  
   *Invariant*: after processing index `i`, the heap contains exactly the first `i+1` elements of `nums`, and its root is the largest among them.  
3. **Extract the top `k‑1` elements** – while `k > 1` execute `pq.poll()` and then decrement `k`.  
   *Exit condition*: the loop stops when `k == 1`.  
   *Invariant*: at the start of each iteration the heap’s root is the current largest among the remaining elements, and exactly `originalK‑k` largest elements have already been removed.  
4. **Return the answer** – `pq.peek()` now returns the root, which is the k‑th largest element.

**Edge handling**:  
- If `nums` is empty the problem constraints forbid it, so the code does not guard against it.  
- For `k == 1` the while‑loop is skipped and the peek of the full heap yields the maximum directly.  
- The heap size never exceeds `nums.length`, so no overflow concerns arise.  

## Dry Run  
Input: `nums = [3,2,1,5,6,4]`, `k = 2`

| Step | i | pq (heap order) | k | Action | Note |
|------|---|-----------------|---|--------|------|
| 0 (init) | – | [] | 2 | – | start |
| 1 | 0 | [3] | 2 | offer(3) | heap of first element |
| 2 | 1 | [3,2] | 2 | offer(2) | 3 remains root |
| 3 | 2 | [3,2,1] | 2 | offer(1) | 3 still root |
| 4 | 3 | [5,3,1,2] | 2 | offer(5) | 5 becomes new root |
| 5 | 4 | [6,5,1,2,3] | 2 | offer(6) | 6 is root |
| 6 | 5 | [6,5,1,2,3,4] | 2 | offer(4) | heap built, i loop ends |
| 7 | – | [6,5,1,2,3,4] | 2 | poll() → removes 6, k-- → 1 | one largest removed |
| 8 | – | [5,4,1,2,3] | 1 | peek() → 5 | loop ends, answer = 5 |

After the `while` loop finishes, `pq.peek()` returns `5`, which is the 2‑nd largest element.

## Complexity  
- **Time:** O(n + k log n) – building the heap inserts `n` elements (`O(log n)` each) and the `k‑1` polls each cost `O(log n)`.  
- **Space:** O(n) – the heap stores all `n` input values; extra variables use O(1) space.

## Solution (Java)

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i =0; i < nums.length; i++){
            pq.offer(nums[i]);
        }
        while(k>1){
            pq.poll();
            k--;
        }
        return pq.peek();
    }
}
```

---

**Runtime** 155 ms (beats 8.0%) · **Memory** 72.3 MB (beats 99.5%)

<sub>Synced by AILeetHub on 2026-10-20.</sub>
