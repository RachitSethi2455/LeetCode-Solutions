# 620. Not Boring Movies

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/not-boring-movies/)

`Database`

## Approach

Accepted easy solution in mysql.
Relevant topics: Database.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (mysql)

```sql
# Write your MySQL query statement below
Select * from Cinema
Where id % 2 =1
And description != "boring"
Order By rating desc;
```

---

**Runtime** 226 ms · **Memory** 0.0B

<sub>Synced by AILeetHub on 2025-12-30.</sub>
