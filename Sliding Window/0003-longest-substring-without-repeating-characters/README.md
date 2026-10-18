# 3. Longest Substring Without Repeating Characters

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

`Hash Table` · `String` · `Sliding Window`

## Intuition  
The key observation is that a substring without repeating characters can be represented by a sliding window whose left and right borders move only forward. When the right border encounters a character already inside the window, the left border must advance just enough to discard the earlier occurrence, guaranteeing that the window is always “clean”. A naïve solution would recompute the set of characters for every possible substring, costing O(n²) time. By maintaining a hash set of the current window’s characters and adjusting the borders in‑place, we eliminate the extra pass and any need for sorting or recursion. This is the classic two‑pointer (sliding‑window) pattern.

## Approach  
1. **Initialize** an empty `HashSet<Character> seen`, `left = 0`, and `maxLen = 0`.  
2. **Iterate** `right` from `0` to `s.length()‑1`.  
   - **Loop invariant**: before each iteration, `seen` contains exactly the characters in `s[left … right‑1]`, and this segment has no duplicates.  
3. **While** `seen` already contains `s.charAt(right)`:  
   - Remove `s.charAt(left)` from `seen`.  
   - Increment `left`.  
   - **Exit condition**: the duplicate character has been removed, restoring the invariant.  
4. **Add** `s.charAt(right)` to `seen`. The window now spans `left … right` and is duplicate‑free.  
5. **Update** `maxLen` with `Math.max(maxLen, right - left + 1)`.  
6. After the `for` loop finishes, **return** `maxLen`.  

Edge‑case handling:  
- If `s` is empty, the loop never runs and `maxLen` stays `0`.  
- For a single‑character string, the inner `while` never triggers, and `maxLen` becomes `1`.  
- The `while` uses `contains` and removes from the left until the offending character is gone; this works for both even and odd length strings because the window size is recomputed each step.  

## Dry Run  
**Input:** `s = "abca"`  

| right | left | seen (after iteration) | maxLen | note |
|------|------|------------------------|--------|------|
| 0    | 0    | {a}                    | 1      | added ‘a’ |
| 1    | 0    | {a,b}                  | 2      | added ‘b’ |
| 2    | 0    | {a,b,c}                | 3      | added ‘c’ |
| 3    | 0    | {a,b,c}                | 3      | ‘a’ already in set → remove s[0]=‘a’, left=1; set becomes {b,c} |
| 3    | 1    | {b,c,a}                | 3      | add ‘a’, window “bca”, length 3 |

The loop ends with `maxLen = 3`, which corresponds to the longest substring without repeats (“abc” or “bca”).

## Complexity  
- **Time:** O(n) – each character is added to `seen` once and removed at most once; the `right` pointer moves n times and the `left` pointer moves at most n times.  
- **Space:** O(min(m, n)) – the hash set stores at most the number of distinct characters in the current window, bounded by the size of the character set (m) or the string length (n). The output integer does not affect this bound.

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
