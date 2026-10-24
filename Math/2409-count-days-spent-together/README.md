# 2409. Count Days Spent Together

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/count-days-spent-together/)

`Math` · `String`

## Intuition  
The only thing that matters for overlapping stays is each person’s position on the calendar line, i.e., the day‑of‑year number. If we map every “MM‑DD” string to an integer representing how many days have passed since January 1, the problem reduces to finding the intersection length of two closed intervals. A naïve approach would compare every calendar day or store all dates in a set, costing O(365) time or extra memory. The insight that a single linear conversion plus two constant‑time interval operations suffice eliminates both the extra pass and any auxiliary containers. This is a classic **interval‑intersection** pattern.

## Approach  
1. **Convert each date to a day‑of‑year integer**  
   - Call `convert` on `arriveAlice`, `leaveAlice`, `arriveBob`, `leaveBob`.  
   - Inside `convert`, parse month and day, then accumulate the days of all preceding months using the `days` array. After the loop `day` equals the ordinal day (1‑based).  
2. **Determine the overlapping window**  
   - `start = Math.max(aStart, bStart)` picks the later of the two arrivals.  
   - `end   = Math.min(aEnd,   bEnd)` picks the earlier of the two departures.  
   - Loop invariant: after step 2, `[start, end]` is the maximal possible common interval; if the invariant fails (`start > end`) the intervals are disjoint.  
3. **Handle disjoint intervals**  
   - If `start > end`, return 0 immediately. The `if` guard uses `>` (not `>=`) because the intervals are inclusive; equality means a single shared day.  
4. **Compute the length of the intersection**  
   - Return `end - start + 1`. The `+1` compensates for inclusive bounds, turning a difference of zero into a length of one day.  

Edge cases covered:  
- Empty or single‑day intervals are handled because conversion yields the same integer for arrival and leave, and the `+1` formula still works.  
- Even vs. odd‑length intervals need no special treatment; the max/min logic is symmetric.  
- No overflow concerns because the largest possible day number is 365, well within `int` range.

## Dry Run  
**Input**: `arriveAlice = "08-15", leaveAlice = "08-18", arriveBob = "08-16", leaveBob = "08-19"`

| Step | aStart | aEnd | bStart | bEnd | start | end | Action / Note |
|------|--------|------|--------|------|-------|-----|----------------|
| 1    | 227    | 230  | 228    | 231  | –     | –   | `convert` adds month‑prefix sums (Jan‑Jul = 212) then day |
| 2    | –      | –    | –      | –    | 228   | 230 | `start = max(227,228)`, `end = min(230,231)` |
| 3    | –      | –    | –      | –    | 228   | 230 | `start ≤ end`, so intervals overlap |
| 4    | –      | –    | –      | –    | –     | –   | Return `230‑228+1 = 3` |

The algorithm ends with `3`, which matches the three shared days (Aug 16‑18).

## Complexity  
- **Time:** O(1) – each `convert` runs at most 11 iterations (the number of months before the given month), and the remaining arithmetic is constant.  
- **Space:** O(1) – only a few integer variables are used; the output integer does not count toward extra space.

## Solution (Java)

```java
class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {

        int aStart = convert(arriveAlice);
        int aEnd = convert(leaveAlice);
        int bStart = convert(arriveBob);
        int bEnd = convert(leaveBob);

        int start = Math.max(aStart, bStart);
        int end = Math.min(aEnd, bEnd);

        if (start > end) {
            return 0;
        }

        return end - start + 1;
    }

    public int convert(String date) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3));

        for (int i = 0; i < month - 1; i++) {
            day += days[i];
        }

        return day;
    }
}
```

---

**Runtime** 0 ms (beats 100.0%) · **Memory** 42.3 MB (beats 95.1%)

<sub>Synced by AILeetHub on 2026-10-24.</sub>
