# 182. Duplicate Emails

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/duplicate-emails/)

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
Select email from Person
Group by email
Having count(email) >1;
```

---

**Runtime** 527 ms · **Memory** 0.0B

<sub>Synced by AILeetHub on 2026-03-07.</sub>
