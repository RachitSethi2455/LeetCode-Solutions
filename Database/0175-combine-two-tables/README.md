# 175. Combine Two Tables

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/combine-two-tables/)

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
Select firstname,lastname,city,state 
From Person
Left Join Address
On Person.personId=Address.personId;
```

---

**Runtime** 367 ms · **Memory** 0.0B

<sub>Synced by AILeetHub on 2025-12-30.</sub>
