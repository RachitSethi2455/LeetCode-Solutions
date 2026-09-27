# 1068. Product Sales Analysis I

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/product-sales-analysis-i/)

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
select p.product_name,s.year,s.price from
Sales as s join Product as p
on s.product_id = p.product_id 
```

---

**Runtime** 1209 ms · **Memory** 0.0B

<sub>Synced by AILeetHub on 2026-09-27.</sub>
