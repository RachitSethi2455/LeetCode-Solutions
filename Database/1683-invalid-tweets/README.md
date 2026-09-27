# 1683. Invalid Tweets

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/invalid-tweets/)

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
select tweet_id from Tweets
where length(content) > 15
```

---

**Runtime** 599 ms · **Memory** 0.0B

<sub>Synced by AILeetHub on 2026-09-27.</sub>
