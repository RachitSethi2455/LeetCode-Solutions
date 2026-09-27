# 1148. Article Views I

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/article-views-i/)

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
select distinct author_id as id from Views
where author_id = viewer_id
order by author_id
```

---

**Runtime** 509 ms · **Memory** 0.0B

<sub>Synced by AILeetHub on 2026-09-27.</sub>
