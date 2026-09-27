# 1378. Replace Employee ID With The Unique Identifier

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/replace-employee-id-with-the-unique-identifier/)

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
select ei.unique_id,e.name from
Employees as e left join EmployeeUNI as ei 
on e.id = ei.id
```

---

**Runtime** 1146 ms · **Memory** 0.0B

<sub>Synced by AILeetHub on 2026-09-27.</sub>
