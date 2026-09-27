# 1934. Confirmation Rate

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/confirmation-rate/)

`Database`

## Approach

Accepted medium solution in mysql.
Relevant topics: Database.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (mysql)

```sql
SELECT 
    s.user_id,
    ROUND(
        AVG(CASE WHEN c.action = 'confirmed' THEN 1 ELSE 0 END),
        2
    ) AS confirmation_rate
FROM Signups s
LEFT JOIN Confirmations c
ON s.user_id = c.user_id
GROUP BY s.user_id;
```

---

**Runtime** 656 ms · **Memory** 0.0B

<sub>Synced by AILeetHub on 2026-09-27.</sub>
