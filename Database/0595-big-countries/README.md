# 595. Big Countries

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/big-countries/)

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
Select name,population,area from world
where area >= 3000000 or population >= 25000000
```

---

**Runtime** 289 ms · **Memory** 0.0B

<sub>Synced by AILeetHub on 2026-09-27.</sub>
