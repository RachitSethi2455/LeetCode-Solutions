# Write your MySQL query statement below
select ei.unique_id,e.name from
Employees as e left join EmployeeUNI as ei 
on e.id = ei.id