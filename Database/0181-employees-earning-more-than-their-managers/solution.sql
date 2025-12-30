# Write your MySQL query statement below
Select e.name as Employee
From Employee e
Join Employee m
on e.managerId = m.Id
where e.salary > m.salary
and e.managerId is not null;