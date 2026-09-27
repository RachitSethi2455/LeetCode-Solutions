# 1757. Recyclable and Low Fat Products

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/recyclable-and-low-fat-products/)

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
Select product_id from Products
where low_fats = 'Y' and recyclable = 'Y'

```

---

**Runtime** 598 ms · **Memory** 0.0B

<sub>Synced by AILeetHub on 2026-09-27.</sub>
