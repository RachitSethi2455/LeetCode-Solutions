# 3. Longest Substring Without Repeating Characters

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

`Hash Table` · `String` · `Sliding Window`

## Intuition  
The key observation is that a substring without repeating characters can be maintained as a sliding window: as the right pointer expands, any character that already appears inside the window forces the left pointer to move forward until the duplicate disappears. This invariant—*the window `[left, right]` always contains unique characters*—eliminates the need for a second pass, a hash‑map of last indices, or any sorting. The pattern used is the classic **two‑pointer sliding window**.

## Approach  
1. **Initialisation** – Create an empty `HashSet<Character> seen`. Set `left = 0` and `maxLen = 0`.  
2. **Expand right** – Iterate `right` from `0` to `s.length()‑1`.  
   *Loop invariant*: before each iteration, `seen` holds exactly the characters in the current window `[left, right‑1]`, and all are distinct.  
3. **Handle duplicates** – While `seen.contains(s.charAt(right))` is true:  
   - Remove `s.charAt(left)` from `seen`.  
   - Increment `left`.  
   *Exit condition*: the duplicate character at `right` is no longer present in the window, restoring the invariant.  
   *Pitfall*: forgetting to remove the leftmost character would leave the set polluted and cause an infinite loop on repeated characters.  
4. **Add new character** – After the inner loop, insert `s.charAt(right)` into `seen`. The window now again satisfies the distinct‑character invariant.  
5. **Update answer** – Compute the current window length as `right - left + 1` and assign `maxLen = Math.max(maxLen, …)`.  
6. **Return** – After the outer loop finishes, `maxLen` holds the length of the longest valid substring.

Edge cases are handled automatically: an empty string never enters the loop, leaving `maxLen = 0`; a single‑character string yields `maxLen = 1` because the inner `while` never executes.

## Dry Run  

Input: `s = "abca"`

| Iteration | right | left | seen (after updates) | maxLen | Change |
|-----------|-------|------|----------------------|--------|--------|
| 1 | 0 (`a`) | 0 | {a} | 1 | added `a` |
| 2 | 1 (`b`) | 0 | {a,b} | 2 | added `b` |
| 3 | 2 (`c`) | 0 | {a,b,c} | 3 | added `c` |
| 4 | 3 (`a`) | 0 | {a,b,c} → remove `a` (left=0) → left=1, seen={b,c} → add `a` → {b,c,a} | 3 | duplicate `a` removed from left, window slides to `[1,3]` |

The loop ends; the final `maxLen` is **3**, corresponding to substrings `"abc"` or `"bca"`.

## Complexity  
- **Time:** O(n) – the outer `for` runs `n` times and the inner `while` advances `left` at most `n` total steps, so each character is added and removed at most once.  
- **Space:** O(min(n, |Σ|)) – the `HashSet` stores at most one copy of each distinct character in the current window, bounded by the size of the input or the character set. (Output is a single integer, not counted.)

## Solution (Java)

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            while (seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
```

---

**Runtime** 7 ms (beats 92.7%) · **Memory** 46.6 MB (beats 99.9%)

<sub>Synced by AILeetHub on 2026-04-08.</sub>
