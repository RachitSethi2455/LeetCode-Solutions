# 570. Managers with at Least 5 Direct Reports

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/managers-with-at-least-5-direct-reports/)

`Database`

## Approach

Accepted medium solution in mysql.
Relevant topics: Database.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (mysql)

```sql
SELECT m.name
FROM Employee e
JOIN Employee m
ON e.managerId = m.id
GROUP BY m.id, m.name
HAVING COUNT(*) >= 5;
```

---

**Runtime** 364 ms · **Memory** 0.0B

<sub>Synced by AILeetHub on 2026-09-27.</sub>
