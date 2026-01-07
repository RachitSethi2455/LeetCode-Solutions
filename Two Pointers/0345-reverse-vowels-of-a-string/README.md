# 345. Reverse Vowels of a String

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/reverse-vowels-of-a-string/)

`Two Pointers` · `String`

## Approach

Accepted easy solution in java.
Relevant topics: Two Pointers, String.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        String vowel = "aeiouAEIOU";
        List<Character> vowelList = new ArrayList<>();
        for(char c : ch){
            if(vowel.indexOf(c) != -1){
                vowelList.add(c);
            }
        }
        Collections.reverse(vowelList);
        
        int idx =0;
        for(int i =0; i< ch.length ; i++){
            if (vowel.indexOf(ch[i]) != -1){
                ch[i] = vowelList.get(idx++);
            }
        }
        return new String(ch);
    }
}
```

---

**Runtime** 7 ms · **Memory** 46.5 MB

<sub>Synced by AILeetHub on 2026-01-07.</sub>
