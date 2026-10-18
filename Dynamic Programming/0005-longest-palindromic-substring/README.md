# 5. Longest Palindromic Substring

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/longest-palindromic-substring/)

`Two Pointers` · `String` · `Dynamic Programming` · `Manacher`

## Intuition  
A palindrome reads the same forward and backward, so any palindrome can be grown outward from its middle while the characters on both sides match. If we treat every character (for odd‑length palindromes) and every gap between two characters (for even‑length palindromes) as a potential centre, expanding from that centre discovers the longest palindrome that uses it. The naïve way would be to examine every substring (O(n²) substrings) and test each for palindromehood, which adds another O(n) check per substring. By expanding from the centre we eliminate the inner O(n) verification and obtain the answer in a single linear scan of centres.

## Approach  
1. **Handle trivial input.** If `s` is `null` or its length is 0, return the empty string immediately.  
2. **Iterate over every possible centre.**  
   - Loop variable `i` runs from 0 to `s.length()‑1`.  
   - **Invariant:** before each iteration, `start` and `end` delimit the longest palindrome found among all centres `< i`.  
3. **Expand for odd length.** Call `expandFromCenter(s, i, i)`.  
   - The helper moves `left` leftward and `right` rightward while `s.charAt(left) == s.charAt(right)`.  
   - **Exit condition:** `left < 0`, `right >= s.length()`, or a mismatch.  
   - **Returned length** is `right - left - 1`, i.e., the number of characters that remained matched.  
4. **Expand for even length.** Call `expandFromCenter(s, i, i+1)` using the gap after `i` as the centre. The same invariant and exit condition apply.  
5. **Select the longer of the two expansions.** `len = Math.max(len1, len2)`.  
6. **Update global bounds if a longer palindrome is found.**  
   - Condition `len > end - start` guarantees we only replace when the new palindrome strictly exceeds the previous best.  
   - New `start = i - (len‑1)/2` and `end = i + len/2` compute the leftmost and rightmost indices of the palindrome centred at `i`. The integer division correctly handles both odd and even lengths.  
7. **After the loop, extract the answer.** `s.substring(start, end+1)` returns the characters between the final bounds, inclusive.

Edge cases covered: a single‑character string yields `len = 1` on the first iteration; even‑length strings are handled by the second expansion; the `<=` checks inside `expandFromCenter` prevent out‑of‑bounds access when the centre lies at the string ends.

## Dry Run  

**Input:** `s = "babad"`  

| i | left/right after odd expand | len1 | left/right after even expand | len2 | start | end | note |
|---|-----------------------------|------|------------------------------|------|-------|-----|------|
| 0 | left=-1, right=1 (stop) → len1=1 | 1 | left=0, right=1 (b≠a) → len2=0 | 0 | 0 | 0 | centre at ‘b’, palindrome “b” |
| 1 | left=0, right=2 (b==b) → left=-1, right=3 → len1=3 | 3 | left=1, right=2 (a≠b) → len2=0 | 0 | 0 | 2 | odd expansion gives “bab”, update start=0, end=2 |
| 2 | left=1, right=3 (a==a) → left=0, right=4 (b≠d) → len1=3 | 3 | left=2, right=3 (b≠a) → len2=0 | 0 | 0 | 2 | palindrome “aba” same length, no update |
| 3 | left=2, right=4 (b≠d) → len1=1 | 1 | left=3, right=4 (a≠d) → len2=0 | 0 | 0 | 2 | no longer palindrome |
| 4 | left=3, right=5 (out) → len1=1 | 1 | left=4, right=5 (out) → len2=0 | 0 | 0 | 2 | loop ends |

Final `start=0`, `end=2`; `s.substring(0,3)` yields **"bab"**, the longest palindromic substring.

## Complexity  
- **Time:** O(n) · O(1) = O(n) – the outer loop runs `n` times and each call to `expandFromCenter` moves the two pointers at most `n` steps total across all centres, so the combined work is linear.  
- **Space:** O(1) – only a handful of integer variables (`start`, `end`, `i`, `left`, `right`, `len`) are used; the output string shares the original character array.

## Solution (Java)

```java
class Solution {
    public String longestPalindrome(String s) {
         if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i);     // odd length
            int len2 = expandFromCenter(s, i, i + 1); // even length
            int len = Math.max(len1, len2);
            
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    private int expandFromCenter(String s, int left, int right) {
        // Expand outward while characters match
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return length of palindrome found
        return right - left - 1;
    }
}
```

---

**Runtime** 14 ms (beats 93.3%) · **Memory** 43.6 MB (beats 69.6%)

<sub>Synced by AILeetHub on 2026-04-21.</sub>
