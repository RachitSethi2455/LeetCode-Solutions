# 3. Longest Substring Without Repeating Characters

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

`Hash Table` · `String` · `Sliding Window`

## Intuition  
The key observation is that a substring without repeating characters can be maintained as a contiguous window whose left and right boundaries move only forward. While expanding the right boundary, the window invariant “all characters between `left` and `right` are distinct” holds; when a duplicate appears, moving `left` forward until the duplicate leaves restores the invariant. A naïve solution would examine every possible start index and scan forward, costing O(n²) time and requiring no extra structure. By keeping a `HashSet` of the characters currently inside the window we can detect a conflict in O(1) and adjust `left` on the fly, eliminating the extra pass. This is the classic **two‑pointer sliding window** pattern.

## Approach  
1. Initialise `max = 0`, `left = 0`, and an empty `HashSet<Character> seen`.  
2. Iterate `right` from 0 up to `s.length()‑1` (`right < s.length()`).  
   * **Loop invariant:** `seen` contains exactly the characters in `s[left … right‑1]`, and they are all distinct.  
3. While `seen` already contains `s.charAt(right)` (i.e., the new character would break the invariant):  
   * Remove `s.charAt(left)` from `seen`.  
   * Increment `left`.  
   * This shrinks the window from the left until the duplicate is expelled, re‑establishing the invariant.  
4. Add the current character `s.charAt(right)` to `seen`.  
5. Update `max` with `Math.max(max, right - left + 1)`, the length of the current valid window.  
6. After the `for` loop finishes, return `max`.  

Edge‑case handling:  
* If `s` is empty, the `for` loop never executes and `max` stays 0, which is correct.  
* A single‑character string yields `max = 1` because the window expands once and never contracts.  
* The `while` condition uses `contains` (not `==`) and the inner removal uses `left` before incrementing, guaranteeing that the character causing the conflict is removed exactly once per iteration.  

## Dry Run  

**Input:** `s = "abca"`  

| right | left | s[right] | seen (after updates) | max | note |
|------|------|----------|----------------------|-----|------|
| 0    | 0    | a        | {a}                  | 1   | window `[0,0]` |
| 1    | 0    | b        | {a,b}                | 2   | window `[0,1]` |
| 2    | 0    | c        | {a,b,c}              | 3   | window `[0,2]` |
| 3    | 0    | a        | duplicate → enter while: remove s[0]=a, left→1 → seen {b,c} | 3   | after while, add a → {b,c,a}, window `[1,3]` |

The loop ends with `max = 3`, which corresponds to the substring `"abc"` (or `"bca"`). The algorithm stops because the window invariant is restored after each duplicate removal, and the longest length observed is returned.

## Complexity  
- **Time:** O(n) – each character is added to `seen` once and removed at most once; the `right` pointer scans the string once while `left` only moves forward.  
- **Space:** O(min(m, n)) – the `HashSet` stores at most the number of distinct characters in the current window, bounded by the size of the character set (≤ 256 for ASCII) or `n` for a completely unique string. The output integer does not affect the asymptotic space.

## Solution (Java)

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        int left=0;
        HashSet<Character> seen = new HashSet<>();
        for(int right =0 ; right< s.length();right++){
            while(seen.contains(s.charAt(right))){
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(s.charAt(right));
            max = Math.max(max,right-left+1);
        }
        return max;
    }
}
```

---

**Runtime** 69 ms (beats 24.2%) · **Memory** 47.1 MB (beats 99.6%)

<sub>Synced by AILeetHub on 2026-10-18.</sub>
