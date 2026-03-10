# 183. Customers Who Never Order

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/customers-who-never-order/)

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
SELECT c.name as Customers
FROM Customers c
LEFT JOIN Orders o
ON c.id = o.customerId
WHERE o.id IS NULL;
```

---

**Runtime** 572 ms · **Memory** 0.0B

<sub>Synced by AILeetHub on 2026-03-10.</sub>
