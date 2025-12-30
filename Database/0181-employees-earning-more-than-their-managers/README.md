# 181. Employees Earning More Than Their Managers

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/employees-earning-more-than-their-managers/)

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
Select e.name as Employee
From Employee e
Join Employee m
on e.managerId = m.Id
where e.salary > m.salary
and e.managerId is not null;
```

---

**Runtime** 389 ms · **Memory** 0.0B

<sub>Synced by AILeetHub on 2025-12-30.</sub>
